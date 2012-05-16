import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;


public class Team extends Thread {

	private List <Runner> runners;
	private int myRes;
	private Monitor monitor;
	private int teamNum;
	private CountDownLatch startLatch;
	
	
	public Team( int nRunners, Monitor monitor, int teamNum, CountDownLatch startLatch ) {
		this.teamNum = teamNum;
		this.monitor = monitor;
		runners = new LinkedList<Runner>();
		this.startLatch = startLatch;
		
		// init all runners
		for (int i = 0; i < nRunners; i ++ ){
			runners.add( new Runner(monitor, teamNum, i) );
		}
	}
	
	public void run() {
		goTeam();
	}
	
	// Gets called when a team is about to run
	public void goTeam() {
		
		waitForStartSignal();
		
		Iterator <Runner> runnersIterator = runners.iterator();
		
		while ( runnersIterator.hasNext() ) {
			
			Runner currentRunner = runnersIterator.next();
			
			// start the runner
			currentRunner.start();
			
			// wait untill the runner is done, then start the next
			try {
				currentRunner.join();
			} catch (InterruptedException e) {
			}
		}
		
		// This team is done, get the result
		myRes = monitor.saveFinishPlace();		
	}
	
	private void waitForStartSignal() {
		try {
			startLatch.await();
		} catch (InterruptedException e) {
		}
	}
	
	// get the place for this team
	public int getPlace() {
		return myRes;
	}

	public String getTeamNumber() {
		return teamNum + "";
	}
}
