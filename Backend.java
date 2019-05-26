import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;

public class Backend {


	static msGUI frame;
	public static HashTable library;
	public static ArrayList<String> playlist;
	public static int currentSong;
	public static boolean currentlyPlaying;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new msGUI();
					frame.setVisible(true);

					playlist = new ArrayList<String>();
					currentSong = 0;
					msGUI.songButtons = new JButton[0];
					msGUI.songEvents = new MouseAdapter[0];
					ArrayList<SongInfo> list = addMusicToHash();
					addButtons(list);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
/**
 * Filles up library with songs from musik folder
 * @return Arraylist filled with songInfo object
 */
	public static ArrayList<SongInfo> addMusicToHash() {
		library = new HashTable();
		playlist = new ArrayList<String>();
		File folder = new File("Musik");
		File[] listOfFiles = folder.listFiles();
		ArrayList<SongInfo> wavs = new ArrayList<SongInfo>();
		for (File file : listOfFiles) {
			if (file.isFile()) {
				try {
					SongInfo song = new SongInfo(file);
					wavs.add(song);
					library.put(song.returnName(), song);
				} catch (UnsupportedAudioFileException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return wavs;
	}
/**
 * Sorts buttons and calls addSongList
 * @param Arraylist<SongInfo>
 */
	public static void addButtons(ArrayList<SongInfo> wavs) {
		if (msGUI.SortBySong)
			Collections.sort(wavs, new ComparatorName());
		if (msGUI.SortByArtist)
			Collections.sort(wavs, new ComparatorBandName());
		frame.addSongList(wavs);
	}
/**
 * adds path to a wav file as string in to playlist
 * @param path to wav file as string
 */
	public static void addMusicToPlaylist(String song) {
		playlist.add(song);
	}
/**
 * removes string from playlist
 * @param string to be removed
 */
	public static void removeMusicFromPlaylist(String song) {
		for (int i = 0; i < playlist.size(); i++) {
			if (playlist.get(i).equals(song)) {
				playlist.remove(i);
			}
		}
	}
/**
 * plays next song in playlist
 */
	public static void playNext() {
		currentSong++;
		if (currentSong == playlist.size())
			currentSong = 0;
		SongPlayer.player(Backend.playlist.get(currentSong));
		SongPlayer.play();
	}
}
