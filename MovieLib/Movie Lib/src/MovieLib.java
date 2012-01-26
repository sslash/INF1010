
public class MovieLib {
	
	
	/* Our collection of movies */
	private MovieList listOfMovies;
	
	
	/* Master owner of the library */
	private String owner;
	
	
	

	/** Simple empty constructor, in case we need it */
	public MovieLib() {}	
	
	
	/**
	 * Creates a library with a spesified size
	 *
	 * @param libSize
	 * @param owner
	 */
	public MovieLib(int libSize, String owner) {
		init(libSize, owner);		
	}


	/**
	 * Initializes the object
	 * 
	 * @param libSize	size of the library
	 * @param owner		owner of the library
	 */
	private void init(int libSize, String owner) {
		listOfMovies = new MovieList(libSize);
		this.owner = owner;
	}
	
	
	/**
	 * Adds a new movie to the library's collection
	 *  
	 * @param movie		to be added
	 * @return true if the movie was added, false otherwise
	 */
	public boolean addMovie( Movie movie ) {
		return listOfMovies.addMovie(movie);
	}
	
	
	/**
	 * Prints all the movies in the library
	 */
	public void printAllMovies() {
		listOfMovies.printAllMovies();		
	}
	

	/**
	 * Searches through the library for the given movie
	 * 
	 * @param name		Name of the movie to get
	 * @return			The Movie object, if found
	 */
	public Movie getMovie(String movieName) {
		return listOfMovies.getMovie(movieName);	
	}
	
}


