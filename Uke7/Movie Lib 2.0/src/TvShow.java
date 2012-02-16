import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class TvShow extends Video {
	
	/* A Map consisting of season numbers, and an arraylist of episode names */
	private Map <String, ArrayList<String>> episodes;

	public TvShow(String name, int year) {
		super(name, year);
		
		episodes = new HashMap<String, ArrayList<String>>();	
		
	}

	
	public void addEpisodesToShow(String seasonNumber, String episodestring[]) {
		ArrayList <String> episodeArr = new ArrayList<String>();
		
		for ( String s : episodestring)
			episodeArr.add(s);
		
		
		
		episodes.put("Season " + seasonNumber, episodeArr);
	}
	
	public String toString() {
		return new String(super.name + "[TV-SHOW]" + "(" + year + ") " + episodes.toString() );
	}

}
