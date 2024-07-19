/**
 * @author Jesus Antonio Soto
 * @version 1.0
 * @since 2011-September
 */
import java.io.*;
import java.util.*;
public class XmlWriter {
    /**
     * Path donde se guardara el archivo xml.
     */
  private String initPath;
    /**
     * Constructor
     * @param path a asignar.
     */
  public XmlWriter(String path) {
    this.initPath = path;
  }
    /**
     * Escribe archivo XML en el directorio de initPath, dada la cancion.
     * @param song que se va a serializar
     * @throws IOException
     */
  public void writeXml(Cancion song) {
      int i = 0;
      int keyCounter = song.getLyricsTable().size();
      Enumeration en = song.getLyricsTable().keys();
      Enumeration enu = song.getLyricsTable().elements();
      String[] keys = null;
/*      while(en.hasMoreElements()) {	
	keys[i] = en.nextElement();
	i++;
      }*/
//      System.out.println(en);

//	System.out.println(keyCounter); bien!
    /*String clean;
    StringTokenizer str = new StringTokenizer(song.title, "~';[],./");
    while(str.hasMoreTokens()) {
      clean = clean + str.nextElement();
    }
    song.lyricsPath = clean + ".xml"; */ // Ya se hizo en el constructor
    /*OutputStream fileout = new FileOutputStream(song.lyricsPath);
     OutputStream bout = new BufferedOutPutStream(fileout);
    OutputStreamWriter out 
    try {
	File f = new File(initPath + song.getLyricsPath() + ".xml");
	FileOutputStream fs = new FileOutputStream(f);
	PrintWriter prtwrt = new PrintWriter(fs);
	prtwrt.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
	prtwrt.println("<song>");
	prtwrt.println("<title>" + song.getTitle() + "</title>");
	prtwrt.println("<artist>" + song.getArtist() + "</artist>");
	prtwrt.println("<tags>" + song.getTags() + "</tags>");
	prtwrt.println("<source>" + song.getSource() + "</source>");
/*	for(i=0, en = song.getLyricsTable().keys(); en.hasMoreElements(); i++) {
	    keys[i] = (String)en.nextElement();
	    prtwrt.println("<lyrics lang=" + keys[i] + ">" + song.getLyricsTable().get(keys[i]) + "</lyrics>");
	}
	prtwrt.println("</song>");
	prtwrt.close();
	System.out.println(keys[1]); 
    } catch(Exception e) {
	System.out.println("Error: " + e.getMessage());
      } */

  try{
  	File f=new File(initPath + song.getLyricsPath() + ".xml");
  	FileOutputStream fs=new FileOutputStream(f);
  	PrintWriter pw=new PrintWriter(fs);
	String artist, source;
	artist = song.getArtist();
	source = song.getSource();
	if(artist==null) artist = "N/A";
	if(source==null) source = "N/A";

  	pw.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
	pw.println("<song>");
	pw.println("  <title>" + song.getTitle() + "</title>");
	pw.println("  <artist>" + artist + "</artist>");
	pw.println("  <tags>" + song.getTags() + "</tags>");
	pw.println("  <source>" + source + "</source>");
/*	for(i=0, en = song.getLyricsTable().keys(); en.hasMoreElements(); i++) {
	    //keys[i] = (String)en.nextElement();
	    pw.println("<lyrics lang=Ja" + song.getLyricsTable().get(keys[i]) + "</lyrics>");
	} */
/*	while(en.hasMoreElements()) {
	  pw.println("<lyrics lang=\"Ja\">" + song.getLyricsTable().get(en.nextElement()) + "</lyrics>");
	} */
	while(en.hasMoreElements() && enu.hasMoreElements()) {
	  pw.println("  <lyrics lang=\""+ en.nextElement() + "\">" + enu.nextElement() + "</lyrics>");
	}
	pw.println("</song>");
  	pw.close();
  }catch(Exception e){
	System.out.println("Error: " + e.getMessage());
   }
  }

    /**
     * Lee el archivo XML para recuperar los atributos serializados.
     * @param path del archivo XML
     * @return Objeto Cancion con los atributos recreados.
     */
}
