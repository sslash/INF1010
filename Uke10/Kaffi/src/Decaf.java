public class Decaf extends Drikke {

	public Decaf(String st�rrelse) {
		beskrivelse = "Decaf (uten koffein)";
		
		setSt�rrelse(st�rrelse);
	}
	
	public int getSt�rrelse() {
		return st�rrelse;
	}

	public double kostnad() {
		return 19.90;
	}
	

}
