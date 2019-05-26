import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.UIDefaults;
import javax.swing.UIManager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JProgressBar;

public class msGUI extends JFrame {

	private JPanel contentPane;
	private JTextField searchField;
	JPanel panel;
	public boolean currentlyPlayingPlaylist;

	public static boolean SortByArtist;
	public static boolean SortBySong;

	/**
	 * Create the Jframe with buttons to controll the music player
	 */
	public msGUI() {
		setTitle("Meme Player");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 690);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		contentPane.setBackground(Color.DARK_GRAY);
		
/////////////////////////// Start ///////////////		
		JButton btnStart = new JButton("Start");
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!Backend.currentlyPlaying) {
					if (!currentlyPlayingPlaylist) {
						currentlyPlayingPlaylist = true;
						Backend.currentlyPlaying = true;
						Backend.currentSong = 0;
						SongPlayer.player(Backend.playlist.get(0));
						SongPlayer.play();
					} else {
						Backend.currentlyPlaying = true;
						SongPlayer.resumeSong();
					}
				}
			}
		});
		GridBagConstraints gbc_btnStart = new GridBagConstraints();
		gbc_btnStart.insets = new Insets(0, 0, 5, 5);
		gbc_btnStart.gridx = 0;
		gbc_btnStart.gridy = 0;
		contentPane.add(btnStart, gbc_btnStart);

		/////////////////////////// Search ///////////////
		JButton btnSk = new JButton("S\u00F6k");
		btnSk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String userIn = searchField.getText();
				if (Backend.library.containsKey(userIn)) {
					SongInfo song = Backend.library.get(userIn);
					Backend.playlist.add(song.returnPath());
					System.out.println("Song is found");
					for (int i = 0; i < songButtons.length; i++) {

						if (buttonText[i].equals(song.returnName())) {
							buttonState[i] = true;
							songButtons[i].setBackground(Color.GRAY);
							songButtons[i].setOpaque(true);
							revalidate();
							repaint();
							break;
						}
					}
				} else {
					System.out.println("Song no found");
				}
			}
		});
		GridBagConstraints gbc_btnSk = new GridBagConstraints();
		gbc_btnSk.insets = new Insets(0, 0, 5, 5);
		gbc_btnSk.gridx = 4;
		gbc_btnSk.gridy = 0;
		contentPane.add(btnSk, gbc_btnSk);
		
		searchField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.EAST;
		gbc_textField.gridwidth = 3;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 5;
		gbc_textField.gridy = 0;
		contentPane.add(searchField, gbc_textField);
		searchField.setColumns(10);

		/////////////////////////// Stop ///////////////
		JButton btnStop = new JButton("Stop");
		btnStop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				currentlyPlayingPlaylist = false;
				Backend.currentlyPlaying = false;
				SongPlayer.stopSong();
			}
		});
		GridBagConstraints gbc_btnStop = new GridBagConstraints();
		gbc_btnStop.insets = new Insets(0, 0, 5, 5);
		gbc_btnStop.gridx = 2;
		gbc_btnStop.gridy = 0;
		contentPane.add(btnStop, gbc_btnStop);

		/////////////////////////// Pause ///////////////
		JButton btnPaus = new JButton("Paus");
		btnPaus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Backend.currentlyPlaying = false;
				SongPlayer.pauseSong();
			}
		});
		GridBagConstraints gbc_btnPaus = new GridBagConstraints();
		gbc_btnPaus.insets = new Insets(0, 0, 5, 5);
		gbc_btnPaus.gridx = 1;
		gbc_btnPaus.gridy = 0;
		contentPane.add(btnPaus, gbc_btnPaus);

		/////////////////////////// Next song ///////////////
		JButton btnNext = new JButton("Next Song");
		btnNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				SongPlayer.stopSong();
			}
		});
		GridBagConstraints gbc_btnNext = new GridBagConstraints();
		gbc_btnNext.insets = new Insets(0, 0, 5, 5);
		gbc_btnNext.gridx = 3;
		gbc_btnNext.gridy = 0;
		contentPane.add(btnNext, gbc_btnNext);

		/////////////////////////// sortera enligt artist ///////////////
		JButton btnArtist = new JButton("Artist");
		btnArtist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SortByArtist = true;
				SortBySong = false;

				ResetAndAddMusic();
			}
		});
		GridBagConstraints gbc_btnArtist = new GridBagConstraints();
		gbc_btnArtist.insets = new Insets(0, 0, 5, 5);
		gbc_btnArtist.gridx = 0;
		gbc_btnArtist.gridy = 1;
		contentPane.add(btnArtist, gbc_btnArtist);

		/////////////////////////// Sortera enligt song ///////////////
		JButton btnLt = new JButton("L\u00E5t");
		btnLt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SortByArtist = false;
				SortBySong = true;

				ResetAndAddMusic();
			}
		});
		GridBagConstraints gbc_btnLt = new GridBagConstraints();

		gbc_btnLt.insets = new Insets(0, 0, 5, 5);
		gbc_btnLt.gridx = 1;
		gbc_btnLt.gridy = 1;
		contentPane.add(btnLt, gbc_btnLt);
		
		
		
		// JPanel for music buttons
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBackground(Color.GRAY);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 8;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		contentPane.add(panel, gbc_panel);
	}
	
	public void ResetAndAddMusic() {
		Backend.playlist = new ArrayList<String>();
		Backend.currentSong = 0;
		songButtons = new JButton[0];
		songEvents = new MouseAdapter[0];
		revalidate();
		ArrayList<SongInfo> list = Backend.addMusicToHash();
		Backend.addButtons(list);

	}

	private int cs;
	public static JButton[] songButtons;
	public static MouseAdapter[] songEvents;
	public boolean[] buttonState;
	static String[] buttonText;
	
	/**
	 * Adds a list of buttons to panel
	 * @param ArrayList of songInfo
	 */
	public void addSongList(ArrayList<SongInfo> songs) {
		try {

			cs = 0;
			songButtons = new JButton[songs.size()];
			songEvents = new MouseAdapter[songs.size()];
			buttonState = new boolean[songs.size()];
			buttonText = new String[songs.size()];
			panel.removeAll();

			for (cs = 0; cs < songs.size(); cs++) {

				buttonText[cs] = songs.get(cs).returnName();
				songEvents[cs] = createMouseAdapter(songs.get(cs), cs);

				String name = songs.get(cs).returnName() + "  " + songs.get(cs).returnBandName();
				songButtons[cs] = new JButton(name.replace(".Wav", ""));
				songButtons[cs].setBounds(10, 11 + (30 * cs), 89, 23);

				songButtons[cs].addMouseListener(songEvents[cs]);
				panel.add(songButtons[cs]);
			}
			revalidate();
			repaint();
		} catch (Exception e) {
			System.out.print(e);
		}
	}

	public MouseAdapter createMouseAdapter(SongInfo s, int x) {
		return new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!buttonState[x]) {
					Backend.addMusicToPlaylist(s.returnPath());
					buttonState[x] = true;
					songButtons[x].setBackground(Color.GRAY);
					songButtons[x].setOpaque(true);
					revalidate();
					repaint();

				} else {
					buttonState[x] = false;
					Backend.removeMusicFromPlaylist("Musik\\" + s.returnName() + " " + s.returnBandName());
					songButtons[x].setBackground(new JButton().getBackground());
					songButtons[x].setOpaque(true);
					revalidate();
					repaint();
				}
				System.out.println(Backend.playlist);

			}

		};
	}
}