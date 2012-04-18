import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Model {

	public String getFileContent(String filename) {
		File f = new File(filename);
		String fileContent = "";
		try {
			Scanner s = new Scanner(f);
			
			while(s.hasNext()) {
				fileContent += s.next();
			}
			
		} catch (FileNotFoundException e) {
			return null;
		}
		
		return fileContent;		
	}
}
