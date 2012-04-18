import java.util.ArrayList;
import java.util.List;


public class Personer {

	private Person personliste;
	
	/****************************************************
	 * 					Oppgave 1						*
	 ****************************************************/
	public void leggTilFørst(Person nyPerson) {	
		if ( personliste == null )
			personliste = nyPerson;
		else {		
			nyPerson.setNestePerson(personliste);
			personliste = nyPerson;
		}
		
		List l = new ArrayList() ;
		l.add(null);
		
		
	}
	
	
	
	
	/****************************************************
	 * 					Oppgave 3						*
	 ****************************************************/
	public Person finnPerson(String navn) {
		Person tmp = personliste;
		Person mistenkt = new Person(navn);	// Midlertidig objekt for sammenligning
		
		while ( tmp != null ) {
			if ( tmp.equals(mistenkt) ) 
				return tmp;
			else
				tmp = tmp.getNestePerson();
		}		
		return null;
	}	 
	
	public Person finnPersonFør(String navn) {
		Person tmp = personliste;
		Person førTmp = null; // dette er personen vi er ute etter
		Person mistenkt = new Person(navn);
		
		while ( tmp != null ) {
			if (tmp.equals(mistenkt))
				return førTmp;
			else {
				førTmp = tmp;
				tmp = tmp.getNestePerson();
			}
		}
		
		return null;
	}
	
	
	public Person taUtPersonEtter(String navn) {
		Person foran = finnPerson(navn); // Personen foran den vi skal slette
		if ( foran == null || foran.getNestePerson() == null )
			return null;
		
		// Selve slettninga
		Person slettPers = foran.getNestePerson();
		foran.setNestePerson( slettPers.getNestePerson() );
		return slettPers;
	}
	
	public Person taUtNestSistePerson() {		
		if ( personliste == null || personliste.getNestePerson() == null )
			return null;
		
		// Finn nest siste person 
		Person tmp = personliste.getNestePerson();
		Person tmpForan = personliste;
		while (tmp.getNestePerson() != null ) {
			tmpForan = tmp;
			tmp = tmp.getNestePerson();
		}
		
		return fjernPerson(tmpForan.getNavn());
	}

	private Person fjernPerson(String navn) {
		Person fjern = finnPerson(navn);
		if (fjern == null || personliste == null)
			return null;
		if ( fjern == personliste )
			personliste = personliste.getNestePerson();
		else {
		
		Person foran = finnPersonFør(navn);
		foran.setNestePerson(fjern.getNestePerson());
		}
		return fjern;
	}
	
	private Person finnPersonenForan(Person nyPerson) {
		Person tmp = personliste, tmpPrev = tmp;
		while ( tmp != null && tmp.getRang() < nyPerson.getRang() ) {
			tmpPrev = tmp;
			tmp = tmp.getNestePerson();
		}
		
		return tmp;
	}
	
	
	public void skrivUt() {
		Person tmp = personliste;
		while (tmp != null ) {
			System.out.print ( tmp + " -> " );
			tmp = tmp.getNestePerson();
		}
		
		System.out.println();		
	}
	
	

	/****************************************************
	 * 					Oppgave 8						*
	 ****************************************************/
	
	public void settInnEtterRang( Person inn ) {
		if ( personliste == null ) 
			personliste = inn;
		else {
			
			// Finn personen foran og etter den som skal inn
			Person tmp = personliste, tmpPrev = tmp;
			while ( tmp != null && tmp.getRang() < inn.getRang() ) {
				tmpPrev = tmp;
				tmp = tmp.getNestePerson();
			}
			
			// inn -> tmp
			// Sett inn personen først	
			inn.setNestePerson(tmp);
			
			
			// tmpPrev -> inn
			
			// Hvis vi skal inn først, er det ingen bak oss	
			if ( tmp == personliste) 
				personliste = inn;
			
			// Sett forrige til å peke på oss
			 else 
				tmpPrev.setNestePerson(inn);
			
		}
	}
	
	
	/****************************************************
	 * 					Oppgave 9						*
	 ****************************************************/
	
	/* Tomme person objekter som kun blir brukt til pekere i listen */
	Person hode, hale;
	
	/**
	 * Ny konstruktør for å opprette liste med hode og hale
	 */
	/*
	public Personer() {
		hode = new Person(null, 0);
		hale = new Person(null, 0);
		hode.setNestePerson(hale);		
	}
	*/
	
	public void settInnEtterRang2( Person inn ) {
		Person foran = hode;
		Person tmp = hode.getNestePerson();
		
		// Vi må ta vare på foran pekeren, for å sette hans neste peker til oss
		while ( tmp != hale && tmp.getRang() < inn.getRang() ){
			foran = tmp;
			tmp = tmp.getNestePerson();
		}
		
		settInn(inn, foran);
	}
	
	
	private void settInn( Person inn, Person foran) {
		// Sett inn sin neste til foran sin neste
		inn.setNestePerson(foran.getNestePerson());
		
		// Sett foran sin neste til inn
		foran.setNestePerson(inn);		
	}
	
	public void skrivUt2() {
		Person tmp = hode.getNestePerson();
		
		while (tmp != hale ) {
			System.out.print ( tmp + " -> " );
			tmp = tmp.getNestePerson();
		}
		System.out.println();
	}
	
	
	/****************************************************
	 * 					Oppgave 10						*
	 ****************************************************/
	
	public Personer() {
		hode = new Person(null, 0);
		hale = new Person(null, 0);
		hode.setNestePerson(hale);	
		hale.setForrige(hode);
	}
	
	public void settInnEtterRang3( Person inn ) {
		Person tmp = hode.getNestePerson();
		
		while ( tmp != hale && tmp.getRang() < inn.getRang() ){
			tmp = tmp.getNestePerson();
		}
		
		settInn2(inn, tmp);
	}
	
	private void settInn2(Person inn, Person bak){
		// Sett den nye personens pekere
		inn.setNestePerson(bak);				// inn -> bak
		inn.setForrige(bak.getForrige());		// bak.forrige <- inn 
		
		// Sett Personen foran sin peker
		Person foran = inn.getForrige();		
		foran.setNestePerson(inn);				// foran -> inn
		
		// Sett personen bak sin forrige peker
		bak.setForrige(inn);					// inn <- bak
	}	
}
