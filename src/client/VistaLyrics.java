import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Hashtable;
import java.util.Enumeration;

public class VistaLyrics {

    JFrame frame;
    JPanel menu;
    JButton[] idiomas;
    String[] lang;
    JPanel content;
    JLabel header;
    JTextArea lyrics;
    JScrollPane lyricScroller;
    JPanel top;

    public VistaLyrics(Cancion song) {
	frame = new JFrame();
	menu = new JPanel();
	content = new JPanel();
	header = new JLabel(song.getTitle() + " - " +song.getArtist());
	lyrics = new JTextArea(30, 40);
	lyrics.setLineWrap(true);
	top = new JPanel();

	lyricScroller = new JScrollPane(lyrics);
	lyricScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	lyricScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	Color menuBg = new Color(0, 235, 156);
	menu.setBackground(menuBg);
	
	int i = 0;
	lang = new String[15];
	Enumeration keys = song.getLyricsTable().keys();
	idiomas = new JButton[15];
	while(keys.hasMoreElements()) {
	    lang[i] = (String)keys.nextElement();
	    idiomas[i] = new JButton(lang[i]);
	    idiomas[i].setPreferredSize(new Dimension(100, 140));
	    menu.add(idiomas[i]);
	    i++;
	}
	lyrics.setText((String)song.getLyricsTable().get(lang[0]));
	lyrics.setEditable(false);
	menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
	content.setBackground(Color.GRAY);
	content.add(lyricScroller);
	top.setBackground(Color.white);
	top.add(header);
	frame.getContentPane().add(BorderLayout.NORTH, top);
	frame.getContentPane().add(BorderLayout.WEST, menu);
	frame.getContentPane().add(BorderLayout.CENTER, content);
	frame.setTitle("Lyrics");
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.setSize(800,600);
	frame.pack();
	frame.setResizable(false);
	frame.setVisible(true);

  }

    public void agregarActionListener(ActionListener listener) {
	int i;
	for(i=0; i<lang.length; i++) {
	    if(idiomas[i]!=null) {
		idiomas[i].addActionListener(listener);
		idiomas[i].setActionCommand(lang[i]);
		}
	}
    }
}