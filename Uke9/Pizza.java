import java.util.Arrays;

public class Pizza implements Comparable<Pizza> {
	String name;
	String dough;
	String sauce;
	int rate;
	
	@Override
	public String toString() {
		return "Pizza [name=" + name + ", dough=" + dough + ", sauce=" + sauce
				+ ", rate=" + rate + ", toppings=" + Arrays.toString(toppings)
				+ "]";
	}

	String[] toppings;

	public int compareTo(Pizza p){
		return rate - p.getRate();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDough() {
		return dough;
	}

	public void setDough(String dough) {
		this.dough = dough;
	}

	public String getSauce() {
		return sauce;
	}

	public void setSauce(String sauce) {
		this.sauce = sauce;
	}

	public String[] getToppings() {
		return toppings;
	}

	public int getRate(){
		return rate;
	}
	
	public void setToppings(String[] toppings) {
		this.toppings = toppings;
	}
}
