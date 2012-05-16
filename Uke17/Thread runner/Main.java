import java.util.concurrent.CountDownLatch;


public class Main {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		// Create 4 teams
		Team [] teams = new Team[4];
		Monitor monitor = new Monitor(4,4);
		CountDownLatch startLatch = new CountDownLatch(3);
		
		for ( int i = 0; i < 4; i ++  ) {
			teams[i] = new Team(4,monitor,i,startLatch);
		}
		
		// Start all the runners
		System.out.println("[MAIN] starting all the runners;");
		for ( int i = 0; i < 4; i ++  ) {
			teams[i].start();
		}
		System.out.println("THREE!");
		startLatch.countDown();
		Thread.sleep(2000);
		
		System.out.println("TWO!");
		startLatch.countDown();
		Thread.sleep(2000);
		
		System.out.println("ONE!");		
		Thread.sleep(2000);		
		System.out.println("GO");
		startLatch.countDown();
		
		// wait for everyone to finish;
		monitor.waitForTeamsToFinish();
		
		System.out.println("Everyone's done! Printing res:");
		for(Team t : teams){
			System.out.println("[MAIN] Team: " + t.getTeamNumber() + " got place: " + t.getPlace());
		}

	}

}
