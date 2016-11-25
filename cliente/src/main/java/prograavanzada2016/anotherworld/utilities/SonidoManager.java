package prograavanzada2016.anotherworld.utilities;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SonidoManager {
	private static SonidoManager instance;
	private Clip sonido;
	private SonidoManager() throws LineUnavailableException{
		sonido = AudioSystem.getClip();
	}
	
	public static SonidoManager getInstance() throws LineUnavailableException{
		if(instance == null){
			instance =  new SonidoManager();
		}
		return instance;
	}
	
	
	public void setMusic(String path) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(path));
		sonido.open(inputStream);
	}
	
	public void play(){
		sonido.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void stop(){
		sonido.close();
	}
}

