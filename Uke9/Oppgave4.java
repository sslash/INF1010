import java.util.Iterator;
import java.util.NoSuchElementException;


public class Oppgave4 {

	public Oppgave4(){
		MyIterablePizzaContainer <NyPizza>nyPizzas = new MyIterablePizzaContainer<NyPizza>();
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
		
		
		for (NyPizza p : nyPizzas){
			System.out.println(p);
		}
		
		Iterator <NyPizza> it = nyPizzas.iterator();
		
		while ( it.hasNext() ){
			NyPizza p = it.next();
			System.out.println(p);
		}
		
	}
	
}


class MyIterablePizzaContainer <E> implements SimpleGenericPizzaContainer<E>, Iterable<E>{
	int maxsize = 10;
	int next = 0;
	
	@SuppressWarnings("unchecked")
	E [] arr = (E[]) new Object[maxsize];
	
	@Override
	public int size() {
		return next;
	}

	@Override
	public E get(int index) {
		if (index >= next) return null;
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
	
	public Iterator<E> iterator(){
		return new PizzaIterator<E>(this);
	}
}

class PizzaIterator<E> implements Iterator<E>{
	int current = 0;
	MyIterablePizzaContainer <E> container;
	
	public PizzaIterator (MyIterablePizzaContainer <E> container){
		this.container = container;
	}

	@Override
	public boolean hasNext() {
		return current < container.size();
	}

	@Override
	public E next() {
		if (!hasNext()) throw new NoSuchElementException();
		
		return container.arr[current++];
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();			
	}		
}
