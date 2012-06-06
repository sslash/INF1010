class Main {

	public static void main( String [] args ) {
		
	}
}

class ElektronikkVare {

	int pris;

	public ElektronikkVare(int pris) {
		this.pris = pris;
	}

	public int getPris() {
		return pris;
	}
}

class Pc extends ElektronikkVare {
	public Pc (int pris ) {
		super(pris);
	}
}

class Kamera extends ElektronikkVare {
	public Kamera (int pris) {
		super(pris);
	}
}

class MobilTelefon extends ElektronikkVare {
	public MobilTelefon( int pris ) {
		super(pris);
	}
}