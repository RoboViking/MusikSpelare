package musikSpelare;

public class song{
	
	public String bandName; 
	public String songName;
	
	public song(String track, String artist){
		songName=track;
		bandName=artist;
	}
	
	public String getSong(){
		return songName;
	}
	
	public String getBand(){
		return songName;
	}
	
	public String toString(){
		String result = getSong() + " by " + getBand();
		return result;
	}
}
