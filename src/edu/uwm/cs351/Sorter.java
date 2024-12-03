package edu.uwm.cs351;

public class Sorter {
	
	/**
	 * Takes an array and sorts it in O(nlogn) time. Should return null if input 
	 * is null.
	 * @param input An array of at least 1 element, that may or may not be sorted.
	 * @return A sorted version of the input array (should return a "new" array).
	 */
	public int[] mergeSort(int[] input) {
		//TODO: Implement this method.
		// Be aware that "merge" is already supplied for you!
	}
	
	
	/**
	 * Takes two arrays and combines them into one sorted array.
	 * It is assumed that both input arrays are already sorted, and may not
	 * work as intended otherwise.
	 * @param arr1 The first of the two sorted arrays to merge.
	 * @param arr2 The second of the two sorted arrays to merge.
	 * @return One sorted array, which contains all the elements from arr1 and arr2
	 * in order.
	 */
	public int[] merge(int[] arr1, int[] arr2) {
		int len1 = arr1.length;
		int len2 = arr2.length;
		int [] output = new int[len1 + len2];
		
		int arr1_pos = 0;
		int arr2_pos = 0;
		for( int outPos = 0; outPos < output.length; outPos++) {
			if(arr1_pos >= len1) {
				output[outPos] = arr2[arr2_pos];
				arr2_pos++;
			}
			else if(arr2_pos >= len2) {
				output[outPos] = arr1[arr1_pos];
				arr1_pos++;
			}
			else {
				if(arr1[arr1_pos] <= arr2[arr2_pos]) {
					output[outPos] = arr1[arr1_pos];
					arr1_pos++;
				}
				else {
					output[outPos] = arr2[arr2_pos];
					arr2_pos++;
				}
			}
		}
		
		return output;
	}
	
	/**
	 * Sorts the given array in O(n^2) time. This method is provided
	 * for you so it can be compared to your merge-sort.
	 * @param input Array to sort
	 * @return Sorted version of that array
	 */
	public int[] insertionSort(int[] input) {
		if(input == null) return null;
		
		int tmp;
		
		for(int i = 0; i < input.length; i++) {
			
			for(int j = i; j < input.length; j++) {
				if(input[j] < input[i]) {
					tmp = input[i];
					input[i] = input[j];
					input[j] = tmp;
				}
			}
			
		}
		
		return input;
	}
}
