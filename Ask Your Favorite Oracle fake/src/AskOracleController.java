import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class AskOracleController {
	
	
	public static void main(String [] args ) {
		runSimulation();			
	}

	private static void runSimulation() {
		
		/* Opprett orakler og legg til studenter */
		Oracle magnus 	= new Oracle("Magnùs", 10);
		Oracle michael 	= new Oracle("Michael", 10);
		
		IfiPerson truls 	= new Student("Truls",		getLowestBasePriority(magnus), 0);
		magnus.addStudentToHelpList(truls);
		simulateWait();
		
		IfiPerson mikkel 	= new Student("Mikkel",		getLowestBasePriority(magnus)-1, 0);
		michael.addStudentToHelpList(mikkel);
		simulateWait();
		
		IfiPerson thor 		= new Student("Thor",		getLowestBasePriority(magnus)-1, 0);
		magnus.addStudentToHelpList(thor);
		simulateWait();
		
		IfiPerson fredrik 	= new Student("Fredrik",	getLowestBasePriority(magnus)-1, 0);
		magnus.addStudentToHelpList(fredrik);
		simulateWait();
		
		IfiPerson erlend 	= 	new Student("erlend", 	getLowestBasePriority(michael)-1, 0);
		michael.addStudentToHelpList(erlend);
		simulateWait();
		
		IfiPerson tuva 		= 	new Student("tuva",		getLowestBasePriority(michael)-1, 0);
		michael.addStudentToHelpList(tuva);
		simulateWait();
		
		IfiPerson sigmund 	= 	new Student("sigmund",	getLowestBasePriority(michael)-1, 0);
		michael.addStudentToHelpList(sigmund);
		simulateWait();
		
		IfiPerson karoline 	= 	new Student("karoline",	getLowestBasePriority(michael)-1, 0);
		michael.addStudentToHelpList(karoline);
		simulateWait();	
		
		
		System.out.println("Starter hjelping!");
		michael.getNextStudentToHelp();
		simulateWait();
		
		System.out.println("Mikkel enters again!");
		mikkel.setSkillLevel(mikkel.getSkillLevel() -5 );
		mikkel.setBasePriority(getLowestBasePriority(magnus));
		magnus.addStudentToHelpList(mikkel);
		simulateWait();
		
		magnus.getNextStudentToHelp();
		simulateWait();
		
		System.out.println("Truls enters again!");
		truls.setSkillLevel(truls.getSkillLevel() - 5);
		truls.setBasePriority(getLowestBasePriority(michael));
		michael.addStudentToHelpList(truls);
		simulateWait();
		
		magnus.getNextStudentToHelp();
		simulateWait();
		
		michael.getNextStudentToHelp();
		simulateWait();
	}

	private static void simulateWait() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}

	
	
	private static int getLowestBasePriority(Oracle oracle) {
		IfiPerson personWithHighestPri = oracle.getStudentWithLowestPriority();
		if ( personWithHighestPri == null)
			return 0;
		else
			return personWithHighestPri.getBasePriority();
	}
}
