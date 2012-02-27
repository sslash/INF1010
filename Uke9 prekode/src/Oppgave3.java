/**
 * La pizza implementere grensesnittet Comparable.
 * En pizza skal kunne sammenlignes med en annen pizza.
 * Pizzaen skal sammenlignes pŒ rate. Et kall pŒ denne metoden
 * skal kj¿re uten fei:
 
 void testComparablePizzas() {
 	Pizza veggie = new NyPizza("Veggie", "Thin", "Tomato", new String[] {
					"Onion", "Squash" }, 10));
					
	Pizza bbq =	nyPizzas.add(new NyPizza("Barbique", "Thick", "Tomato", new String[] {
					"Onion", "Chicken" }, 13));
					
	Pizza shrimp = nyPizzas.add(new NyPizza("Shrimp", "Thin", "Tomato garlic",
					new String[] { "Shrimps", "Capers" }, 13));
	
	if ( veggie.compareTo(bbq) >= 0 ) {
		System.err.println("Error in comparing veggie to bbq");
		System.exit(1);
	}
	
	if ( shrimp.compareTo(veggie) <= 0 ) {
		System.err.println("Error in comparing shrimp to veggie");
		System.exit(1);
	 }
	 
	 if ( shrimp.compareTo(bbq) != 0 ) {
		System.err.println("Error in comparing shrimp to bbq");
		System.exit(1);
	 }
}

*/

/** 
 * @author michael gunnulfsen
 *
 */
public class Oppgave3 {

}
