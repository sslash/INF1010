/**
 * Oppgave 4
 * 
 * @author michaelgunnulfsen
 *
 */
public class Lifo {

	private Person forstePerson;

	/**
	 * Sett inn en person f¿rst i listen
	 * 
	 * @param ny
	 *            person Œ sette inn
	 * @return
	 */
	public boolean putt(Person ny) {
		if (forstePerson == null)
			forstePerson = ny;

		else {
			ny.setNestePerson(forstePerson);
			forstePerson = ny;
		}

		return true; // Forel¿big ingen grunn til at denne kan returnere false

	}

	/**
	 * Hent personen med navn navn
	 * 
	 * @return personen med navn navn, eller null hvis den ikke finnes
	 */
	public Person hent(String navn) {
		Person tmp = forstePerson;
		while (tmp != null) {
			if (tmp.equals(new Person(navn)))
				return tmp;
			tmp = tmp.getNestePerson();
		}
		return null;
	}

	/**
	 * Fjern forste person i lista
	 * 
	 * @return
	 */
	public Person fjern() {
		Person fjernPerson = null;

		if (forstePerson != null)
			if (forstePerson.getNestePerson() == null)
				forstePerson = null;

			else {
				fjernPerson = forstePerson;
				forstePerson = fjernPerson.getNestePerson();
			}
		
		return fjernPerson;
	}
}
