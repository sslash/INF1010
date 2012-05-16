package src;

import java.util.ArrayList;

public class Monitor<E> {
	ArrayList<E> list;
	
	public Monitor(){
		list = new ArrayList<E>();
	}
	
	public synchronized void addSongs(ArrayList<E> songs){
		list.addAll(songs);
	}
	
	public ArrayList<E> getList(){
		return list;
	}
}
