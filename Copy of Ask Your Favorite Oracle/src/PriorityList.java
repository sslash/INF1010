public class PriorityList {

	private ListNode head, tail;
	private int size;

	
	/**
	 * Initialize the list
	 */
	public PriorityList() {

		/* Set empty list pointers */
		head = new ListNode(null);
		tail = new ListNode(null);
		head.setNext(tail);					// head -> tail		
		tail.setPrevious(head);				// head <- tail
		
		size = 0;
	}
	
	
	/**
	 * Returns the first element in the list,
	 * making the list a priority list
	 */
	public IfiPerson get() {
		// TODO: Implement this function
		return null;
	}
	

	/**
	 * Insert in sorted order, biggest element first
	 * @param p the new element to insert
	 */
	public void add(IfiPerson p) {
		// TODO: Implement this function
	}
	
	

	
	
	/****************************************************
	 * 				Helper functions					*
	 ****************************************************/

	/**
	 * Helper function, so you can iterate through the priority list
	 *  
	 * @return an array of the list elements
	 */
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


	/**
	 * helper function to find the student with the lowest priority
	 * 
	 * @return
	 */
	public IfiPerson getNodeWithLowestBaseProperty() {
		if ( head == tail) return null;
		
		ListNode tmp = head.getNext();
		IfiPerson highest = tmp.getMe();
		
		while ( tmp != tail ) {
			if ( tmp.getMe().getBasePriority() < highest.getBasePriority() )
				highest = tmp.getMe();
			tmp = tmp.getNext();
		}
		
		return highest;
	}
	
	
}
