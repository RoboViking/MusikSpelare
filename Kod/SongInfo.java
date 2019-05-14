/**
 * this class gets the song info
 * the information extracted is Name, Band, File path, Length
 * 
 * 
 * @author oskar
 *
 */
import java.io.*;
import java.sound.sampeled.*;
import java.nio.*;



public class SongInfo {
	
	private String name;
	private String bandName;
	private Path path;
	private double length;
	
	public SongInfo(File file){
		this.name = getName(file);
		this.bandName = getBandName(file);
		this.path = file.getPath();
		this.length = songLength(file);
	}
	
	/**
	 * returns the length of the song to the struct
	 */
	private double songLength(File file) {
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
			return String[0];
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
			return String[1];
		}
		else {
			return "Unknown";
		}
	}
	
	private String returnName() {
		return name;
	}
	
	private String returnBandName() {
		return bandName;
	}
	
	private Path returnPath() {
		return path;
	}
	
	private double returnLength() {
		return length;
	}
}
