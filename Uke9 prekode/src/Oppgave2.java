/**
 * Endre oppgave 1 til Œ bruke en generisk array i stedenfor Œ bruke et array av
 * typen object. Legg merke til hvordan kj¿re-feilen i den andre testen endrer
 * seg til Œ bli en kompilator feil.
 * 
 * @author michael gunnulfsen
 * 
 */

public class Oppgave2 {

	public Oppgave2() {
		testAddNyPizza();
		//testAddChicagoPizza();

	}

	private void testAddNyPizza() {
		MyPizzaContainer nyPizzas = new MyPizzaContainer();
		
			
			nyPizzas.add(new NyPizza("Veggie", "Thin", "Tomato", new String[] {
					"Onion", "Squash" },10));
			nyPizzas.add(new NyPizza("Barbique", "Thick", "Tomato", new String[] {
					"Onion", "Chicken" }, 12));
			nyPizzas.add(new NyPizza("Shrimp", "Thin", "Tomato garlic",
					new String[] { "Shrimps", "Capers" }, 13));
			nyPizzas.add(new NyPizza("Hot chicken", "Thick crust", "Hot mustard",
					new String[] { "Onion", "Chicken", "Bacon", "Chili" }, 15));
			nyPizzas.add(new NyPizza("Taco", "Soft", "Tomato", new String[] {
					"Onion", "Garlic", "Hot spice" }, 1));
			nyPizzas.add(new NyPizza("Bacon", "Thick and crispy", "Tomato",
					new String[] { "Onion", "Bacon" }, 20));

		// test size
		if (nyPizzas.size() != 6) {
			System.err.println("wrong size!");
			System.exit(1);
		}

		// test get
		// Note that we have to cast the value returned!
		NyPizza veggie = (NyPizza) nyPizzas.get(0);
		if (!veggie.getName().equals("Veggie")) {
			System.err.println("Error adding the first pizza!");
			System.exit(2);
		}
	}

	private void testAddChicagoPizza() {
		MyPizzaContainer chicagoPizzas = new MyPizzaContainer();
		
		chicagoPizzas.add(new ChicagoPizza("Chicago special", "Extra thick",
				"Tomato", new String[] { "Greeb peppers", "Mushrooms" }, 8));
		
		chicagoPizzas.add(new ChicagoPizza("Chicago supreme", "Thin crust",
				"Tomato garcic", new String[] { "Onion", "Chicken", "Bacon" }, 10));
		
		chicagoPizzas.add(new NyPizza("Chicago veggie", "Thin", "Tomato",
				new String[] { "green peppers", "Mushrooms" }, 20));

		ChicagoPizza special = (ChicagoPizza) chicagoPizzas.get(0);
		ChicagoPizza supreme = (ChicagoPizza) chicagoPizzas.get(1);
		ChicagoPizza veggie = (ChicagoPizza) chicagoPizzas.get(2);
	}
}

/**
 * Keeps a growable array of Objects
 * 
 * @author michael gunnulfsen
 * 
 */
interface SimplePizzaContainer <T>{
	/**
	 * Returns the number of objects in the collection
	 * 
	 * @return the number of elements
	 */
	public int size();

	/**
	 * Returns the element at the given index
	 * 
	 * @return object at the given index in the array
	 */
	public T get(int index);

	/**
	 * Add the object to the end of the array. Should extend the size of the
	 * array if the array is full.
	 * 
	 * @return true (as per java.util.ArrayList)
	 */
	public boolean add(T element);
}

class MyPizzaContainer <T> implements SimplePizzaContainer <T>{

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public boolean add(T element) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return null;
	}
}
