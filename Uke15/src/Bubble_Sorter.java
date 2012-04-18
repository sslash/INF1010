
public class Bubble_Sorter implements Sorter {

	@Override
	public void sort(char [] nums) {
		boolean swapped;
		do {
			swapped = false;
			for ( int i = 1; i < nums.length; i++ ) {
				if ( nums[i-1] > nums[i] ) {
					swap ( nums, i-1, i);
					swapped = true;
				}
			}
		}while (swapped);
	}
	
	private void swap(char [] nums, int a, int b ) {
		char c = nums[a];
		nums [a] = nums[b];
		nums[b] = c;		
	}

}
