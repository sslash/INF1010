
public abstract class Herbivore extends Animal {
	private boolean alive = true;
	private int defense = 0;
	
	public Herbivore(String name, int defense) {
		super(name);
		this.defense = defense;
	}

	public boolean tryToKill(Carnivore c){
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
