import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Monitor {
	private int teams;
	private int runners;
	private CountDownLatch [] teamsLatches;
	private int currentPlace = 1;
	
	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock();
	
	public Monitor (int t, int r) {
		teams = t; runners = r;
		teamsLatches = new CountDownLatch[teams];
		
		// init latches for each team
		for ( int i = 0; i < teams; i ++ ) 
			teamsLatches[i] = new CountDownLatch(runners);
	}
	
	// Called by the main thread
	public void waitForTeamsToFinish() throws InterruptedException {
		
		// Wait for each team
		for ( int i = 0; i < teams; i ++ ) {
			teamsLatches[i].await();
		}
	}
	
	
	public void runnerDone(int teamNumber, int runnerNum) {
		lock1.lock();
		teamsLatches[teamNumber].countDown();
		
		// Create a nice space thing
		for ( int i = 0; i < teamNumber*3; i ++ )
			System.out.print("\t");
		
		System.out.println("[Team " + teamNumber + "] runner number " + runnerNum);
		
		lock1.unlock();
	}
	
	public int saveFinishPlace() {
		lock2.lock();
		int resultToReturn = currentPlace;
		
		// set place for the next runner
		currentPlace ++;
		
		// return this team's place
		lock2.unlock();
		return resultToReturn;
	}

}
