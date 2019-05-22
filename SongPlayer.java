
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
/**
*
*
* @author Oskar de la Vaux, Fabian Henrysson, Willian Wahlberg
*
*/
public class SongPlayer {
	private static Clip clip;
	private static AudioInputStream stream;
	public static long tempFrame;
	private static File name;
	private static String tempSong;
	/**
	 * takes in the path to a .wav file or path to the file and plays it as a clip
	 * 
	 * @param song
	 */
	
	
	public static void player(String song) {
		try {
			tempSong = song;
			name = new File(song);
			stream = AudioSystem.getAudioInputStream(name);
			clip = AudioSystem.getClip();
			clip.open(stream);

			clip.addLineListener(e -> {
				if (e.getType() == LineEvent.Type.STOP) {
					if(Backend.currentlyPlaying)
						Backend.playNext();
				}
			});

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * starts the clip
	 */
	public static void play() {
		try {
			clip.start();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * pauses song
	 */
	public static void pauseSong() {
		try {
			tempFrame = clip.getMicrosecondPosition();
			clip.stop();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/*
	 * resumes a paused song
	 */
	public static void resumeSong() {
		try {
			player(tempSong);
			clip.setMicrosecondPosition(tempFrame);
			play();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/*
	 * stops a clip and sets the frame to 0
	 */
	public static void stopSong() {
		try {
			clip.stop();
			clip.close();
			tempFrame = 0;
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * retruns the current frame
	 * 
	 * @return tempFrame
	 */
	public long getFrame() {
		return tempFrame;
	}

	public void nextSong() {

	}

}
