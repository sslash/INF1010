
public class Student implements IfiPerson {

	private String 	name;
	private int		basePriority;
	private int		skillLevel;
	
	
	public int getPriority() {
		return basePriority + skillLevel;
	}
	
	public String getName() {
		// TODO: Implement this function
		return null;
	}
	
	public void setSkillLevel(int skillLevel) {
		// TODO: Implement this function		
	}
	
	
	public Student( String name, int basePriority, int skillLevel ) {
		this.name = name;
		this.basePriority = basePriority;
		this.skillLevel = skillLevel;
	}
	
	
	
	@Override
	/**
	 * If other is a student, compare priority,
	 * else, compare skill level
	 *
	 */
	public int compareTo(IfiPerson other) {
		// TODO: Implement this function
		// hint: us if (other instance of student) to check if other is a student 
		return 0;
	}

	@Override
	public int getBasePriority() {
		// TODO: Implement this function
		return 0;
	}

	@Override
	public int getSkillLevel() {
		// TODO: Implement this function
		return 0;
	}

	@Override
	public String myStringRep() {
		return name + " [" + skillLevel + "s," + basePriority + "p]";
		
	}

	@Override
	public void setBasePriority(int basePriority) {
		// TODO: Implement this function	
	}

}
