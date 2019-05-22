import java.util.Comparator;
/**
 * 
 * @author Oskar de la Vaux, Fabian Henrysson, Willian Wahlberg
 *
 */
public class ComparatorName implements Comparator<SongInfo>{
	/**
	 * compares the name of the songs
	 */
	public int compare(SongInfo arg0, SongInfo arg1) {
		String name1 = arg0.returnName();
		String name2 = arg1.returnName();
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
