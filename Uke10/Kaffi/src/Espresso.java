public class Espresso extends Drikke {
    
    public Espresso(String st�rrelse) {
    	// arver fra Drikke klassen
    	beskrivelse = "Espresso";
    	
    	setSt�rrelse(st�rrelse);
    }

    public double kostnad() {
    	return 39.90;
    }

	public int getSt�rrelse() {
		return st�rrelse;
	}
}


