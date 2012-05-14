import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class FileIO {
	
	// A simple data cache for storing files
	private Map <String, String> fileCache;

	// Make sure there is only one instance of the FileIO class
	private static FileIO instance = null;

	// Killer hack: Private constructor makes sure no one can say new FileIO()
	private FileIO () {
		fileCache = new HashMap<String,String>();
	}

	// Must be thread safe
	public synchronized static FileIO getInstance() {
		if ( instance == null )
			instance = new FileIO();
		 
		return instance; 
	}


	/**
	 * returns the file with name filename as a string
	 */
	public synchronized String getFileContentAsString(String filename) {
		if ( fileCache.containsKey(filename) ) 
			return fileCache.get(filename);
		else 
			return readFile(filename);
	}


	private String readFile(String filename) {

		try {
			Scanner scan = new Scanner(new File(filename));

			// String builder is way more efficient for this
			// sort of stuff then String is..
			StringBuilder s = new StringBuilder();

			while ( scan.hasNextLine()) {
				s.append(scan.nextLine());
			}

			addStringToCache( filename, s.toString() );
			return s.toString();


		} catch(FileNotFoundException e ) {
			System.err.println("Could not find file with name : " + filename);
			return null;
		}
	}

	private void addStringToCache (String filename, String fileContent ) {
		fileCache.put(filename, fileContent);
	}

}