package src;

public class InternStudent extends AbstractStudent {

	private String group;


	public InternStudent(String name, int age, String studyProgram,
							String imgPath, String group) {
		
		// Have to have this constructor, unless there's an empty constructor in Student
		super(name, age, studyProgram, imgPath);
		this.group = group;
	}

	public String getGroup() {
		return group;
	}

	public String createDescriptionString() {
		String str = "CYB Intern, " + descriptionString + ", Group: " + group;

		return str;
	}
}