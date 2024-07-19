import java.io.File;
import java.util.Vector;
public class TestXml
{

    public static void main(String[] args)
    {
	XmlReader x = new XmlReader();
	String path = "data/lyrics/";
	Cancion song;
	File f = new File(path + "昼の星に.xml");
	song = x.readXml(f);


    }

}