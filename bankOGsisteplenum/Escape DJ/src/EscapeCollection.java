package src;

import java.util.ArrayList;
import java.util.Iterator;
import java.lang.Iterable;


public interface EscapeCollection <E> extends Iterable <E>{
	public void add(E e);
	
	public int size();

	public Iterator <E> iterator();

	public ArrayList<E> toArrList();
}