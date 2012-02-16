
public class BluerayMovie extends Video {
	
	/* Resolution of the movie */
	private String resolution;

	public BluerayMovie(String moviename, int year, String resolution ) {
		super(moviename, year);
		
		this.resolution = resolution;		
	}

	
	public String toString() {
		return new String(super.name + "[BLUERAY]" + "(" + year + ") " + resolution );
	}

}
