public abstract class Drikke {

    protected String beskrivelse = "Ukjent beskrivelse";
    public static int SMALL = 1, MEDIUM = 2, LARGE = 3;
    protected int st퓊relse;	

    public String getBeskrivelse() {
    	return beskrivelse;
    }
    
    protected void setSt퓊relse(String st퓊relse){
    	if ( st퓊relse.equals("small") ) {
    		this.st퓊relse = SMALL;
    	} else if (st퓊relse.equals("medium")){
    		this.st퓊relse = MEDIUM;
    	} else if (st퓊relse.equals("large")){
    		this.st퓊relse = LARGE;
    	}
    }

    public abstract int getSt퓊relse();
    public abstract double kostnad();
}
