import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.UnsupportedAudioFileException;

import org.junit.jupiter.api.Test;

class SonginfoTest {

	@Test
	void test() {
		try {
			File file = new File("Musik\\Sandstorm Darude.Wav");
			SongInfo si1 = new SongInfo(file);
			
			assertEquals("Sandstorm",si1.returnName());
			assertEquals("Darude.Wav",si1.returnBandName());
			assertEquals("Musik\\Sandstorm Darude.Wav",si1.returnPath());
			assertEquals(232.3994557823129,si1.returnLength(),"wrong length");
			
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		}
	}
}