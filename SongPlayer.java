package musikSpelare;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SongPlayer{
	private Clip clip;
	private AudioInputStream stream;
	private long tempFrame;
	private File name;
	private String tempSong;

	/**
	 * takes in the path to a .wav file or path to the file and plays it as a clip
	 * 
	 * @param song
	 */
	public void player(String song){ 
		try {
			tempSong = song;
			name = new File(song);	
			stream = AudioSystem.getAudioInputStream(name); 
			clip = AudioSystem.getClip(); 
			clip.open(stream); 
			clip.loop(Clip.LOOP_CONTINUOUSLY); 
		}catch(Exception e){
			System.out.println(e);
		}
	}

	/**
	 * starts the clip
	 */
	public void play(){
		try{	
			clip.start();
		}catch(Exception e){
			System.out.println(e);
		}
	}

	/**
	 * pauses song
	 */
	public void pauseSong(){
		try {
			clip.close();
			this.tempFrame = this.clip.getMicrosecondPosition();
		}catch(Exception e){
			System.out.println(e);
		}
	}

	/*
	 *resumes a paused song 
	 */
	public void resumeSong(){
		try{
			clip.close(); 
			player(tempSong); 
			clip.setMicrosecondPosition(tempFrame); 
			this.play(); 
		}catch(Exception e){
			System.out.println(e);
		}
	}

	/*
	 *stops a clip and sets the frame to 0 
	 */
	public void stopSong(){
		try {
			clip.stop();
			clip.close();
			this.tempFrame = 0;
		}catch(Exception e){
			System.out.println(e);
		}
	}
	/**
	 * retruns the current frame
	 * @return tempFrame
	 */
	public long getFrame(){
		return tempFrame;
	}

	public void nextSong(){

	}

}
