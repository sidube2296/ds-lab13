import edu.uwm.cs351.Sorter;
import junit.framework.TestCase;
import java.util.Arrays;

public class TestMergeSort extends TestCase {
	
	private Sorter sorter;
	private int[] a, b, c, d, e, f;
	
	public void setUp() {
		sorter = new Sorter();
		
		a = null;
		b = new int[] {0};
		c = new int[] {1, 2, 3, 4};
		d = new int[] {8, 7, 6, 5};
		e = new int[] {5, 3, 4, 1, 8, 7, 2, 6};
		f = new int[] {10, 5, 3, 2, 1, 4, 7, 8, 6, 9};
	}
	
	public void testA(){
		int[] aRet = sorter.mergeSort(a);
		assertNull(aRet);
	}
	
	public void testB() {
		int[] bRet = sorter.mergeSort(b.clone());
		assertTrue(Arrays.equals(bRet, b));
	}
	
	public void testC() {
		int[] cRet = sorter.mergeSort(c.clone());
		assertTrue(Arrays.equals(cRet, c));
	}
	
	public void testD() {
		int[] dSort = sorter.mergeSort(d.clone());
		int[] d_ins = sorter.insertionSort(d.clone());
		assertTrue(Arrays.equals(dSort, d_ins));
	}
	
	public void testE() {
		int[] dSort = sorter.mergeSort(d.clone());
		int[] d_ins = sorter.insertionSort(d.clone());
		assertTrue(Arrays.equals(dSort,d_ins));
		
		int[] eSort = sorter.mergeSort(e.clone());
		int[] e_ins = sorter.insertionSort(e.clone());
		assertTrue(Arrays.equals(eSort,e_ins));
		
		int[] cd = sorter.merge(c, dSort);
		assertTrue(Arrays.equals(cd, eSort));
	}
	
	public void testF() {
		int[] fSort = sorter.mergeSort(f.clone());
		int[] f_ins = sorter.insertionSort(f.clone());
		assertTrue(Arrays.equals(fSort,f_ins));
	}
}
	