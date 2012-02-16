import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class FileReader extends MyReader {

	public FileReader(MovieLibrary movieLib, String filename) {
		
		// Call the super class«constructor with the library pointer
		super(movieLib);
		
		try {
			scan = new Scanner(new File(filename ));
			
		} catch (FileNotFoundException e) {
			System.err.println("Couldn't open file: " + filename);
			System.exit(1);
		}
	}

}
