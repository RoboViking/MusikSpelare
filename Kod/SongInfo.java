/**
 * this class gets the song info
 * the information extracted is Name, Band, File path, Length
 * 
 * 
 * @author oskar
 *
 */
public class SongInfo {
	
	private String name;
	private String bandName;
	private Path path;
	private double length;
	
	public SongInfo(File file){
		this.name = 
		this.bandName =
		this.path = file.getPath();
		this.length = songLength(file);
	}
	
	/**
	 * returns the length of the song 
	 */
	private double songLength(File file) {
		AudioInputStream inAudioStream = AudioSystem.getAudioInputStream(file); // gets an input stream of the file read
		AudioFormat format = inAudioStream.getFormat(); // gets th files format 
		long frames = inAudioStream.getFrameLength();	// gets the length of the file in frames rather than bytes
		double time = (frames+0.0) / format.getFrameRate(); // gets the formats framerate (the number of frames played per second)
															// and calculates the time of the song frames / framerate
		return time;
	}
	
	

}
