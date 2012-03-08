
public class Starb¿xKaffi{

    public static void main( String args[] ) {
	Drikke drikke = new Espresso("Small"); // Bestill en vanlig espresso
	System.out.println(drikke.getBeskrivelse() + " kr " + drikke.kostnad());
	
	Drikke drikke2 = new M¿rkbrent("Medium"); // Lag en mørkbrent dobbel mokka med soya melk
	drikke2 = new Mokka(drikke2);
	drikke2 = new Mokka(drikke2);
	drikke2 = new SoyaMelk(drikke2);
	System.out.println(drikke2.getBeskrivelse() + " kr " + drikke2.kostnad());

	Drikke drikke3 = new HusetsKaffe("Large"); // Lag en husets kaffe med soya, mokka og pisket
	drikke3 = new SoyaMelk(drikke3);
	drikke3 = new Mokka(drikke3);
	drikke3 = new Pisket(drikke3);
		System.out.println(drikke3.getBeskrivelse() + " kr " + drikke3.kostnad());
   
    Drikke drikke4 = new Decaf("Medium");
    drikke4 = new SoyaMelk(drikke4);
    System.out.println(drikke4.getBeskrivelse() + " kr " + drikke4.kostnad());    
    }

}