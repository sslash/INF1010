import java.io.DataOutputStream;
import java.util.Stack;
import java.util.concurrent.CountDownLatch;
import java.util.EmptyStackException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


// Class that holds a pool of threads
public class ThreadPool {
	private Stack <WorkerThread> threadPool;

	// Lock for accessing the thread pool. 
	// Many worker threads might want to add itself
	// to the pool simultaniously
	Lock poolLock = new ReentrantLock();

	public ThreadPool(int numberOfThreads) {
		initThreadPool(numberOfThreads);
	}

	/**
	 * Initializes and starts all the threads in the pool
	 */
	private void initThreadPool(int numberOfThreads) {
		threadPool = new Stack<WorkerThread>();

		// Create and start all the threads in the pool.
		// The threads will sit and wait on their latches
		for ( int i = 0; i < numberOfThreads; i++ ) {
			WorkerThread t = new WorkerThread(new CountDownLatch(1), this);
			threadPool.push( t );
			t.start();
		}
	}


	/**
	 * Add a thread to the pool
	 * Must be thread safe
	 */
	public void pushThread(WorkerThread thread) {
		poolLock.lock();
		try {
			threadPool.push(thread);
		} finally {
			poolLock.unlock();
		}
	}

	/**
	 * Pull a thread from the pool
	 * must be thread safe
	 */
	private WorkerThread pullThread() {

		poolLock.lock();
		try {
			if ( !threadPool.empty() ) {
				return threadPool.pop();
		
			} else {
				return null;
			}

		} finally {
			poolLock.unlock();
		}
	}

	private void fireThread(WorkerThread t, String getRequest, DataOutputStream output) {

		t.setRequestData(getRequest, output);
		
		// wake up the thread
		CountDownLatch latch = t.getLatch();
		latch.countDown();
	}

	public void processRequest(String getRequest, DataOutputStream output) {
		// Remove a thread from the list
	
		WorkerThread t = pullThread();

		if ( t != null ) {
			fireThread(t, getRequest, output);					
			
			// Fail...
		} else {
			try {

				output.writeBytes("HTTP/1.0 500 Internal Server Error\nContent-Type: text/html\n\n");
				output.close();
			}catch(Exception e ){System.err.println(e.getMessage());}
		}
	}
}