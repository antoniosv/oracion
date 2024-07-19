/**
 * @author Jesus Antonio Soto
 * @version 1.0
 * @since 2011-August
 */
import java.util.*;
import java.io.*;
public class Cancion 
{
    /**
     * Titulo de la cancion.
     */
  private String title;
    /**
     * Artista de la cancion.
     */
  private String artist;
    /**
     * Fuente de la letra de la cancion.
     */
  private String source;
    /**
     * Tags de la cancion: titulo, artista y extra.
     */
  private String tags;
    /**
     * Ubicacion de la cancion.
     */
  private String lyricsPath;
    /**
     * Tabla de dispersion idioma - letra
     */
  private Hashtable lyricsTable;
  
    /**
     * Constructor
     * @param titulo de la cancion
     */
  public Cancion(String titulo)
  {
	this.title = titulo;
	this.artist = null;
	this.source = null;
	this.setTags(title);
	this.setLyricsPath();
	this.lyricsTable = new Hashtable();
  }
    /** Constructor
     * @param titulo de la cancion
     * @param artista de la cancion
     */
  public Cancion(String titulo, String artista)
  {
	this.title = titulo;
	this.artist = artista;
	this.source = null;
	this.setTags(titulo + " " + artista);
	this.setLyricsPath();
	this.lyricsTable = new Hashtable();
  }
    /**
     * Constructor
     * @param titulo de la cancion.
     * @param artista de la cancion.
     * @param fuente de la letra.
     */
  public Cancion(String titulo, String artista, String fuente)
  {
	this.title = titulo;
	this.artist = artista;
	this.source = fuente;
	this.setTags(titulo + " " + artista);
	this.setLyricsPath();
	this.lyricsTable = new Hashtable();
  }
    public Cancion()
    {
	this.title = "N/A";
	this.artist = "N/A";
	this.lyricsTable = new Hashtable();
    }
    /**
     * Obtiene la letra correspondiente al idioma.
     * @param lang idioma de la letra solicitada
     * @return Letra de la cancion en el idioma solicitado.
     * @throws NullPointerException
     */
  public String getLyrics(String lang)
  {
      try {
	  return (String)lyricsTable.get(lang);
      } catch(NullPointerException e) {
	  System.out.println("Error: " + e.getMessage());
      }
      return "";
  }
    /**
     * @return Hashtable de letras.
     */
  public Hashtable getLyricsTable()
  {
    return lyricsTable;
  }
    /**
     * @return Nombre de artista.
     */
  public String getArtist()
  {
    return artist;
  }
    /**
     * @return Titulo de cancion.
     */
  public String getTitle()
  {
    return title;
  }
    /**
     * @return Fuente de la letra.
     */
  public String getSource()
  {
    return source;
  }
    /**
     * @return Tags de la cancion.
     */
  public String getTags()
  {
    return tags;
  }
    /**
     * @return Path de la cancion
     */
  public String getLyricsPath()
  {
    return lyricsPath;
  }
    /**
     * A&ntilde;ade nueva letra a la cancion.
     * @param idioma de la letra.
     * @param letra de cancion.
     */
  public void addLyrics(String idioma, String letra)
  {
    this.lyricsTable.put(idioma, letra);
	return;
  }
    /**
     * @param titulo de la cancion.
     */
  public void setTitle(String titulo)
  {
    this.title = titulo;
    this.setTags(title + " " + this.artist);
    return;
  }
    /**
     * @param artista de la cancion
     */
  public void setArtist(String artista)
  {
    this.artist = artista;
    this.setTags(artista + " " + this.title);
	return;
  }  
    /**
     * @param source de la letra.
     */
  public void setSource(String source)
  {
    this.source = source;
	return;
  }
    /**
     * @param etiquetas de la cancion
     */
  public void setTags(String etiquetas)
  {
    this.tags = etiquetas;
    return;
  }   
    /**
     * Asigna path de la letra usando el titulo de la cancion.
     */
  public void setLyricsPath()
  {
      StringTokenizer corto = new StringTokenizer(this.title, " ~!@#$%^&*_+=-[]{};'.,<>");
      int i = 0;
      this.lyricsPath = "";
      while(corto.hasMoreTokens()) {
	  if(i==0) {
	      this.lyricsPath = corto.nextToken().toLowerCase();
	      i++;
	  }
	  else {
	      this.lyricsPath = this.lyricsPath + "_" + corto.nextToken().toLowerCase(); 
	  }
      }

      /* Esto es con split.
    String[] tokens = this.title.split("\\s");
    //    this.lyricsPath = "/lyrics/";
    for(int i=0; i<tokens.length; i++) {
	this.lyricsPath = lyricsPath + tokens[i];
	} */
    return;
  }

    public void getLanguages() {

	// va string[]
	return;
    }

}
