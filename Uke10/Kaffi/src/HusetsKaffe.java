class HusetsKaffe extends Drikke {
    
    public HusetsKaffe(String st�rrelse) {
    	beskrivelse = "Husets kaffe";
    	setSt�rrelse(st�rrelse);
    }
    
    public double kostnad(){
    	return 29.90;
    }

	public int getSt�rrelse() {
		return st�rrelse;
	}    
}