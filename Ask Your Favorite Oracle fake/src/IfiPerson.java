
public interface IfiPerson {

	String getName();
	
	int compareMeTo(IfiPerson other);
	
	int getBasePriority();
	
	int getSkillLevel();
	
	String myStringRep();
	
	void setSkillLevel(int skill);
	
	void setBasePriority(int basePriority);	
}
