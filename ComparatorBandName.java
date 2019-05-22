import java.util.Comparator;
/**
 * 
 * @author Oskar de la Vaux, Fabian Henrysson, Willian Wahlberg
 *
 */
public class ComparatorBandName implements Comparator<SongInfo>{
	/**
	 * compares the band name of the song
	 */
	public int compare(SongInfo arg0, SongInfo arg1) {
		String name1 = arg0.returnBandName();
		String name2 = arg1.returnBandName();
		if(name1.compareTo(name2)<0) {
			return -1;
		}
		else if(name1.compareTo(name2)>0) {
			return 1;
		}
		else {
			return 0;	
		}
	}

}
