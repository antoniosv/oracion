import java.util.Vector;
public class OracionClient
{

    public static void main(String [] args)
    {
	LocalSongCollection local = LocalSongCollection.getInstance();
	local.reloadCollection("data/lyrics");
	//	local.addToCollection(OracionClient.defaultSong());
	Vector canciones = local.getCanciones();
	VistaOracion fractale = new VistaOracion(canciones);
	ControladorOracion nessa = new ControladorOracion(local, fractale);
    }

    public static Cancion defaultSong()
    {
	Cancion c = new Cancion("昼の星に", "Nessa", "Fractale");
	c.addLyrics("Romaji", "Hiru no hoshi ni\nNegai wo sasagu nara\nTsuzuku itami\nUkeireru kawari");
	return c;
    }

}