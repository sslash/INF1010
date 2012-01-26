public class Kurs{

	final int MAX_STUDS = 4;
	int arrayCount = 0;
	Student[] studs;
	
	Kurs(){
		studs = new Student[MAX_STUDS];
	}
	public void insertStudent(Student s){
		if(arrayCount >= MAX_STUDS)
			System.out.println(“The course is full. Try again next semester”);
		else{
			studs[arrayCount] = s;
			arrayCount++;
			System.out.println(“Successfull! Remember to show up at the first lecture”);
		}
	}
}