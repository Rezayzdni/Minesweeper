import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class Sound {
	public static Clip clip;
	public static void playSound(String fileName) throws MalformedURLException, LineUnavailableException, UnsupportedAudioFileException, IOException{
	    File url = new File(fileName);
	    clip = AudioSystem.getClip();

	    AudioInputStream ais = AudioSystem.
	        getAudioInputStream( url );
	    clip.open(ais);
	   clip.start();
	
	}

}