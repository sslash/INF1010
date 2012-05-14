import java.io.*;
import java.net.*;


/**
 * Wraps a ServerSocket that listens for http requests.
 * When a request comes in it picks a thread from the 
 * pool which will process the request and return
 * a http respons back to the client. 
 */
public class WebServer {

	private ThreadPool pool;

	public WebServer(ThreadPool pool) {
		this.pool = pool;
		listenOnHttpRequests();
	}

	// Server that listens for http requsts
	private void listenOnHttpRequests() {
		System.out.println("Server started!\n\n");

		ServerSocket serverSocket = null;

		try {
			serverSocket = new ServerSocket(8080);

		} catch (Exception e ){
			System.err.println("Error creating socket for port 8080");
		}

		// Listen forever
		while ( true ) {

			try {

				// Wait until a request comes in
				Socket requestSocket = serverSocket.accept();

			
				// Reader to read the request
				BufferedReader input = 
					new BufferedReader( new InputStreamReader(requestSocket.
						getInputStream()));

				// Writer to write back
				DataOutputStream output = 
					new DataOutputStream(requestSocket.getOutputStream());


				// Process the request!
				processInput(input, output);

			} catch (Exception e ) {
				System.err.println(e.getMessage());
			}
		}
	}


	// Expects a http get request. Triggers a thread
	// to process it
	private void processInput( BufferedReader input,DataOutputStream output){

		String s = "";

		System.out.println("Got a new request!");

		try {
			// Read lines one by one
			while( ( s = input.readLine() ) != null ) {

				// We are interested only in the GET message
				if ( s.startsWith("GET")) {

					// Pick a thread and process the request
					processGetMessage(s, output);
				}
		
			}
		} catch( IOException e ) {
			System.err.println( e.getMessage() ); 
		
		// Always close io streams
		}finally {
		
			// Need to catch these potential errors as well 
			try {
				input.close();
			}catch(IOException ex) {
				System.err.println(ex.getMessage());
			}
		}

		System.out.println("done");
	}


	// Expect a GET message. Pick a thread to send a response back on output
	private void processGetMessage(String getLine, DataOutputStream output ) {

		// Super unsecure! But works for this educational purpose..
		String page = getLine.split("\\s+")[1];

		// Get a thread from the pool and process the requst
		pool.processRequest(page, output);
	}
}