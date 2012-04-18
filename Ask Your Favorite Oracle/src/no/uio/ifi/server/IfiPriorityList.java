package no.uio.ifi.server;

import java.util.Iterator;

public class IfiPriorityList implements PriorityList {

	private ListNode head, tail;
	private int size;

	public IfiPriorityList() {

		/* Set empty list pointers */
		head = new ListNode(null);
		tail = new ListNode(null);
		head.setNext(tail);					// head -> tail		
		tail.setPrevious(head);				// head <- tail
		
		size = 0;
	}
	
	
	
	public IfiPerson get() {
		
		// check if list is empty
		if ( head.getNext() == tail ) return null;
		
		ListNode toReturn = head.getNext(); 	// head -> toReturn -> x
		head.setNext(toReturn.getNext());		// head -> x
		head.getNext().setPrevious(head);		// head <- x
		
		size --;
		
		return toReturn.getMe();
	}
	

	/**
	 * Insert in sorted order
	 * @param p the new element to insert
	 */
	public void add(IfiPerson p) {							
		ListNode smaller = findTheNodeThatIsSmaller(p);	 
		insertBefore(new ListNode(p), smaller);
		
		size ++;
	}
	
	
	public IfiPerson getByName(String name) {
		ListNode tmp = head.getNext();
		
		while ( tmp != tail ) {
			if( tmp.getMe().getName().equals(name) ) 
				return tmp.getMe();
			
			tmp = tmp.getNext();
		}
		
		return null;
	}
	
	
	private ListNode findTheNodeThatIsSmaller(IfiPerson p) {
		ListNode tmp = head.getNext();
		while (tmp != tail && tmp.getMe().compareTo(p) > 0) {
			tmp = tmp.getNext();
		}

		return tmp;
	}
	

	private void insertBefore(ListNode newNode, ListNode small) {
		// Set the new person's pointers				// bigger -> <- smaller
		newNode.setNext(small);						    // newNode -> smaller
		newNode.setPrevious(small.getPrevious());		// bigger <- newNode 

		// Set the previous' next pointer
		ListNode bigger = newNode.getPrevious();		// 
		bigger.setNext(newNode);						// bigger -> newNode 

		// Set the bigger nodes' previous pointer
		small.setPrevious(newNode);					// newNode <- smaller
	}


	public IfiPerson [] toArray() {
		ListNode tmp = head.getNext();
		IfiPerson [] studentArr = new IfiPerson[size];
		
		int i = 0;
		while ( tmp != tail ) {
			studentArr[i++] = tmp.getMe();
			tmp = tmp.getNext();
		}
		
		return studentArr;
	}


	public IfiPerson getNodeWithLowestBaseProperty() {
		if ( head == tail) return null;
		return tail.getPrevious().getMe();
		/*
		ListNode tmp = head.getNext();
		IfiPerson highest = tmp.getMe();
		
		while ( tmp != tail ) {
			if ( tmp.getMe().getBasePriority() < highest.getBasePriority() )
				highest = tmp.getMe();
			tmp = tmp.getNext();
		}
		
		return highest;
		*/
	}
	
	
	class MyIterable implements Iterable {

		@Override
		public Iterator iterator() {
			return new MyIterator();
		}
		
	}
	
	class MyIterator implements Iterator {

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Object next() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
}
