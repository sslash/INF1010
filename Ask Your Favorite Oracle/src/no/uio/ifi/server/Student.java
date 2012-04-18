package no.uio.ifi.server;

public class Student implements IfiPerson {

	private String 	name;
	private int		basePriority;
	private int		skillLevel;
	
	
	/**
	 * 
	 * A students priority is defined by the sum of the basePriority
	 * and skillLevel
	 * 
	 * @return this students priority
	 */
	public int getPriority() {
		return basePriority + skillLevel;
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setSkillLevel(int skillLevel) {
		this.skillLevel = skillLevel;
		
	}
	
	
	public Student( String name, int basePriority, int skillLevel ) {
		this.name = name;
		this.basePriority = basePriority;
		this.skillLevel = skillLevel;
	}
	
	
	
	public Student(String username) {
		this.name = username;
	}

	
	@Override
	/**
	 * If other is a Student, compare this objects' priority with others' priority.
	 * Priority is defined by the sum of basePriority and skillLevel.
	 * I.e the result from the function getPriority().
	 * 
	 * Else, compare this objects' skillLevel with others' skill level.
	 *
	 */
	public int compareTo(IfiPerson other) {
		if ( other instanceof Student)
			return this.getPriority() - ((Student)other).getPriority();
		else
			return skillLevel - other.getSkillLevel();
	}

	@Override
	public int getBasePriority() {
		return basePriority;
	}

	@Override
	public int getSkillLevel() {
		return skillLevel;
	}

	@Override
	public String myStringRep() {
		return name + " [" + skillLevel + "s," + basePriority + "p]";
		
	}

	@Override
	public void setBasePriority(int basePriority) {
		this.basePriority = basePriority;	
	}

}
