
public class Deer extends Animal implements IHerbivore {
	private int defense = 0;
	boolean alive = true;
	
	public Deer(String name, int defense) {
		super(name);
		this.defense = defense;
	}

	public boolean tryToKill(ICarnivore c){
		if(c.getAttack() > defense){
			alive = false;
			return true;
		}
		return false;
	}

	public boolean isAlive() {
		return alive;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

}
