import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;

public class Backend {
	static msGUI frame;
	public static Hashtable<String, SongInfo> library;
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
					addMusicToHash();
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void addMusicToHash() {
		library = new Hashtable<String, SongInfo>();
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
		if (msGUI.SortBySong)
			Collections.sort(wavs, new ComparatorName());
		if (msGUI.SortByArtist)
			Collections.sort(wavs, new ComparatorBandName());
		frame.addSongList(wavs);
	}

	public static void addMusicToPlaylist(String song) {
		playlist.add(song);
	}

	public static void removeMusicFromPlaylist(String song) {
		for (int i = 0; i < playlist.size(); i++) {
			if (playlist.get(i).equals(song)) {
				playlist.remove(i);
			}
		}
	}

	public static void playNext() {
		currentSong++;
		if (currentSong == playlist.size())
			currentSong = 0;
		SongPlayer.player(Backend.playlist.get(currentSong));
		SongPlayer.play();
	}
}
