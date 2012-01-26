
public class Movie {

	private String name;

	
	public Movie(String name) {
		this.name = name;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		return "Movie [name=" + name + "]";
	}


	public void print() {
		System.out.println( toString() );		
	}	
}
