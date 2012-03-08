
public abstract class Carnivore extends Animal {
	private int creaturesKilled = 0;
	private int attack = 0;
	
	public Carnivore(String name, int attack) {
		super(name);
		this.attack = attack;
	}
	
	public void attackCreature(Herbivore h){
		boolean killed = h.tryToKill(this);
		if(killed) creaturesKilled++;
		System.out.println("Success: " + killed);
	}
	
	public int getCreaturesKilled() {
		return creaturesKilled;
	}
	
	public int getAttack() {
		return attack;
	}
	
	public void setAttack(int attack) {
		this.attack = attack;
	}

}
