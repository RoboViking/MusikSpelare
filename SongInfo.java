/**
 * this class gets the song info
 * the information extracted is Name, Band, File path, Length
 * 
 * 
 * @author Oskar de la Vaux, Fabian Henrysson, Willian Wahlberg
 *
 */
import java.io.*;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import java.nio.file.Path;



public class SongInfo {
	
	private String name;
	private String bandName;
	private String path;
	private double length;
	
	public SongInfo(File file) throws UnsupportedAudioFileException, IOException{
		this.name = getName(file);
		this.bandName = getBandName(file);
		this.path = file.getPath();
		this.length = songLength(file);
	}
	
	/**
	 * returns the length of the song to the struct
	 * @throws IOException 
	 * @throws UnsupportedAudioFileException 
	 */
	private double songLength(File file) throws UnsupportedAudioFileException, IOException {
		AudioInputStream inAudioStream = AudioSystem.getAudioInputStream(file); // gets an input stream of the file read
		AudioFormat format = inAudioStream.getFormat(); // gets th files format 
		long frames = inAudioStream.getFrameLength();	// gets the length of the file in frames rather than bytes
		double time = (frames+0.0) / format.getFrameRate(); // gets the formats framerate (the number of frames played per second)
															// and calculates the time of the song frames / framerate
		return time;
	}
	
	/**
	 * returns the name of the song to the struct
	 */
	private String getName(File file) {
		String temp = file.getName();
		String[] temparr = temp.split(" ");
		if(temparr.length > 0) {
			return temparr[0];
		}
		else {
			return "UnknownSong";
		}
	}
	
	/**
	 * returns the bandname to the struct
	 */
	private String getBandName(File file) {
		String temp = file.getName();
		String[] temparr = temp.split(" ");
		if(temparr.length > 1) {
			return temparr[1];
		}
		else {
			return "Unknown";
		}
	}
	/**
	 * returns the name to the method clling
	 */
	public String returnName() {
		return name;
	}
	/**
	 * returns the band name to the method clling
	 */
	public String returnBandName() {
		return bandName;
	}
	/**
	 * returns the path to the method clling
	 */
	public String returnPath() {
		return path;
	}
	/**
	 * returns the song length to the method clling
	 */
	public double returnLength() {
		return length;
	}
}
