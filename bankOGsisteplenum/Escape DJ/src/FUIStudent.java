package src;

public class FUIStudent extends AbstractStudent{

	private String studentResponsibility;

	public FUIStudent(String name, int age, String studyProgram, 
						String imgPath, String studentResponsibility) {
		
		// Have to have this constructor, unless there's an empty constructor in Student
		super(name, age, studyProgram, imgPath);
		this.studentResponsibility = studentResponsibility;
	}

	public String getStudentResponsibility() {
		return studentResponsibility;
	}

	public String createDescriptionString() {
		String str = "FUI member, " + descriptionString + 
					", student responsibility: " + studentResponsibility;

		return str;
	}

}