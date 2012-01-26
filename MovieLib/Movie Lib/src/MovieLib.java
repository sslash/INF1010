
public class MovieLib {
	
	/* Array of the movies that exists in the library */
	private Movie [] myMovies;
	
	/* Size of movie library */
	private int libSize;
	
	/* Index of next free movie spot in the library */
	private int nextFreeIndex;
	
	

	public MovieLib() {}	
	
	/**
	 * Adds a movie to the library
	 * @param movie		movie to be added
	 * 
	 */
	public void addMovie(Movie movie) {
		myMovies[nextFreeIndex] = movie;
		
		nextFreeIndex ++;
		
		/* Double the size of the array if needed */
		if ( nextFreeIndex > libSize/2) {
			System.out.println("Had to extend the array!");
			Movie [] newArray = new Movie [libSize*2];
			int i = 0;
			for (Movie m : myMovies) {
				newArray[i] = m;
				i++;
			}
			
			/* Copy the new array over */
			myMovies = newArray;		
			libSize = libSize *2;
		}
	}

	
	public MovieLib(int libSize) {
		
		this.libSize = libSize;
		myMovies = new Movie[libSize];
		nextFreeIndex = 0;
	}
	
	
	/**
	 * Prints all the movies in the library
	 */
	public void printAllMovies() {
		
		for (Movie m : myMovies ) {
			if ( m != null ) 
				m.print();
		}		
	}
	

	/**
	 * Searches through the library for the given movie
	 * 
	 * @param name		Name of the movie to get
	 * @return			The Movie object, if found
	 */
	public Movie getMovie(String name) {
		for ( Movie movie : myMovies ) {
			if ( movie.getName().equals(name))
				return movie;
		}
		
		/* Didn't find what we were looking for =( */
		return null;		
	}
	
}


