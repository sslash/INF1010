
/**
 * Oppgave 6
 * @author michaelgunnulfsen
 *
 */
public class ArrayList {
	
	private Person [] personListe;
	private int forste,neste; // indekser
	private int storrelse, maksStorrelse;
	
	public ArrayList(int str) {
		personListe = new Person[str];
		maksStorrelse = str;
	}

	/**
	 * Legg til sist i lista
	 * @param ny person som skal inn
	 * @return true hvis alt gikk fint
	 */
	public boolean leggTil(Person ny) {
		if ( storrelse == maksStorrelse ) 
			return false;
		
		personListe[neste] = ny;
		neste = okIndex(neste); 
		storrelse ++;
		
		return true;
	}
	
	/**
	 * Fjern siste person i listen
	 * @return
	 */
	public void fjern() {
		if ( storrelse == 0 ) return;
		
		personListe[forste] = null;
		
		// Sett forste 
		forste = okIndex(forste);
		storrelse --;
	}
	
	public void skrivUt() {		
		for ( int c = 0, i = forste; c < storrelse; c++, i = okIndex(i) ) 		
			System.out.print(personListe[i] + " | "); // kaller toString i person klassen
		
		System.out.println();
	}
	
	
	// Hjelpe metoder
	
	/**
	 * Denne metoden gj¿r listen sirkul¾r ved Œ 
	 * sette indeksen til 0 nŒr indeksen har nŒdd
	 * enden av arrayet.
	 */
	private int okIndex(int index) {
		return (index + 1) % maksStorrelse; 
	}
}
