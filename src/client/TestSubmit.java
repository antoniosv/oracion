public class TestSubmit
{
    public static void main(String [] args)
    {
	System.out.println("paso~");
	VistaSubmit challenger = new VistaSubmit();
	Cancion Fire = new Cancion("Fire!!", "Dualkey", "www.youtube.com");
	Fire.addLyrics("Español", "Se cumplira lo se, el triunfo ~~ Ardiendo esta, la llama al fin. \nLa victoria me pertecene ya!");
	Fire.addLyrics("English", "La la la la la lyar lyar your pants on fier!");
	Cancion Innocent = new Cancion("Inocencia", "Digimon", "http://www.musica.com/letras.asp?letra=1704943");
	Innocent.addLyrics("Espanol", "No importa lo lejos que te encuentres tu... \n\nHey! \n\nHe de llegar a ti, \nmiro al cielo para ver donde estas \nY pienso que talvez \nTu y yo lo mismo podemos ver \n\nMis sentimientos te alcanzaran, \nY en mi corazon lo guardo siempre y en el futuro! \n\nHa de florecer, \nel sueño sera una realidad. \nNo habra distancia que nos pueda separar. \n\nY la inocencia nos dara \nla fuerza que nos unira. \nY surgira con tu sonrisa la luz.");

	Innocent.addLyrics("Romaji", "Donna ni hanarete itemo...\n\nHey!\n\nMiageta sora Kimi wa tooi basho de\nOnaji keshiki Mitsumete iru no ka na\n\nTodokanai omoi o\nMune ni kizamitsuke hashitteta nda\n\nBokutachi ga yumemita ashita ni\nHibiku yo Kimi no warai goe\nDakara bokutachi ga atarashii kaze o\nOkosou Mujaki na mama de");

	//	challenger.loadSong(Innocent);
	//	challenger.drawForm();
	//	VistaSubmit newChallenger = new VistaSubmit();
	LocalSongCollection local = LocalSongCollection.getInstance();
	local.addToCollection(Innocent);
	local.addToCollection(Fire);
	VistaOracion fractale = new VistaOracion(local.getCanciones());
	ControladorOracion destiny = new ControladorOracion(local, fractale);
	//	ControladorSubmit controlSubmit = new ControladorSubmit(newChallenger, local);

	//	newChallenger.drawForm();
	System.out.println("hah?");
    }
}