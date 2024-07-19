import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.util.Vector;
public class ControladorSubmit implements ActionListener
{
    private VistaSubmit vista;
    private LocalSongCollection local;

    public ControladorSubmit(VistaSubmit vista, LocalSongCollection local)
    {
	this.vista = vista;
	this.local = local;
	vista.agregarActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
	String evento = e.getActionCommand();
	if(evento.equals("submit"))
	   {
	       String title = vista.tTitle.getText();
	       String artist = vista.tArtist.getText();
	       String source = vista.tSrc.getText();
	       String tags = vista.tTags.getText();
	       String language = (String)vista.boxLang.getSelectedItem();
	       String lyrics = vista.lyrics.getText();
	       Boolean exists = false;
	       Vector canciones = local.getCanciones();
	       int indice;
	       Cancion newSong = null;
	       for(int j=0; j<canciones.size(); j++) {
		   String titleOld = ((Cancion)canciones.get(j)).getTitle();
		   System.out.println(title + " vs " + titleOld);
		   if(title.equals(titleOld)) {
		       exists = true;
		       newSong = (Cancion)canciones.get(j);
		       canciones.remove(j);
		       indice = j;
		       break;
		   }
	       }		  
	       if(title.equals("") || title.length()<3) {
		   //		   System.out.println("Vacioo");
		   JFrame frame = new JFrame();
		   JOptionPane.showMessageDialog(frame, "Must input longer song title");
	       }
	       else if (language == null || lyrics.length()<4 || language.length()<2)
		   {
		       System.out.println("Nada que guardar");
		       JFrame frame = new JFrame();
		       JOptionPane.showMessageDialog(frame, "Must have language selected and appropriate lyrics");
		   }
	       else if(exists) {
		   System.out.println("Si existe, yay!");
		   //((Cancion)canciones.get(indice)).addLyrics(language, lyrics);
		   //XmlWriter writer = new XmlWriter();
		   newSong.addLyrics(language, lyrics);
		   newSong.setArtist(artist);
		   local.addToCollection(newSong);
		   System.out.println("Se hizo update de la cancion o:");
		   vista.frame.dispose();
	       }
	       else {
		   //Cancion newSong;
		   if(artist.length()>1 && source.length()>1)
		       newSong = new Cancion(title, artist, source);
		   else if(artist.length()>1)
		       newSong = new Cancion(title, artist);
		   else
		       newSong = new Cancion(title);
		   if(tags.length()>2)
		       newSong.setTags(tags + title + artist);
		   newSong.addLyrics(language, lyrics);
		   local.addToCollection(newSong);
		   System.out.println("Todo bien ;D");
		   vista.frame.dispose();
	       }
	       System.out.println(title+artist+source+tags+lyrics);
	   }

	if(evento.equals("nuevo"))
	    {
		String inputLang = JOptionPane.showInputDialog("New language for lyrics:");
		vista.boxLang.addItem(inputLang);
		vista.boxLang.setSelectedItem(inputLang);
		vista.lyrics.setText("");
		int totalItems = vista.boxLang.getItemCount();

	    }

	if(evento.equals("cancel"))
	    {
		vista.frame.dispose();
	    }

	if(evento.equals("delete"))
	    {
		JFrame frame = new JFrame();
		int answer = JOptionPane.showConfirmDialog(frame, "Are you sure you want\n to delete the lyrics?", "Delete confirmation", JOptionPane.YES_NO_OPTION);
		System.out.println(answer);
		// yes = 0, no = 1
		if(answer==0) {
		    String language = (String)vista.boxLang.getSelectedItem();
		    String title = vista.tTitle.getText();
		    Vector canciones = local.getCanciones();
		    Cancion c;
		    for(int i=0; i<canciones.size(); i++) {
			c = (Cancion)canciones.get(i);
			if(title.equals(c.getTitle())) {
			    System.out.println("Borrando " + language + " de: " + title);
			    c.getLyricsTable().remove(language);

			}
		    }			

		}

	    }

    }
}