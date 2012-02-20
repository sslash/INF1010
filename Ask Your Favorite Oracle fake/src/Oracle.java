

public class Oracle implements IfiPerson {

	private String name;
	
	private int skillLevel;
	
	
	private IfiPriorityList myHelpList;
	
	
	public Oracle(String name, int skillLevel) {
		myHelpList = new IfiPriorityList();
		this.name = name;
		this.skillLevel = skillLevel;
	}
	
	
	
	public void addStudentToHelpList(IfiPerson person) {
		// TODO: Implement this function
		printMyStudentList();
	}


	public IfiPerson getNextStudentToHelp() {
		// TODO: Implement this function
		printMyStudentList();
		return null;
	}

	
	private void printMyStudentList() {
		IfiPerson [] studentArr = myHelpList.toArray();
		
		System.out.print(myStringRep() + "\t");
		for ( IfiPerson person : studentArr ) {
			System.out.print( person.myStringRep() + "\t");
		}
		
		System.out.println();
	}
	

	@Override
	public String getName() {
		// TODO: Implement this function
		return null;
	}



	@Override
	/**
	 * Compare the skill level
	 */
	public int compareMeTo(IfiPerson other) {
		// TODO: Implement this function
		return 0;
	}



	public IfiPerson getStudentWithLowestPriority() {
		// TODO: Implement this function
		return null;
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
		return name + "\t[" + skillLevel+ "] {Oracle}: "; 
		
	}



	@Override
	public void setSkillLevel(int skill) {
		// TODO: Implement this function
	}



	@Override
	public void setBasePriority(int basePriority) {
		throw new UnsupportedOperationException("Oracles does not have a base priority");	
	}
}
