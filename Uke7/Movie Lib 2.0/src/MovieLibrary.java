import java.util.HashMap;
import java.util.Map;


public class MovieLibrary {
	
	private Map <String, Video> movieCollection;
	
	
	public MovieLibrary() {
		movieCollection = new HashMap<String, Video>();
	}

	public boolean addMovie(Video movie) {
		movieCollection.put(movie.getName(), movie);
		
		return true;		
	}
	
	
	public int getSize() {
		return movieCollection.size();
	}
	
	
	public Video [] getAllMovies() {
		
		Video movieArray[] = new Video[getSize()];
		int i = 0;
		
		for ( Video movie : movieCollection.values()) {
			movieArray[i++] = movie;
		}
		
		return movieArray;
	}

	
	public Video get(String showname) {
		return movieCollection.get(showname);
	}

}
