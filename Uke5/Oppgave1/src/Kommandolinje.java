import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Oppgave 7
 * @author michaelgunnulfsen
 *
 */
public class Kommandolinje {
	private ArrayList personliste;
	private Scanner scan; 

	public Kommandolinje() {
		personliste = new ArrayList(10);
		scan = new Scanner(System.in); 
		runShell();
		skrivUtListe();
	}
	
	
	private void skrivUtListe() {
		personliste.skrivUt();
	}


	private void runShell() {
		String input = "";	
		System.out.println("Hei. Legg til personer i listen din. Avslutt med \"ferdig\"");
		
		while ( true ) {
			System.out.print("\n> ");
			input = scan.nextLine();
			
			if ( input.equals("ferdig") ) break;
			
			if ( inputErLovlig(input)) { // Denne sjekken er ikke n¿dvendig, men fin :)
				
				personliste.leggTil(new Person(input));
			}				
		}			
	}


	/**
	 * Metode for Œ sjekke om en input setning er et lovlig navn
	 * Det er ikke pensum Œ kunne dette, men det er fint for de
	 * som er interesserte!
	 * 
	 * @param input teksten fra keyboard
	 * @return true hvis teksten er et lovlig navn
	 */
	private boolean inputErLovlig(String input) {	
		
		/*
		 * Simpelt forklart:
		 * 
		 * Stringen er lovlig hvis den bestŒr av en rekke bokstaver,
		 * etterfulgt av 0 eller 1 space. Dette mŒ repeteres en
		 * eller flere ganger. 
		 * 
		 * + betyr minst 1 eller fler forekomster,
		 * ? betyr 0 eller 1 forekomst
		 * [a-zA-Z] dekker alle bokstavene i det engelske alfabet
		 */
		return Pattern.matches("([a-zA-Z]+\\s?)+", input);
	}
}
