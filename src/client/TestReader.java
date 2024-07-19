public class TestReader {

    public static void main(String [] args)
    {
	LocalSongCollection col = LocalSongCollection.getInstance();
	col.reloadCollection("data/lyrics/");
	col.printCollection();
    }
}