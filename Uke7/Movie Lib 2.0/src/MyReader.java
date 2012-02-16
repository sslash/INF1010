import java.util.Scanner;


public class MyReader {
	
	/* Protected, so that the subclasses only has access */
	protected Scanner scan;
	
	/* Library to store our movies */
	private MovieLibrary movieLib;
	
	
	public MyReader(MovieLibrary movieLib) {
		this.movieLib = movieLib;
	}

	public void read() {		
		while ( scan.hasNextLine() ){
			String input = scan.nextLine();
			parseInput(input);
		}
	
	}

	
	/**
	 * parses a line from the input source
	 * 
	 * Expected format:	
	 * "dvd#<Movie name>#<year>#"
	 * "blueray#<resolution>#<Movie name>#<year>"
	 * "tvshow#<Tv-show name>#<year>"
	 * "tv-episodes##<Tv-show name>##<season-number>##<episode 1>#<episode 2>..<episode n>]" 
	 * 
	 * 
	 * @param input line from file or keyboard
	 */
	private void parseInput(String input) {
		String args[] = input.split("#");
		
		Video video = null;
		
		// Moviename year
		if ( input.startsWith("dvd") ) {
			
			video = new DVDMovie(args[1], Integer.parseInt(args[2]));
			
			
		// Moviename year resolution
		} else if (input.startsWith("blueray") ) {
			video = new BluerayMovie(args[2], Integer.parseInt(args[3]), args[1]);
			
		// Tvshow-name year 
		} else if (input.startsWith("tv-show") ) {
			video = new TvShow(args[1], Integer.parseInt(args[2]));
		
		// tv-episodes tvshow-name season-number episode1#episode2#episode3..episodeN
		} else if (input.startsWith("tv-episodes") ){
			addEpisodesToVideo(input.split("##"));
			return;
		}
		
		movieLib.addMovie(video);		
	}

	private void addEpisodesToVideo(String args[]) {
		TvShow tvshow = (TvShow) movieLib.get(args[1]);		
		tvshow.addEpisodesToShow(args[2], args[3].split("#"));		
	}
}
