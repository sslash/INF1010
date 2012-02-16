
public class Main {
	
	private MyReader		myreader;
	private MovieLibrary	movieLib;
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Main main = new Main(args);		
	}
	

	public Main(String[] args) {
		
		// Init the movie library, so that the reader can use it
		movieLib = new MovieLibrary();	

		// This is what the program should do
		readMovies(args);
		printMovies();
	}

	private void printMovies() {
		// Debug this!
		Video movieArr[] = movieLib.getAllMovies();
		
		System.out.println("Video library:\n" );
		for( Video movieTmp : movieArr ){
			System.out.println(movieTmp.toString());
		}
		
	}

	private void readMovies(String[] args) {
		
		// Read from file 
		if ( args.length > 0 ) {
			myreader = new FileReader(movieLib, args[0]);
			
		// or read from keyboard
		} else {
			myreader = new KeyboardReader(movieLib);
		}
		
		// start reading from input source
		myreader.read();
	}

}
