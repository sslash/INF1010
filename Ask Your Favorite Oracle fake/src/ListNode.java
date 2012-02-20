
public class ListNode {
	
	/* Pointer to the list element */
	private IfiPerson me;
	
	/* Pointer to the next element in the list */
	private ListNode next;
	
	/* Pointer to the last element in the list */
	private ListNode previous;
	
	
	public ListNode(IfiPerson me) {
		this.me = me;
	}
	
	
	
	
	/****************************************************
	 * 				Getters and setters					*
	 ****************************************************/
	public ListNode getPrevious() {
		return previous;
	}

	public void setPrevious(ListNode previous) {
		this.previous = previous;
	}

	
	
	public IfiPerson getMe() {
		return me;
	}


	public void setMe(Student me) {
		this.me = me;
	}




	public ListNode getNext() {
		return next;
	}




	public void setNext(ListNode next) {
		this.next = next;
	}




	
}
