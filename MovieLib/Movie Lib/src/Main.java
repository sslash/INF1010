public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		new Main().run();

	}

	private void run() {
		MovieLib michaelsMovieLib = new MovieLib(4, "Michael");

		Movie movie1 = new Movie("Superbabies: Baby Geniuses 2");
		Movie movie2 = new Movie("Daniel the Wizard");
		Movie movie3 = new Movie("Manos: The Hands of Fate");
		Movie movie4 = new Movie("Monster a-Go Go");

		michaelsMovieLib.addMovie(movie1);
		michaelsMovieLib.addMovie(movie2);
		michaelsMovieLib.addMovie(movie3);
		michaelsMovieLib.addMovie(movie4);

	}

}
