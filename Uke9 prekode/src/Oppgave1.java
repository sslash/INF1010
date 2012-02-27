/**
 * A) Lag en klasse (MyPizzaContainer) som tar vare på et array av hva som helst
 * (bruk array av typen object). MyPizzaContainer skal implementere
 * grensesnittet SimplePizzaContainer.java.
 * 
 * Få testen i konstruktøren til å kjøre.
 * 
 * B) Fjern kommenteringen på test-metoden "testAddChicagoPizza()" og prøv å
 * kjør programmet. Finn ut hva som går galt og fjern feilen.
 * 
 * @author michael gunnulfsen
 * 
 */

public class Oppgave1 {

	public Oppgave1() {
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
		
		for ( Object o : nyPizzas.container) {
			NyPizza p = (NyPizza) o;
			System.out.println(p);
		}
	}

	private void testAddChicagoPizza() {
		MyPizzaContainer chicagoPizzas = new MyPizzaContainer();
		
		chicagoPizzas.add(new ChicagoPizza("Chicago special",
				"Tomato", new String[] { "Greeb peppers", "Mushrooms" }, 8));
		
		chicagoPizzas.add(new ChicagoPizza("Chicago supreme", 
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
interface SimplePizzaContainer {
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
	public Object get(int index);

	/**
	 * Add the object to the end of the array. Should extend the size of the
	 * array if the array is full.
	 * 
	 * @return true (as per java.util.ArrayList)
	 */
	public boolean add(Object element);
}

class MyPizzaContainer implements SimplePizzaContainer {

	@Override
	public int size() {
		return current_size;
	}

	@Override
	public Object get(int index) {
		return container[index];
	}

	@Override
	public boolean add(Object element) {
		
		// We need to adjust the size
		if ( current_size == SIZE_LIMIT ) {
			SIZE_LIMIT *= 2;
			Object newArr[] = new Object[SIZE_LIMIT];
			for ( int i = 0; i < current_size; i++ ) {
				newArr[i] = container[i];
			}
			container = newArr;
		}
		
		// Add the element to the array
		container[current_size++] = element;
		return true;
	}
	
	private static int SIZE_LIMIT = 3;
	private int current_size = 0;
	Object container[] = new Object[SIZE_LIMIT];
}