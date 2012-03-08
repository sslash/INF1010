
public class InTheWild {

	public static void main(String [] args){
		ICarnivore c = new Bear("Bob", 10);
		IHerbivore h = new Deer("Daniel", 8);
		
		c.attackCreature(h);
		System.out.println(h.isAlive());
		
		
		
	}
}
