package src;

import java.util.ArrayList;
import java.util.Iterator;

public class SimpleLinkedList <E> implements EscapeCollection <E>{

	// These are Node pointers that has no data,
	// just for the purpose of having a nice list implementation
	private Node first;
	private Node last;

	public SimpleLinkedList() {
		first = new Node(null);
		last = new Node(null);

		first.setNext(last);
		last.setPrevious(first);
	}

	public void add(E e) {

		// Create a new wrapper (Node) for e
		Node newNode = new Node(e);
			
			newNode.setNext( first.getNext() );	// newNode -> OldFirstNode
			newNode.setPrevious(first); // first <- newNode
			newNode.getNext().setPrevious(newNode); // newNode <- OldFirstNode
			first.setNext(newNode);	// first -> newNode
	}

	public Iterator <E> iterator() {
		return new ListIterator ();
	}

	private class ListIterator implements Iterator<E> {

		private Node current;

		public ListIterator() {
			current = first.getNext();
		}

		public boolean hasNext() {
			return current != last;
		}

		public E next() {
			E toRet = current.getData();
			current = current.getNext();
			return toRet;
		}

		public void remove() {
			// throw new unimplemented exception
		}
	}

	private class Node {
		E data;
		Node next = null;
		Node previous = null;

		public Node (E data ) {
			this.data = data;
		}

		private E getData() {
			return data;
		}

		public Node getNext() {
			return next;
		}

		public Node getPrevious() {
			return previous;
		}

		public void setPrevious( Node previousNode) {
			previous = previousNode;
		}

		public void setNext( Node nextNode ) {
			next = nextNode;
		}
	}

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<E> toArrList() {
		// TODO Auto-generated method stub
		return null;
	}
}