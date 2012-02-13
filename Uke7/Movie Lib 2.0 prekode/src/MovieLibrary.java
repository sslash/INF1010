import java.util.HashMap;
import java.util.Map;


public class MovieLibrary {
	
	private Map <String, Video> movieCollection;
	
	
	public MovieLibrary() {
		movieCollection = new HashMap<String, Video>();
	}

	public boolean addMovie(Video movie) {

		// TODO: put the given movie in the hash map
		
		return false;		
	}
	
	
	public int getSize() {

		// TODO: return size of library
		return 0;
	}
	
	
	public Video [] getAllMovies() {
		// TODO: get all the movies
		return null;
	}

	
	public Video get(String showname) {

		// TODO: get the movie with the given name
		return null;
	}

}
