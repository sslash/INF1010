import java.util.Scanner;


public class KeyboardReader extends MyReader {

	public KeyboardReader(MovieLibrary movieLib) {
		
		// Call the super class«constructor with the library pointer
		super(movieLib);
		
		// initialize reader to ream from the keyboard when used
		scan = new Scanner(System.in);
	}
}
