
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
	
	
	public void print() {
		System.out.println("My name is " + name);		
	}	
}
