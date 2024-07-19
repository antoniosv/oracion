import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import java.util.Enumeration;

public class VistaOracion {

    JFrame frame;
    JPanel topPanel;
    JButton bConexion;
    JLabel header;
    JTextField busquedaF;
    JButton bBusqueda;
    JTable listado;
    JLabel orderAbc;
    JLabel orderBy;
    JButton bTitulo;
    JButton bArtista;
    JButton bTop;
    JScrollPane tScroller;
    JSlider Abc;
    JPanel tPanel;
    JButton newSong;
    JPanel mainPanel;
    JPanel lowPanel;
    JPanel sortPanel;
    JPanel columns;
    JPanel[] rows;
    JButton[] languages;
    JButton[] edit;
    JLabel cTitle, cArtist, cLyrics;
    String[] buttonKeys;
    Dimension centerPanelDimension;
    JButton refresh;
    private Vector utauta;
    JPanel options;

    public VistaOracion(Vector utauta) {
	this.utauta = utauta;
	frame = new JFrame();
	topPanel = new JPanel();
	bConexion = new JButton("Connect");
	header = new JLabel("Lyrics Directory");
	busquedaF = new JTextField("Type song title or artist name", 25);
	bBusqueda = new JButton("Search");
	orderAbc = new JLabel("Filter");
	orderBy = new JLabel("Order by:");
	bTitulo = new JButton("Song title");
	bArtista = new JButton("Artist name");
	bTop = new JButton("Top 15"); 
	Abc = new JSlider(1, 27);
	tPanel = new JPanel();
	newSong = new JButton("Submit new lyrics");
	refresh = new JButton("Refresh list");
	mainPanel = new JPanel();
	//	centerPanelDimension = new Dimension(60, 200);
	lowPanel = new JPanel();
	sortPanel = new JPanel();
	cTitle = new JLabel("Title              |", JLabel.LEFT);
	cArtist = new JLabel("Artist            |", JLabel.CENTER);
	cLyrics = new JLabel("Lyrics", JLabel.RIGHT);
	columns = new JPanel();
	options = new JPanel();

	Color bgColor = new Color(153, 204, 255);

	columns.setBackground(bgColor);
	columns.add(cTitle);
	columns.add(cArtist);
	columns.add(cLyrics);

	topPanel.setBackground(bgColor);
      	topPanel.add(bConexion);
	topPanel.add(busquedaF);
	topPanel.add(bBusqueda);

	options.setBackground(bgColor);
	options.add(newSong);
	options.add(refresh);

	tPanel.setBackground(bgColor);
	tPanel.add(header);
	tPanel.add(topPanel);
	tPanel.add(options);
	tPanel.setLayout(new BoxLayout(tPanel, BoxLayout.Y_AXIS));

	sortPanel.setBackground(bgColor);
	sortPanel.add(bTitulo);
	sortPanel.add(bArtista);
	sortPanel.add(bTop);

	lowPanel.add(orderAbc);
	lowPanel.add(Abc);
	lowPanel.add(orderBy);
	lowPanel.add(sortPanel);
	lowPanel.setLayout(new BoxLayout(lowPanel, BoxLayout.Y_AXIS));
	mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
	//mainPanel.setPreferredSize(centerPanelDimension);
	mainPanel.setBackground(Color.white);
	tPanel.add(columns);
	System.out.println(utauta.size());
	Cancion c = (Cancion)utauta.get(0);
	System.out.println(c.getTitle());
	rows = generateList(utauta);
	//	for(int j=0; j<utauta.size() && j<15; j++)
	for(int j=0; j<utauta.size(); j++)
	    {
		mainPanel.add(rows[j]);
	    }
	tScroller = new JScrollPane(mainPanel);
	tScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	tScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	frame.getContentPane().add(BorderLayout.NORTH, tPanel);
	frame.getContentPane().add(BorderLayout.CENTER, tScroller);
	frame.getContentPane().add(BorderLayout.SOUTH, lowPanel);
	//frame.getContentPane().add(BorderLayout.NORTH, topPanel);
	busquedaF.requestFocus();
	busquedaF.grabFocus();
	busquedaF.selectAll();
	frame.setSize(700,600);
	frame.setVisible(true);
	//	frame.pack();
	frame.setResizable(false);
	frame.setTitle("Oracion");
 	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JPanel[] generateList(Vector songs)
    {
	JPanel[] list;
	JLabel[] titles;
	JLabel[] artists;
	int size = songs.size();
	titles = new JLabel[size];
	artists = new JLabel[size];
	languages = new JButton[size];
	edit = new JButton[size];
	list = new JPanel[size];
	Cancion lullaby = null;
	//	buttonKeys = new String[size];
	//	for(int i=0; i<size && i<15; i++)
	for(int i=0; i<size; i++)
	    {
		// causa excepcion..buttonKeys[i] = null;
		System.out.println(i);
		lullaby = (Cancion)songs.get(i);
		System.out.println("paso aqui");
		System.out.println(lullaby.getTitle());
		System.out.println(titles.length);
		String text = lullaby.getTitle();
		titles[i] = new JLabel(text + "  |  ");
		System.out.println("paso aqui");
		artists[i] = new JLabel(lullaby.getArtist() + "  |  ");
		System.out.println("paso aca");
		Enumeration keys = lullaby.getLyricsTable().keys();
		// aqui truena ^ porque no esta la letra cargada en la coleccion.. hay que checar el XmlReader
		String idiomas = "";
		System.out.println("woah");
		while(keys.hasMoreElements()) {
		    idiomas = idiomas + "  [" + (String)keys.nextElement() + "]";
		    System.out.println(idiomas);
		}
		System.out.println("paso aqui");
		languages[i] = new JButton(idiomas);
		edit[i] = new JButton("Edit");
		list[i] = new JPanel();
		list[i].setBackground(Color.white);
		list[i].add(titles[i]);
		list[i].add(artists[i]);
		list[i].add(languages[i]);
		list[i].add(edit[i]);
	    }
	return list;
    }

    public void refreshList(Vector songs)
    {
	//	mainPanel.removeAll();
	tScroller.setVisible(false);
	mainPanel.removeAll();
	tScroller.removeAll();
	frame.remove(tScroller);
	tScroller = null;
	mainPanel = null;
	rows = null;
	mainPanel = new JPanel();
	mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
	rows = new JPanel[songs.size()];
	rows = generateList(songs);
	for(int j=0; j<songs.size(); j++)
	    {
		mainPanel.add(rows[j]);
	    }
	mainPanel.validate();
	tScroller = new JScrollPane(mainPanel);
	tScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	tScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	tScroller.validate();
	frame.getContentPane().add(BorderLayout.CENTER, tScroller);
	frame.validate();
	tScroller.setVisible(true);
    }



    public void agregarActionListener(ActionListener listener)
    {
	bConexion.addActionListener(listener);
	bBusqueda.addActionListener(listener);
	bTitulo.addActionListener(listener);
	bArtista.addActionListener(listener);
	bTop.addActionListener(listener);
	newSong.addActionListener(listener);
	//	Abc.addActionListener(listener);
	refresh.addActionListener(listener);

	int size = utauta.size();
	for(int i=0; i<size; i++) {
	    languages[i].addActionListener(listener);
	    String num = Integer.toString(i);
	    languages[i].setActionCommand(num);
	    String editBtn = "b"+num;
	    edit[i].addActionListener(listener);
	    edit[i].setActionCommand(editBtn);
	}
	bConexion.setActionCommand("connect");
	bBusqueda.setActionCommand("search");
	bTitulo.setActionCommand("orderTitle");
	bArtista.setActionCommand("orderArtist");
	bTop.setActionCommand("showTop");
	newSong.setActionCommand("submit");
	//	Abc.setActioncommand("orderABC");
	refresh.setActionCommand("refresh");
    }
}