
public class Person {
	

	@Override
	public String toString() {
		return navn + " [" + rang + "]";
	}

	private Person nestePerson;	
	private String navn;

	
	public Person(String name) {
		this.navn = name;
	}	


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (navn == null) {
			if (other.navn != null)
				return false;
		} else if (!navn.equals(other.navn))
			return false;
		return true;
	}

	public String getNavn() {
		return navn;
	}

	public Person getNestePerson() {
		return nestePerson;
	}

	public void setNestePerson(Person nestePerson) {
		this.nestePerson = nestePerson;		
	}
	
	
	/****************************************************
	 * 					Oppgave 8						*
	 ****************************************************/
	private int rang;
	
	public int getRang() {
		return rang;
	}
	
	public Person(String navn, int rang) {
		this(navn);
		this.rang = rang;
	}
	
	
	/****************************************************
	 * 					Oppgave 10						*
	 ****************************************************/
	private Person forrige;
	public Person getForrige() {
		return forrige;
	}
	
	public void setForrige(Person forrige) {
		this.forrige = forrige;
	}
	
}
