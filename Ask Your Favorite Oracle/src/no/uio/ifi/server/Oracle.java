package no.uio.ifi.server;


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
		myHelpList.add(person);
		printMyStudentList();
	}
	
	
	public void printMyStudentList() {
		IfiPerson [] studentArr = myHelpList.toArray();
		
		System.out.print(myStringRep() + "\t");
		for ( IfiPerson person : studentArr ) {
			System.out.print( person.myStringRep() + "\t");
		}
		
		System.out.println();
	}



	public IfiPerson getNextStudentToHelp() {
		IfiPerson toHelp = myHelpList.get();
		printMyStudentList();
		return toHelp;
	}



	@Override
	public String getName() {
		return name;
	}



	@Override
	public int compareTo(IfiPerson other) {
		return this.skillLevel - other.getSkillLevel();
	}



	public IfiPerson getStudentWithLowestPriority() {
		return myHelpList.getNodeWithLowestBaseProperty();
	}



	@Override
	public int getBasePriority() {		
		return skillLevel;
	}



	@Override
	public int getSkillLevel() {
		return skillLevel;
	}



	@Override
	public String myStringRep() {
		return name + "\t[" + skillLevel+ "] {Oracle}: "; 
		
	}


	@Override
	public void setSkillLevel(int skill) {
		skillLevel = skill;		
	}



	@Override
	public void setBasePriority(int basePriority) {
		throw new UnsupportedOperationException("Oracles does not have a base priority");	
	}
}
