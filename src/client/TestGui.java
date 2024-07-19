public class TestGui {

    public static void main(String [] args) {
	LocalSongCollection col = LocalSongCollection.getInstance();
	col.reloadCollection("data/lyrics/");
	col.printCollection();
	//	col.printCollection();
	VistaOracion vista = new VistaOracion(col.getCanciones());
	//	VistaLyrics letra = new VistaLyrics(aishiteru);
	//	ControladorLyrics control = new ControladorLyrics(aishiteru, letra);

    }

}