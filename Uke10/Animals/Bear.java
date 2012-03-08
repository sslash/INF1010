
public class Bear extends Animal implements ICarnivore {
	int creaturesKilled = 0;
	private int attack = 0;
	public Bear(String name, int attack){
		super(name);
		this.attack = attack;
	}
	
	public boolean eatFish(){
		return true;
	}

	public void attackCreature(IHerbivore h){
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
