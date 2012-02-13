
public class Main {
	
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

		readMovies(args);
		printMovies();
	}

	private void printMovies() {
		// TODO: Print all the movies
		
	}

	private void readMovies(String[] args) {
		
		// Read from file 
		if ( args.length > 0 ) {
			// TODO: create file reader
			
		// or read from keyboard
		} else {
			// TODO: Create keyboard reader
		}
		
		// start reading from input source
		// TODO: Call the read function in MyReader.java
	}

}
