public class Pisket extends Tilbeh¿r {

	/*
	 * Peker til drikken som denne klassen wrapper
	 */
	Drikke drikke;

	public Pisket(Drikke drikke) {
		this.drikke = drikke;
	}

	/*
	 * For en Pisket, ønsker vi at beskrivelsen skal
	 * kunne si foreksempel: Espresso, Pisket
	 */
	public String getBeskrivelse() {
		return drikke.getBeskrivelse() + ", Pisket";
	}

	public double kostnad() {
		double kostnad = drikke.kostnad();

		if (getSt¿rrelse() == SMALL) {
			kostnad += 2;
		} else if (getSt¿rrelse() == MEDIUM) {
			kostnad += 4;
		} else if (getSt¿rrelse() == LARGE) {
			kostnad += 6;
		}

		return kostnad;
	}

	public int getSt¿rrelse() {
		return drikke.getSt¿rrelse();
	}

}