package no.uio.ifi.server;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class AskOracleController {

	private int highestBasePriority = 0;
	

	public static void main(String[] args) {
		// runSimulation();
		AskOracleController controller = new AskOracleController();
		Server server = new Server(controller);
		
		//runSimulation(controller);
		
		
		//server.waitForRequests();
	}

	public AskOracleController() {
		oracles = new IfiPriorityList();
		createOracles();
	}
	
	
	
	
	private void createOracles() {
		IfiPerson michael = new Oracle("Michael", 10);
		IfiPerson magnus = new Oracle("Magnus", 9);
		IfiPerson mikael = new Oracle("Mikael", 8);
		IfiPerson martin = new Oracle("Martin", 7);
		IfiPerson simen = new Oracle("Simen", 11);
		
		oracles.add(michael);
		oracles.add(magnus);
		oracles.add(mikael);
		oracles.add(martin);
		oracles.add(simen);
	}

	public IfiPerson[] getOracles() {
		return oracles.toArray();
	}

	private static void runSimulation( AskOracleController controller) {

		/* Opprett orakler og legg til studenter */
		Oracle magnus = new Oracle("Magnùs", 10);
		Oracle michael = new Oracle("Michael", 10);

		IfiPerson truls = new Student("Truls", controller.getLowestBasePriority(magnus), 0);
		magnus.addStudentToHelpList(truls);
		simulateWait();

		IfiPerson mikkel = new Student("Mikkel",
				controller.getLowestBasePriority(magnus) - 1, 0);
		michael.addStudentToHelpList(mikkel);
		simulateWait();

		IfiPerson thor = new Student("Thor", controller.getLowestBasePriority(magnus) - 1,
				0);
		magnus.addStudentToHelpList(thor);
		simulateWait();

		IfiPerson fredrik = new Student("Fredrik",
				controller.getLowestBasePriority(magnus) - 1, 0);
		magnus.addStudentToHelpList(fredrik);
		simulateWait();

		IfiPerson erlend = new Student("erlend",
				controller.getLowestBasePriority(michael) - 1, 0);
		michael.addStudentToHelpList(erlend);
		simulateWait();

		IfiPerson tuva = new Student("tuva",
				controller.getLowestBasePriority(michael) - 1, 0);
		michael.addStudentToHelpList(tuva);
		simulateWait();

		IfiPerson sigmund = new Student("sigmund",
				controller.getLowestBasePriority(michael) - 1, 0);
		michael.addStudentToHelpList(sigmund);
		simulateWait();

		IfiPerson karoline = new Student("karoline",
				controller.getLowestBasePriority(michael) - 1, 0);
		michael.addStudentToHelpList(karoline);
		simulateWait();

		System.out.println("Starter hjelping!");
		michael.getNextStudentToHelp();
		simulateWait();

		System.out.println("Mikkel enters again!");
		mikkel.setSkillLevel(mikkel.getSkillLevel() - 5);
		mikkel.setBasePriority(controller.getLowestBasePriority(magnus));
		magnus.addStudentToHelpList(mikkel);
		simulateWait();

		magnus.getNextStudentToHelp();
		simulateWait();

		System.out.println("Truls enters again!");
		truls.setSkillLevel(truls.getSkillLevel() - 5);
		truls.setBasePriority(controller.getLowestBasePriority(michael));
		michael.addStudentToHelpList(truls);
		simulateWait();

		magnus.getNextStudentToHelp();
		simulateWait();

		michael.getNextStudentToHelp();
		simulateWait();
	}

	private static void simulateWait() {
		try {
			Thread.sleep(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private IfiPriorityList oracles;

	public void addStudentToOracle(IfiPerson student, String oracleName) {
		Oracle oracle = (Oracle)oracles.getByName(oracleName);
		oracle.addStudentToHelpList(student);
	}

	public IfiPerson helpNextStudent(String oracleName) {
	//	Oracle oracle = oracles.get(oracleName);
		//IfiPerson student = oracle.getNextStudentToHelp();
		//return student;
		return null;
	}

	public int getLowestBasePriority(Oracle oracle) {
		IfiPerson personWithHighestPri = oracle.getStudentWithLowestPriority();
		if (personWithHighestPri == null)
			return 0;
		else
			return personWithHighestPri.getBasePriority();
	}

	public Oracle getOracles(String name) {
		return (Oracle)oracles.getByName(name);
	}
}
