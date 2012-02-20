public class IfiPriorityList implements PriorityList {

	private ListNode head, tail;
	private int size;

	
	/**
	 * Initialize the list
	 */
	public IfiPriorityList() {

		/* Set empty list pointers */
		head = new ListNode(null);
		tail = new ListNode(null);
		head.setNext(tail);					// head -> tail		
		tail.setPrevious(head);				// head <- tail
		
		size = 0;
	}
	
	@Override
	public IfiPerson getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public IfiPerson get() {
		// TODO: Implement this function
		return null;
	}
	

	public void add(IfiPerson p) {
		// TODO: Implement this function
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
