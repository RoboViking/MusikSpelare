import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.UnsupportedAudioFileException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SongInfoTest {

	@Test
	void test() {
		try {
			File file = new File("Sandstorm Darude.Wav");
			SongInfo si1 = new SongInfo(file);
			
			assertEquals("Sandstorm",si1.returnName());
			assertEquals("Darude.Wav",si1.returnBandName());
			assertEquals("Sandstorm Darude.Wav",si1.returnPath());
			assertEquals(232.3994557823129,si1.returnLength(),"wrong length");
			

		} catch (UnsupportedAudioFileException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
