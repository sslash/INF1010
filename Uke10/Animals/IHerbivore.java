
public interface IHerbivore {
	public boolean tryToKill(ICarnivore c);
	public boolean isAlive();
	public int getDefense();
	public void setDefense(int defense);
	
}
