package no.uio.ifi.server;

import java.io.Serializable;

public interface IfiPerson {

	String getName();
	
	int compareTo(IfiPerson other);
	
	int getBasePriority();
	
	int getSkillLevel();
	
	String myStringRep();
	
	void setSkillLevel(int skill);
	
	void setBasePriority(int basePriority);	
}
