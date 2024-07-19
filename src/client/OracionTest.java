import java.util.*;
public class OracionTest {

    public static void main(String[] args)
    {
	LocalSongCollection emyr = LocalSongCollection.getInstance();
	Cancion yokogao = new Cancion("Yokogao", "Yui Makino", "www.gendou.com");
	yokogao.addLyrics("ja", "この場所に訪れたなら　両手広げてうけとめて");
	yokogao.addLyrics("En", "If you come to this place with your arms wide open, you can catch it in your hands");
	Cancion aladin = new Cancion("A whole new world");
	aladin.addLyrics("En", "I want to show you the world~");
	aladin.addLyrics("Es", "Fabulosa vision, sentimiento divino..");
	XmlWriter uno = new XmlWriter(args[0]);
	uno.writeXml(yokogao);
	uno.writeXml(aladin);
	emyr.addToCollection(aladin);
	emyr.addToCollection(yokogao);
	System.out.println(emyr.toString());
       	Hashtable ht = (emyr.searchSong("yokogao"));
	Enumeration en = ht.keys();
	int i = 0;
	while(en.hasMoreElements()) {
	    Cancion c;
	    i++;
	    c = (Cancion)en.nextElement();
	    System.out.println(i +".- "+ c.getTitle());	 
	    }
	}
}
