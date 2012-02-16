
public class DVDMovie extends Video{

	public DVDMovie(String moviename, int year) {
		super (moviename, year);
	}
	
	public String toString() {
		return new String(super.name + "[DVD]" + "(" + year + ")");
	}

}
