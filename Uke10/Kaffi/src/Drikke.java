public abstract class Drikke {

    protected String beskrivelse = "Ukjent beskrivelse";
    public static int SMALL = 1, MEDIUM = 2, LARGE = 3;
    protected int st�rrelse;	

    public String getBeskrivelse() {
    	return beskrivelse;
    }
    
    protected void setSt�rrelse(String st�rrelse){
    	if ( st�rrelse.equals("small") ) {
    		this.st�rrelse = SMALL;
    	} else if (st�rrelse.equals("medium")){
    		this.st�rrelse = MEDIUM;
    	} else if (st�rrelse.equals("large")){
    		this.st�rrelse = LARGE;
    	}
    }

    public abstract int getSt�rrelse();
    public abstract double kostnad();
}
