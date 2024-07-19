/**
 * @author Jesus Antonio Soto
 * @version 1.0
 * @since 2011-August
 */
import java.util.Hashtable;
public abstract class SongCollection
{
    /**
     * Contador de canciones en la coleccion
     */
    protected int songCounter;
    /**
     * Arreglo de strings con lenguajes posibles para letras de canciones
     */
    protected String[] languages;
    /**
     * Constructor
     */
  public SongCollection()
  {
    this.songCounter = 0;
    this.languages = new String[10];
    this.languages[0] = "en";
    this.languages[1] = "es";
    this.languages[2] = "ja";
    this.languages[3] = "ja-romaji";
    this.languages[3] = "fr";
  }
    /**
     * A&ntilde;ade nueva cancion a la colecci&oacute;n.
     * @param song a insertar a la colecci&oacute;n.
     */
    public abstract void addToCollection(Cancion song);
    /**
     * Borra cancion de la colecci&oacute;n.
     * @param song a ser borrada.
     */
    public abstract void deleteFromCollection(Cancion song);
    /**
     * Busca una cancion de la coleccion, dada una pista.
     * @param hint con el que se buscara la cancion.
     * @return Genera una tabla de dispersion conteniendo las canciones encontradas, con el numero de coincidencias.
     */
    public abstract Hashtable searchSong(String hint);
    /**
     * Edita los contenidos de una cancion existente.
     * @param vieja cancion actual que va a ser editada.
     * @param nueva cancion con los datos ya editados.
     */
    public abstract void editSong(Cancion vieja, Cancion nueva);
}
