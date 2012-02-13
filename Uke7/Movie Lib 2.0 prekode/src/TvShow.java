import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class TvShow extends Video {
	
	/* A Map consisting of season numbers, and an arraylist of episode names */
	private Map <String, ArrayList<String>> episodes;

	public TvShow(String name, int year) {
		super(name, year);
		// TODO: Init episodes
		
	}

	
	public void addEpisodesToShow(String seasonNumber, String episodestring[]) {

		// TODO: Add these episodes to the map of tv shows
		
	}
	
	public String toString() {

		// TODO: create a nice to string method
		return null;
	}

}
