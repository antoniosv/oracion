import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Hashtable;
import java.util.Enumeration;

public class VistaSubmit
{
    JFrame frame;
    JPanel pTitle, pArtist, pLang, pSrc, pTags, pChoice;
    JLabel lTitle, lArtist, lLang, lyricsLabel, lSrc, lTags, lHeader;
    JTextField tTitle, tArtist, tSrc, tTags;
    JComboBox boxLang;
    JButton bLang, bSubmit, bCancel, bDelete;
    JTextArea lyrics;
    JScrollPane lyricsScroller;

    public VistaSubmit()
    {
	frame = new JFrame();
	lHeader = new JLabel("New song");
	
	lTitle = new JLabel("Title ");
	tTitle = new JTextField(20);
	pTitle = new JPanel();
	pTitle.setBackground(Color.white);
	pTitle.add(lTitle);
	pTitle.add(tTitle);

	lArtist = new JLabel("Artist");
	tArtist = new JTextField(20);
	pArtist = new JPanel();
	pArtist.setBackground(Color.white);
	pArtist.add(lArtist);
	pArtist.add(tArtist);	

	lLang = new JLabel("Language ");
	boxLang = new JComboBox();
	bDelete = new JButton("Delete");
	bLang = new JButton("Add language");
	pLang = new JPanel();
	pLang.setBackground(Color.white);
	pLang.add(lLang);
	pLang.add(boxLang);
	pLang.add(bLang);

	lyricsLabel = new JLabel("Lyrics");
	lyrics = new JTextArea(30, 30);
	lyricsScroller = new JScrollPane(lyrics);
	lyricsScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	lyricsScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

	lSrc = new JLabel("Source ");
	tSrc = new JTextField(25);
	pSrc = new JPanel();
	pSrc.setBackground(Color.white);
	pSrc.add(lSrc);
	pSrc.add(tSrc);

	lTags = new JLabel("Tags ");
	tTags = new JTextField(25);
	pTags = new JPanel();
	pTags.setBackground(Color.white);
	pTags.add(lTags);
	pTags.add(tTags);

	bSubmit = new JButton("Submit");
	bCancel = new JButton("Cancel");
	pChoice = new JPanel();
	pChoice.setBackground(Color.white);
	pChoice.add(bSubmit);
	pChoice.add(bCancel);
    }

    public void loadSong(Cancion song)
    {
	pLang.add(bDelete);
	lHeader.setText("Edit lyrics");
	tTitle.setText(song.getTitle());
	tArtist.setText(song.getArtist());
	tSrc.setText(song.getSource());
	tTags.setText(song.getTags());
	String[] lang = new String[15];
	Enumeration keys = song.getLyricsTable().keys();
	int i = 0;
	while(keys.hasMoreElements()) {
	    lang[i] = new String();
	    lang[i] = (String)keys.nextElement();
	    System.out.println(lang[i]);
	    boxLang.addItem(lang[i]);
	    i++;
	}
	lyrics.setText((String)song.getLyricsTable().get(lang[0]));

    }

    public void drawForm()
    {
	Container pane = frame.getContentPane();
	pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
	pane.add(lHeader);
	pane.add(pTitle);
	pane.add(pArtist);
	pane.add(pLang);
	pane.add(lyricsLabel);
	pane.add(lyricsScroller);
	pane.add(pSrc);
	pane.add(pTags);
	pane.add(pChoice);
	frame.setTitle("Add new lyrics");
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.setSize(400,600);
	frame.setResizable(false);
	frame.setVisible(true);
    }

    public void agregarActionListener(ActionListener listener)
    {
	bSubmit.addActionListener(listener);
	bCancel.addActionListener(listener);
	bLang.addActionListener(listener);
	boxLang.addActionListener(listener);
	bDelete.addActionListener(listener);

	bDelete.setActionCommand("delete");
	bSubmit.setActionCommand("submit");
	bCancel.setActionCommand("cancel");
	bLang.setActionCommand("nuevo");
	boxLang.setActionCommand("box");
    }

}