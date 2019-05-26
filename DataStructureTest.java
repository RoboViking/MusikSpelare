import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataStructureTest {

	@BeforeEach
	void setUp() throws Exception {
		Backend.addMusicToHash();
	}

	@Test
	void LibraryTest() {
		assertTrue(Backend.library.containsKey("AnotherOneBitesTheDust"));
		assertTrue(Backend.library.containsKey("NeverGonnaGiveYouUp"));		
		assertTrue(Backend.library.containsKey("Sandstorm"));
		assertTrue(Backend.library.containsKey("Jump"));
		assertTrue(Backend.library.containsKey("DownUnder"));
		assertTrue(Backend.library.containsKey("Africa"));
		assertTrue(Backend.library.containsKey("ParadiseCity"));
		assertTrue(Backend.library.containsKey("Monody"));
		assertTrue(Backend.library.containsKey("ChumDrumBedrum"));
		assertTrue(Backend.library.containsKey("WatchMe"));
		assertTrue(Backend.library.containsKey("AllStar"));
		assertTrue(Backend.library.containsKey("XPShutdown"));
		assertTrue(Backend.library.containsKey("ShootingStars"));
		assertTrue(Backend.library.containsKey("XpStartup"));
		
		assertEquals(Backend.library.size(),14);
	}
	
	@Test
	void PlaylistTest() {
		Backend.addMusicToPlaylist("song1");
		Backend.addMusicToPlaylist("song2");
		Backend.addMusicToPlaylist("song3");
		Backend.addMusicToPlaylist("song4");
		Backend.addMusicToPlaylist("song5");
		Backend.addMusicToPlaylist("song6");
		Backend.addMusicToPlaylist("song7");
		Backend.addMusicToPlaylist("song8");
		Backend.addMusicToPlaylist("song9");
		Backend.addMusicToPlaylist("song10");
		
		assertEquals(Backend.playlist.size(),10);
		
		int[] nr = {1,2,3,4,5,6,7,8,9,10};
		for(int i=0;i<50;i++) {
			int place1 = (int) (Math.random()*10);
			int place2 = (int) (Math.random()*10);
			int temp = nr[place1];
			nr[place1]=nr[place2];
			nr[place2]=temp;
		}
		
		for(int i=0;i<10;i++)
			Backend.removeMusicFromPlaylist("song"+nr[i]);
		
		assertEquals(Backend.playlist.size(),0);




	}
}
