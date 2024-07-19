import java.awt.event.*;

public class ControladorLyrics implements ActionListener {

    private Cancion song;
    private VistaLyrics heartcatch;

    public ControladorLyrics(Cancion s, VistaLyrics kokoro) {
	this.song = s;
	this.heartcatch = kokoro;

	heartcatch.agregarActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
	String event = e.getActionCommand();
	heartcatch.lyrics.setText(song.getLyrics(event));
    }


}