import javax.swing.text.MaskFormatter;


public class Oppgave2 {

	public Oppgave2() {
		//testAddChicagoPizza();
		//testAddNyPizza();
		testComparablePizzas();
	}
	
	private void testAddNyPizza() {
		MyGenericPizzaContainer <NyPizza>nyPizzas = new MyGenericPizzaContainer<NyPizza>();
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
		
		for (int i = 0; i < nyPizzas.size(); i ++ ){
			System.out.println(nyPizzas.get(i));
		}
	}

	private void testAddChicagoPizza() {
		MyGenericPizzaContainer <ChicagoPizza>chicagoPizzas = new MyGenericPizzaContainer<ChicagoPizza>();
		
		chicagoPizzas.add(new ChicagoPizza("Chicago special", 
				"Tomato", new String[] { "Greeb peppers", "Mushrooms" }, 8));
		
		chicagoPizzas.add(new ChicagoPizza("Chicago supreme",
				"Tomato garcic", new String[] { "Onion", "Chicken", "Bacon" }, 10));
		
		chicagoPizzas.add(new ChicagoPizza("Chicago veggie", "Tomato",
				new String[] { "green peppers", "Mushrooms" }, 20));

		ChicagoPizza special = (ChicagoPizza) chicagoPizzas.get(0);
		ChicagoPizza supreme = (ChicagoPizza) chicagoPizzas.get(1);
		ChicagoPizza veggie = (ChicagoPizza) chicagoPizzas.get(2);
	}
	
	void testComparablePizzas() {
		Pizza veggie = new NyPizza("Veggie", "Thin", "Tomato", new String[] {
		"Onion", "Squash" }, 10);

		Pizza bbq = new NyPizza("Barbique", "Thick", "Tomato", new String[] {
		"Onion", "Chicken" }, 13);

		Pizza shrimp = new NyPizza("Shrimp", "Thin", "Tomato garlic",
		new String[] { "Shrimps", "Capers" }, 13);

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
		System.out.println("Alt gikk strålende");
		}


}

/**
 * Keeps a growable array of Objects
 * 
 * @author michael gunnulfsen
 * 
 */
interface SimpleGenericPizzaContainer <E> {
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
	public E get(int index);

	/**
	 * Add the object to the end of the array. Should extend the size of the
	 * array if the array is full.
	 * 
	 * @return true (as per java.util.ArrayList)
	 */
	public boolean add(E element);
}

class MyGenericPizzaContainer <E> implements SimpleGenericPizzaContainer<E>{
	int maxsize = 10;
	int next = 0;
	
	@SuppressWarnings("unchecked")
	E [] arr = (E[]) new Object[maxsize];
	
	@Override
	public int size() {
		return index;
	}

	@Override
	public E get(int index) {
		if ( index >= next ) return null;
		return arr[index];
	}

	@Override
	public boolean add(E element) {
		if ( size() == maxsize){
			maxsize *= 2;
			E[] arrtmp = (E[]) new Object[maxsize];
			
			for ( int i = 0; i < arr.length; i++ ){
				arrtmp[i] = arr[i];
			}
			arr = arrtmp;
		}
		arr[next++] = element;
		return true;
	}
	
}