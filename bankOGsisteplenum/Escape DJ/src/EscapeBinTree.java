package src;

import java.util.ArrayList;
import java.util.Iterator;

public class EscapeBinTree<E extends Comparable<E>> implements EscapeCollection<E> {
	TreeNode root = null;
	int size = 0;
	ArrayList<E> list = null;
	
	class TreeNode{
		E data;
		TreeNode left;
		TreeNode right;
		
		TreeNode(E e){
			data = e;
		}
		
		public void add(E e){
			int check = e.compareTo(data);
			if(check < 0){
				if(left != null) left.add(e);
				else{ 
					left = new TreeNode(e);
					size++;
				}
			}else if(check > 0){
				if(right != null) right.add(e);
				else{ 
					right = new TreeNode(e);
					size++;
				}
			}else
				return;
		}
		
		public void toArrList(){
			if(left != null) left.toArrList();
			list.add(data);
			if(right != null) right.toArrList();
		}
		
	}
	
	public void add(E e){
		if(root == null) 
			root = new TreeNode(e);
		else
			root.add(e);
	}
	
	public int size(){
		return size;
	}
	
	public ArrayList<E> toArrList(){
		list = new ArrayList<E>();
		if(root == null) return null;
		else root.toArrList();
		return list;
	}
	
	public Iterator<E> iterator(){
		return null;
	}

}
