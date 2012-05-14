import java.util.concurrent.CountDownLatch;
import java.io.DataOutputStream;

public class WorkerThread extends Thread {

	// The latch that this thread will wait on
	private CountDownLatch latch;
	private String requestMsg; 
	private DataOutputStream output;
	private ThreadPool threadPool;


	public WorkerThread (CountDownLatch latch, ThreadPool threadPool) {
		this.latch = latch;
		this.threadPool = threadPool;
	} 


	// Set the data that will be used when processing request
	public void setRequestData(String getRequest, DataOutputStream output) {
		requestMsg = getRequest;
		this.output = output;
	}


	private void setToSleepAgain() {

		// Reset the latch
		latch = new CountDownLatch(1);

		// Put myself back in the threadpool
		threadPool.pushThread(this);

		// .. and go back to wait
	}


	private void waitForWork() {

		// Wait until someone wants our service
		// while(true) should not be used. Implement a way
		// to kill all the threads in the pool when the application
		// is about to end ;)
		while(true) {
			try {
				latch.await();
			} catch(InterruptedException e ) {
				System.err.println("I was interrupted :(");
			}

			doWork();
		}
	}

	// Issue the request itself
	private void doWork() {

		System.out.println("Got a request for file: " + requestMsg);
		FileIO fileGetter = FileIO.getInstance();
		String fileContent = fileGetter.getFileContentAsString(chopString(requestMsg));


		try {
			// Send response back to user
			if ( fileContent == null ) {
				output.writeBytes("HTTP/1.0 500 Internal Server Error\n");
			
			} else {
				output.writeBytes("HTTP/1.0 200 OK\nContent-Type: text/html\n\n");	
				output.writeBytes(fileContent);
			}
				
			output.close();

		}catch(Exception e ){
			System.err.println("Error closing stream: " + e.getMessage());

		} finally {

			setToSleepAgain();
		}
	}


	/**
	 * removes stuff like "/" from the filename
	 */
	private String chopString(String filename) {
		if ( filename.startsWith("/") ) {
			return filename.substring(1);
		
		} else {
			return filename;
		}


	}
	public void run() {
		waitForWork();		
	}

	public CountDownLatch getLatch() {
		return latch;
	}

}