public class Mokka extends Tilbeh¿r {
    
    /*
     * Peker til drikken som denne klassen wrapper
     */
    Drikke drikke;

    public Mokka(Drikke drikke){
    	this.drikke = drikke;
    }
    
    /*
     * For en mokka, ønsker vi at beskrivelsen skal
     * kunne si foreksempel: Mørkbrent, mokka
     */
    public String getBeskrivelse() {
    	return drikke.getBeskrivelse() + ", Mokka";
    }

    
    public double kostnad() {
    	double kostnad = drikke.kostnad();

		if ( getSt¿rrelse() == SMALL) {
			kostnad += 5;
		} else if (getSt¿rrelse() == MEDIUM) {
			kostnad += 7;
		} else if (getSt¿rrelse() == LARGE) {
			kostnad += 9;
		}

		return kostnad;
    }

	public int getSt¿rrelse() {
		return drikke.getSt¿rrelse();
	}

    
}