import java.util.Random;


public class Random_Sorter implements Sorter {

	private Random randomGenerator;
	char [] nums; 
	int n;
	
	@Override
	public void sort(char[] n) {
		randomGenerator = new Random();
		nums = n;
		this.n = n.length;
		
		while ( !isSorted())
		{
			randomSwap ();
		}
	}
	
	private void randomSwap() {
		swap(randomGenerator.nextInt(n),randomGenerator.nextInt(n));
	}
	
	private void swap(int a, int b ) {
		char c = nums[a];
		nums[a] = nums[b];
		nums[b] = c;
	}
	
	private boolean isSorted ( ) {
		for ( int i = 1; i < nums.length; i++) {
			if ( nums[i] < nums[i-1] ) return false;
		}
		return true;
	}

}
