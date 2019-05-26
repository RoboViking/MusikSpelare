import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.UnsupportedAudioFileException;

import org.junit.jupiter.api.Test;

class HashTableTest {


	@Test
	void test() throws UnsupportedAudioFileException, IOException {
		HashTable tabletest =new HashTable();
		
		assertEquals(tabletest.size(),0);
		
		SongInfo song1 = new SongInfo(new File("Musik\\Africa Toto.Wav"));
		SongInfo song2 = new SongInfo(new File("Musik\\Jump VanHalen.Wav"));
		SongInfo song3 = new SongInfo(new File("Musik\\Sandstorm Darude.Wav"));
		SongInfo song4 = new SongInfo(new File("Musik\\AllStar SmashMouth.Wav"));
		SongInfo song5 = new SongInfo(new File("Musik\\AnotherOneBitesTheDust Queen.Wav"));
		SongInfo song6 = new SongInfo(new File("Musik\\ChumDrumBedrum WierdRussianSinger.Wav"));
		SongInfo song7 = new SongInfo(new File("Musik\\DownUnder MenAtWork.Wav"));
		SongInfo song8 = new SongInfo(new File("Musik\\Monody TheFatRat.Wav"));
		SongInfo song9 = new SongInfo(new File("Musik\\NeverGonnaGiveYouUp RickAstley.Wav"));
		SongInfo song10 = new SongInfo(new File("Musik\\ParadiseCity GunsN'Roses.Wav"));
		SongInfo song11 = new SongInfo(new File("Musik\\ShootingStars Raiders.Wav"));
		SongInfo song12 = new SongInfo(new File("Musik\\WatchMe Silento.Wav"));
		SongInfo song13 = new SongInfo(new File("Musik\\XPShutdown Microsoft.Wav"));
		SongInfo song14 = new SongInfo(new File("Musik\\XpStartup Microsoft.Wav"));
		
		tabletest.put(song1.returnName(), song1);
		tabletest.put(song2.returnName(), song2);
		tabletest.put(song3.returnName(), song3);
		tabletest.put(song4.returnName(), song4);
		tabletest.put(song5.returnName(), song5);
		tabletest.put(song6.returnName(), song6);
		tabletest.put(song7.returnName(), song7);
		tabletest.put(song8.returnName(), song8);
		tabletest.put(song9.returnName(), song9);
		tabletest.put(song10.returnName(), song10);
		tabletest.put(song11.returnName(), song11);
		tabletest.put(song12.returnName(), song12);
		tabletest.put(song13.returnName(), song13);
		tabletest.put(song14.returnName(), song14);

		assertEquals(tabletest.size(),14);
		
		assertTrue(tabletest.containsKey("Africa"));
		assertTrue(tabletest.containsKey("Jump"));
		assertTrue(tabletest.containsKey("Sandstorm"));
		assertTrue(tabletest.containsKey("AllStar"));
		assertTrue(tabletest.containsKey("AnotherOneBitesTheDust"));
		assertTrue(tabletest.containsKey("ChumDrumBedrum"));
		assertTrue(tabletest.containsKey("DownUnder"));
		assertTrue(tabletest.containsKey("Monody"));
		assertTrue(tabletest.containsKey("NeverGonnaGiveYouUp"));
		assertTrue(tabletest.containsKey("ParadiseCity"));
		assertTrue(tabletest.containsKey("ShootingStars"));
		assertTrue(tabletest.containsKey("WatchMe"));
		assertTrue(tabletest.containsKey("XPShutdown"));
		assertTrue(tabletest.containsKey("XpStartup"));

		
	}

}
