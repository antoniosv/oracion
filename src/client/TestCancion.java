import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import java.util.Vector;

public class TestCancion
{
    @Test
    public void pruebaTitulo()
    {   
	Cancion c = new Cancion("Tegami", "Angela Aki", "www.youtube.com");
	c.setTitle(null);
	assertNull(c.getTitle());

    }

    @Test
    public void pruebaCollectionSize()
    {
	LocalSongCollection local = LocalSongCollection.getInstance();
	local.reloadCollection("data/lyrics/");
	Vector canciones = local.getCanciones();
	int size = canciones.size();
	assertThat(size, is(9)); 
	// pues se tienen 9 archivos xml en el directorio

    }
}