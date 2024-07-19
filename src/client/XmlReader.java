import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.Vector;

public class XmlReader {

    public XmlReader() {
    }

    public Cancion readXml(File f) {
	Cancion s = null;
	Vector idiomas = new Vector(3,1);
	Vector lyrics = null;
	String daimei, sakusha, source, tags;
	daimei = sakusha = source = tags = null;
	int lyricsNum = 0;
	try{
	    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance(); //singleton?
	    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	    Document doc = dBuilder.parse(f);
	    doc.getDocumentElement().normalize(); //sera necesario?
	    System.out.println("Root: " + doc.getDocumentElement().getNodeName());
	    Element rootElement = doc.getDocumentElement();
	    NodeList nodes = rootElement.getChildNodes();

	    for(int i=0; i<nodes.getLength(); i++)
		{  		   
		    Node node = nodes.item(i);
		    if(node instanceof Element)
			{
			    Element child = (Element) node;	
			    String attr = child.getAttribute("lang");
			    int length = attr.length();
			    if(length>0) {
				System.out.println(length);
				idiomas.add(child.getAttribute("lang"));
			    }
			}
		}
	    System.out.println(idiomas);
	    lyricsNum = idiomas.size();
	    NodeList nList = doc.getElementsByTagName("song");
	    // Haciendo iteracion en caso de tener unificadas todas las canciones en un solo documento xml.
	    for(int temp=0; temp<nList.getLength(); temp++) {
		Node nNode = nList.item(temp);
		if(nNode.getNodeType() == Node.ELEMENT_NODE) {
		    Element eElement = (Element)nNode;
		    System.out.println("Title: " + getTagValue("title", eElement));
		    System.out.println("Artist: " + getTagValue("artist", eElement));
		    daimei = getTagValue("title", eElement);
		    // s.setTitle(getTagValue("title", eElement));
		    // s.setArtist(getTagValue("artist", eElement));
		    sakusha = getTagValue("artist",eElement);
		    // s.setTags(getTagValue("tags", eElement));
		    tags = getTagValue("tags", eElement);
		    // s.setSource(getTagValue("source", eElement));
		    source = getTagValue("source", eElement);
		    lyrics = getTagValues("lyrics", eElement, lyricsNum);
		    // System.out.println(lyrics);
		}
	    }
	} catch (Exception e) {
		e.printStackTrace();
	    }
	s = new Cancion(daimei, sakusha, source);
	s.setTags(tags);
	System.out.println(daimei + "\n" + sakusha + "\n" + source + "\n" + tags);
	for(int i=0; i<lyricsNum; i++) {
	    String idioma = (String)idiomas.get(i);
	    String letra = (String)lyrics.get(i);
	    System.out.println(idioma + " -> " + letra);
	    s.addLyrics(idioma, letra);
	}
	    return s;
    }

    public static String getTagValue(String tag, Element el) {
	NodeList nList = el.getElementsByTagName(tag).item(0).getChildNodes();
	Node nValue = (Node) nList.item(0);
	return nValue.getNodeValue();
    }

    public static Vector getTagValues(String tag, Element el, int times) {
	Vector lyrics = new Vector(3,1);
	for(int i=0; i<times; i++) {
	    NodeList nList = el.getElementsByTagName(tag).item(i).getChildNodes();
	    Node nValue = (Node) nList.item(0);
	    lyrics.add(nValue.getNodeValue());
	}
	return lyrics;
    }

}