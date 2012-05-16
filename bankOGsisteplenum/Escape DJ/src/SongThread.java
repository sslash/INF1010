package src;

import java.util.ArrayList;

public class SongThread extends Thread {
	Monitor<String> mon;
	AbstractStudent stud;
	
	public SongThread(AbstractStudent s, Monitor<String> mon){
		stud = s;
		this.mon = mon;
	}
	
	public void run(){
		ArrayList<String> list = stud.getSongs();
		mon.addSongs(list);
		
	}
}
