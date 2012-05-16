package src;

public class SimpleStudent extends AbstractStudent {

	public SimpleStudent(String name, int age, String studyProgram, String imgPath) {
		
		// Have to have this constructor, unless there's an empty constructor in Student
		super(name, age, studyProgram, imgPath);
	}

	public String createDescriptionString() {
		String str = "NON-ACTIVE Student, " + descriptionString;

		return str;
	}
}