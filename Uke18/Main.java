public class Main {
	
	public static void main(String [] args ) {
		new WebServer(new ThreadPool(5));
	}
}