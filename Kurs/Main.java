public class Main{
	public static void main(String[] args){
		Kurs k = new Kurs();
		k.insertStudent(new Student(“Erik”));
		k.insertStudent(new Student(“Magnús”));
		k.insertStudent(new Student(“Arash”));
		k.insertStudent(new Student(“Michael”));
		k.insertStudent(new Student(“Stein”));
	}
}