
public class HashTable {

	SongInfo[] hashtable;
	int size;
	
	public HashTable() {
		hashtable = new SongInfo[30000];
		size=0;
	}
	
	private int getKey(String s) {
		int key=0;
		for(int i=0;i<s.length();i++) {
			key+=(int)s.charAt(i)*i;
		}
		
		return key;
	}
	
	public int size() {
		return size;
	}
	
	public void put(String name,SongInfo song) {
		int key = getKey(name);
		if(hashtable[key]==null) {
		hashtable[key]=song;
		size++;
		}else {
			System.out.println("Duplicate Song");
		}
	}
	
	public boolean containsKey(String name) {
		int key = getKey(name);
		return hashtable[key] !=null;
	}
	
	public SongInfo get(String name) {
		int key = getKey(name);
		return hashtable[key];
	}
	
	
	public static void main(String[] args) {
		HashTable h = new HashTable();
		System.out.println(h.getKey("AnotherOneBitesTheDust"));
	}
}
