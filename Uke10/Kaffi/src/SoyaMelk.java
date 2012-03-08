public class SoyaMelk extends Tilbeh�r {
    Drikke drikke;

    public SoyaMelk(Drikke drikke) {
	this.drikke = drikke;
    }

    public String getBeskrivelse() {
	return drikke.getBeskrivelse() + ", Soya melk";
    }

    public double kostnad() {
    	double kostnad = drikke.kostnad();
    	if ( getSt�rrelse() == SMALL ){
    		kostnad += 7;
    	} else if (getSt�rrelse() == MEDIUM ){
    		kostnad += 9;
    	} else if (getSt�rrelse() == LARGE ){
    		kostnad += 11;
    	}
    	
    	return kostnad;    		
    }

	public int getSt�rrelse() {
		return drikke.getSt�rrelse();
	}
}