public class SoyaMelk extends Tilbeh퓊 {
    Drikke drikke;

    public SoyaMelk(Drikke drikke) {
	this.drikke = drikke;
    }

    public String getBeskrivelse() {
	return drikke.getBeskrivelse() + ", Soya melk";
    }

    public double kostnad() {
    	double kostnad = drikke.kostnad();
    	if ( getSt퓊relse() == SMALL ){
    		kostnad += 7;
    	} else if (getSt퓊relse() == MEDIUM ){
    		kostnad += 9;
    	} else if (getSt퓊relse() == LARGE ){
    		kostnad += 11;
    	}
    	
    	return kostnad;    		
    }

	public int getSt퓊relse() {
		return drikke.getSt퓊relse();
	}
}