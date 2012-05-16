package src;

import java.util.ArrayList;

public abstract class AbstractStudent {

	private String name;

	private int age;

	private String studyProgram;

	private String imgPath;

	// String that describes the student. Used in the GUI.
	// Not a particular nice feature, but shows use of subclassing
	protected String descriptionString;

	private EscapeCollection <String> songs;

	public AbstractStudent(String name, int age, String studyProgram, String imgPath) {
		this.name = name;
		this.age = age;
		this.studyProgram = studyProgram;
		this.imgPath = imgPath;
		descriptionString = "name: " + name + ", age: " + age +
										", study program: " + studyProgram;
	}

	public void setSongs(EscapeCollection <String> e ) {
		this.songs = e;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getImgPath() {
		return imgPath;
	}

	public String getStudyProgram() {
		return studyProgram;
	}

	public ArrayList<String> getSongs() {
		return songs.toArrList();
	}

	public abstract String createDescriptionString();

}