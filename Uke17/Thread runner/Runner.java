import java.util.Random;


public class Runner extends Thread {

	private Monitor monitor;
	private int teamNum;
	private int runnerNum;
	
	public Runner(Monitor m, int teamNum, int runnerNum) {
		this.monitor = m;
		this.teamNum = teamNum;
		this.runnerNum = runnerNum;
	}
	
	public void run() {
		
		simulateRun();
		monitor.runnerDone(teamNum, runnerNum);		
	}
	
	private void simulateRun() {
		try {
			sleep(new Random().nextInt(10) * 1000);
		} catch (InterruptedException e) {
		}
	}
}
