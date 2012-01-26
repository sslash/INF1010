
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MovieLib michaelsMovieLib = new MovieLib(4);
		
		Movie movie1 = new Movie("Superbabies: Baby Geniuses 2");
		Movie movie2 = new Movie("Daniel the Wizard");
		Movie movie3 = new Movie("Manos: The Hands of Fate");
		Movie movie4 = new Movie("Monster a-Go Go");		
		
		michaelsMovieLib.addMovie(movie1);
		michaelsMovieLib.addMovie(movie2);
		michaelsMovieLib.addMovie(movie3);
		michaelsMovieLib.addMovie(movie4);
		
		
		michaelsMovieLib.printAllMovies();
		
		boolean result = testChangeName( michaelsMovieLib, "Daniel the Wizard", "Terminator 2");
		
		System.out.println("Result of the name swap was: " + result);
	}
	
	
	
	public static boolean testChangeName(MovieLib mLib, String movieName, String newName ){
		Movie movie = mLib.getMovie(movieName);
		
		movie.setName(newName);		
		if(movie.getName().equals(newName))
			return true;
		else
			return false;
		
	}
}
