public class MovieList {

	/* Array of the movies that exists in the library */
	private Movie[] myMovies;

	/* Size of movie library */
	private int libSize;

	/* Index of next free movie spot in the library */
	private int nextFreeIndex;

	
	
	public MovieList(int libSize) {
		this.libSize = libSize;
		myMovies = new Movie[libSize];
		nextFreeIndex = 0;
	}
	

	/**
	 * Prints all the movies in the library
	 */
	public void printAllMovies() {

		for (Movie m : myMovies) {
				m.print();
		}
	}

	/**
	 * Adds a movie to the library
	 * 
	 * @param movie
	 *            movie to be added
	 * 
	 */
	public boolean addMovie(Movie movie) {

		if (nextFreeIndex >= libSize)
			return false;

		else {
			myMovies[nextFreeIndex++] = movie;
			return true;
		}
	}
	

	/**
	 * Searches through the library for the given movie
	 * 
	 * @param name
	 *            Name of the movie to get
	 * @return The Movie object, if found
	 */
	public Movie getMovie(String name) {
		for (Movie movie : myMovies) {
			if (movie.getName().equals(name))
				return movie;
		}

		/* Didn't find what we were looking for =( */
		return null;
	}

}
