
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		// Run shell
		//new Kommandolinje();
		
		
		// Run tests
		try {	
			//leggTilPersonTest();
			//innPersonTest();
			//finnPersonF¿rTest();
			//taUtPersonEtterTest();
			//taUtNestSistePersonTest();
			//testLifo();
			testArrayList();
			
			//leggTilPersonEtterRangTest();
			
			//leggTilPersonEtterRangTest2();
			
			//leggTilPersonEtterRangTest3();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private static void leggTilPersonEtterRangTest() throws Exception {
		Person jona = new Person("Jonathan",10);
		Person sus = new Person("Susanne",20);
		Person imran = new Person("Imran", 5);
		Personer personliste = new Personer();
		
		personliste.settInnEtterRang(jona);
		personliste.settInnEtterRang(sus);
		personliste.settInnEtterRang(imran);
		
		//Forventet liste:  imran -> jonathan -> susanne
		
		personliste.skrivUt();
		if ( imran.getNestePerson() != jona )
			throw new Exception("Feil struktur i listen (Imran)");
		
		if ( jona.getNestePerson() != sus )
			throw new Exception("Feil struktur i listen (Jonathan)");
		
		if ( sus.getNestePerson() != null )
			throw new Exception("Feil struktur i listen (Susanne)");
		
			
	}
	
	private static void leggTilPersonEtterRangTest2() throws Exception {
		Person jona = new Person("Jonathan",10);
		Person sus = new Person("Susanne",20);
		Person imran = new Person("Imran", 5);
		Person jon = new Person("Jon", 5);
		Personer personliste = new Personer();
		
		personliste.settInnEtterRang2(jona);
		personliste.settInnEtterRang2(sus);
		personliste.settInnEtterRang2(imran);
		personliste.settInnEtterRang2(jon);
		
		//Forventet liste:  imran -> jonathan -> susanne
		
		personliste.skrivUt();
		if ( imran.getNestePerson() != jona )
			throw new Exception("Feil struktur i listen (Imran)");
		
		if ( jona.getNestePerson() != sus )
			throw new Exception("Feil struktur i listen (Jonathan)");
		
		if ( sus.getNestePerson() != personliste.hale )
			throw new Exception("Feil struktur i listen (Susanne)");
		
			
	}
	
	private static void leggTilPersonEtterRangTest3() throws Exception {
		Person jona = new Person("ThorWildz",10);
		Person sus = new Person("Big Mike",20);
		Person imran = new Person("Trusl", 5);
		Person jon = new Person("Martz", 5);
		Personer personliste = new Personer();
		
		personliste.settInnEtterRang3(jona);
		personliste.settInnEtterRang3(sus);
		personliste.settInnEtterRang3(imran);
		personliste.settInnEtterRang3(jon);
		
		//Forventet liste:  imran -> jonathan -> susanne
		
		if ( imran.getNestePerson() != jona )
			throw new Exception("Feil struktur i listen (Imran)");
		
		if ( jona.getNestePerson() != sus )
			throw new Exception("Feil struktur i listen (Jonathan)");
		
		if ( sus.getNestePerson() != personliste.hale )
			throw new Exception("Feil struktur i listen (Susanne)");
		

		personliste.skrivUt2();
		
			
	}


	private static void testArrayList() {
		ArrayList list = new ArrayList(5);
		Person jona = new Person("Jonathan");
		Person sus = new Person("Susanne");	
		Person imran = new Person("Imran");	
		Person nik = new Person("Nikita");
		Person eli = new Person("Elisabeth");
		
		list.leggTil(jona);
		list.leggTil(sus);
		list.leggTil(imran);
		list.leggTil(nik);
		list.leggTil(eli);		
		list.skrivUt();
		
		// fjern 2
		System.out.println();
		list.fjern();
		list.fjern();
		list.skrivUt();
		
		// Legg til to nye
		System.out.println();
		list.leggTil(jona);
		list.leggTil(sus);
		list.skrivUt();
		
		// fjern 1
		System.out.println();
		list.fjern();
		list.skrivUt();
	}


	private static void testLifo() throws Exception {
		Lifo personListe = new Lifo();
		
		// Test med en person
		Person jona = new Person("Jonathan");
		personListe.putt(jona);	
		personListe.fjern();
		
		if ( personListe.hent("Jonathan") != null) 
			throw new Exception("Kunne ikke legge til en person");
		
		// Test med to personer
		Person sus = new Person("Susanne");
		personListe.putt(jona);	
		personListe.putt(sus);	
		personListe.fjern();
		if ( personListe.hent("Jonathan") != jona ) 
			throw new Exception("Kunne ikke fjerne et element fra listen nŒr to personer lŒ i listen");
		
		if ( personListe.hent("Susanne") != null )
			throw new Exception("Returnerte et element (Susanne) som ikke skulle v¾re i listen");
		
		
	}


	private static void taUtNestSistePersonTest() throws Exception {
		Personer personer = new Personer();
		
		Person jona = new Person("Jonathan");
		Person sus = new Person("Susanne");	
		Person imran = new Person("Imran");	
		Person nik = new Person("Nikita");
		
		// nik -> imran -> sus -> jona
		personer.leggTilF¿rst(jona);
		personer.leggTilF¿rst(sus);
		personer.leggTilF¿rst(imran);
		personer.leggTilF¿rst(nik);
		
		personer.taUtNestSistePerson();
		if ( personer.finnPerson("Susanne") != null )
			throw new Exception("kunne ikke fjerne nest siste person (Susanne)");
		
		
		personer.taUtNestSistePerson();
		if ( personer.finnPerson("Imran") != null )
			throw new Exception("kunne ikke fjerne nest siste person (Imran)");		
	}


	private static void taUtPersonEtterTest() throws Exception {
		Personer personer = new Personer();
		
		Person jona = new Person("Jonathan");
		Person sus = new Person("Susanne");	
		Person imran = new Person("Imran");	
		Person nik = new Person("Nikita");
		Person eli = new Person("Elisabeth");
		
		// eli -> nik -> imran -> sus -> jona
		personer.leggTilF¿rst(jona);
		personer.leggTilF¿rst(sus);
		personer.leggTilF¿rst(imran);
		personer.leggTilF¿rst(nik);
		personer.leggTilF¿rst(eli);
		
		
		// Test slett nik
		personer.taUtPersonEtter("Elisabeth");
		if ( personer.finnPerson("Nikita") != null )
			throw new Exception("Kunne ikke fjerne Nikita");
		
		// Test slett jona
		personer.taUtPersonEtter("Susanne");
		if ( personer.finnPerson("Jonathan") != null )
			throw new Exception("Kunne ikke fjerne Jonathan");		
		
		// Test slett imran
		personer.taUtPersonEtter("Elisabeth");
		if ( personer.finnPerson("Imran") != null )
			throw new Exception("Kunne ikke fjerne Imran");	
	}


	private static void finnPersonF¿rTest() throws Exception {
		Personer personer = new Personer();
		
		Person jona = new Person("Jonathan");
		Person sus = new Person("Susanne");	
		Person imran = new Person("Imran");	
		
		// Elisabeth -> Nikita -> Imran -> Susanne -> Jona
		personer.leggTilF¿rst(jona);
		personer.leggTilF¿rst(sus);
		personer.leggTilF¿rst(imran);
		
		
			if (personer.finnPersonF¿r("Imran") != null)
				throw new Exception("Fant ikke personen f¿r Imran");
			
			if ( personer.finnPersonF¿r("Susanne") != imran) 
				throw new Exception("Fant ikke personen f¿r Susanne");
			
			if ( personer.finnPersonF¿r("Jonathan") != sus) 
				throw new Exception("Fant ikke personen f¿r imran");	
		
	}


	private static void leggTilPersonTest() throws Exception {
		Personer personer = new Personer();
		
		Person jona = new Person("Jonathan");
		Person sus = new Person("Susanne");
		Person imr = new Person("Imran");
		Person nik = new Person("Nikita");
		Person eli = new Person("Elisabeth");
		
		personer.leggTilF¿rst(jona);
		personer.leggTilF¿rst(sus);
		personer.leggTilF¿rst(imr);
		personer.leggTilF¿rst(nik);
		personer.leggTilF¿rst(eli);
		
		if ( jona.getNestePerson() != null )
			throw new Exception("Jona");
		if ( sus.getNestePerson() != jona )
			throw new Exception("Sus feilet");
		if ( imr.getNestePerson() != sus )
			throw new Exception("Imr feilet");
		if ( nik.getNestePerson() != imr )
			throw new Exception("nik feilet");
		if ( eli.getNestePerson() != nik )
			throw new Exception("Eli feilet");
		
		
	}

	private static void finnPersonTest() throws Exception {
		Personer personer = new Personer();
		
		Person p1 = new Person("Jonathan");
		Person p2 = new Person("Susanne");	
		
		personer.leggTilF¿rst(p1);
		personer.leggTilF¿rst(p2);
		
		
			if (p1 != personer.finnPerson("Jonathan"))
				throw new Exception("Kunne ikke finne jonathan");
			
			if ( p2 != personer.finnPerson("Susanne")) 
				throw new Exception("Kunne ikke finne Susanne");		
	}
}
