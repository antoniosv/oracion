import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.Vector;
import java.util.Hashtable;
import java.util.Enumeration;

public class ControladorOracion implements ActionListener {
    private LocalSongCollection canciones;
    private VistaOracion fractale;
    private Vector lista;

    public ControladorOracion(LocalSongCollection col, VistaOracion face) {
	this.canciones = col;
	this.fractale = face;
	this.lista = col.getCanciones();
	fractale.agregarActionListener(this);	
    }

    public void actionPerformed(ActionEvent e) {
	String event = e.getActionCommand();
	if(event.equals("submit")) {
	    VistaSubmit newChallenger = new VistaSubmit();
	    ControladorSubmit controlChallenger = new ControladorSubmit(newChallenger, canciones);
	    newChallenger.drawForm();
	    // fractale.updateList(canciones);
	}
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
	if(event.equals("connect")) {
	    //	    JFrame frame = new JFrame();
	    //	    frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
	    JOptionPane.showMessageDialog(frame, "Feature not available yet </3");
	}

	if(event.equals("orderTitle")) {
	    JOptionPane.showMessageDialog(frame, "The cake");
	}

	if(event.equals("orderArtist")) {
	    JOptionPane.showMessageDialog(frame, "is a lie!");
	}

	if(event.equals("showTop")) {
	    JOptionPane.showMessageDialog(frame, "D:");
	}

	if(event.equals("refresh")) {
	    fractale.refreshList(lista);
	    fractale.agregarActionListener(this);
	}

	if(event.equals("search")) {
	    String clue = fractale.busquedaF.getText();
	    System.out.println("Searching: " + clue);
	    Hashtable results = canciones.searchSong(clue);
	    Enumeration keys = results.keys();
	    Vector resultList = new Vector(1,1);	 
	    Cancion c;
	    while(keys.hasMoreElements()) {
		c = (Cancion)keys.nextElement();
		System.out.println(c.getTitle());
		resultList.add(c);
	    }
	    System.out.println(resultList.size());
	    fractale.refreshList(resultList);
	    fractale.agregarActionListener(this);

	}

	for(int i=0; i<lista.size(); i++) {
	    String num = Integer.toString(i);
	    if(event.equals(num)) {
		System.out.println("Paso cancion: " + i);
		Cancion c = (Cancion)lista.get(i);
		VistaLyrics view = new VistaLyrics(c);
		ControladorLyrics viewControl = new ControladorLyrics(c, view);
	    }
	    if(event.equals("b"+num)) {
		//JOptionPane.showMessageDialog(frame, "Win!");
		System.out.println("Es la cancion: " + i);
		Cancion c = (Cancion)lista.get(i);
		VistaSubmit editSong = new VistaSubmit();
		ControladorSubmit editControl = new ControladorSubmit(editSong, canciones);
		editSong.loadSong(c);
		editSong.drawForm();
	    }
     	}
	        
    }
    
}