import java.util.Random;

import edu.uwm.cs351.Sorter;
import junit.framework.TestCase;


public class TestEfficiency extends TestCase {
	
	private static final int POWER = 20;
	private static final int BIG = (1<<POWER);
	private static final int RANDOM_MAX = 1<<(POWER-2); // will have duplicates!
	private static final int TRIALS = 5;

	private Sorter sorter;
	private Random r = new Random();
	

	public void setUp() {
		try {
			assert false;
			assertTrue(true);
		} catch (AssertionError ex) {
			System.out.println("Assertions enabled. Turn them off for efficiency tests efficiency tests only.");
			System.out.println("  (To run other tests, add -ea to VM Args Pane in Arguments tab of Run Configuration)");
			assertTrue(false);
		}
		sorter = new Sorter();		
	}
	
	public int[] setupArr(int size) {
		int[] retArr = new int[size];
		for(int i = 0; i < size; ++i) {
			retArr[i] = r.nextInt(RANDOM_MAX);
		}
		return retArr;
	}
	
	private void testIsSorted(int[] arr){
		boolean first = true;
		int prev, curr = 0;
		for(int num:arr){
			prev = curr;
			curr = num;
			if(!first) {
				boolean condition = prev <= curr;
				if (!condition) {
					assertTrue(prev + " should precede " + curr, condition);
				}
			} else first = false;
		}
	}
	
	
	public void testSort(){
		int unsorted[];
		int sorted[] = null;
		long timeElapsed;
		
		for (int p=0; p < 21; ++p) {
			int size = 1 << p;
			unsorted = setupArr(size);
			long startTime = System.currentTimeMillis();
			
			sorted = sorter.mergeSort(unsorted);
			/*
			 * Comment out the line above and uncomment the line below to see
			 * insertion sort for comparison.
			 */
			//sorted = sorter.insertionSort(unsorted);
			
			timeElapsed = System.currentTimeMillis() - startTime;
			System.out.println("Time to sort 2^" + p + " elements = " + timeElapsed);
			assertTrue(timeElapsed < 1000); //Comment out this line when testing insertion sort!
		}
		
		for(int i = 0; i < TRIALS; ++i){
			assertTrue("MergeSort does not return an array.", sorted != null);
			unsorted = setupArr(sorted.length);
			
			long startTime = System.currentTimeMillis();
			assertEquals(BIG,unsorted.length);
			
			sorted = sorter.mergeSort(unsorted);
			/*
			 * Comment out the line above and uncomment the line below to see
			 * insertion sort for comparison.
			 */
			//sorted = sorter.insertionSort(unsorted);
			
			testIsSorted(sorted);
			timeElapsed = System.currentTimeMillis() - startTime;
			System.out.println("Time to sort and check 2^" + POWER + " elements = " + timeElapsed);
			assertTrue(timeElapsed < 1000); //Comment out this line when testing insertion sort!
		}
	}
	
}
	