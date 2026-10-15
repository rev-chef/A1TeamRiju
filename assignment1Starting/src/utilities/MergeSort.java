package utilities;

import java.util.Comparator;

/**
 * MergeSort implementation that sorts in DESCENDING order.
 * Uses divide and conquer: split array in half, sort each half, merge them.
 */
public class MergeSort {

	/**
	 * Sorts using Comparable (for -td: calcRealDiff comparison).
	 * @param arr array of Comparable objects to sort in descending order
	 */
	public static void sort(Comparable[] arr) {
		mergeSort(arr, 0, arr.length - 1, null);
	}

	/**
	 * Sorts using a Comparator (for -to: original price, -tu: updated price).
	 * @param arr array of Comparable objects to sort in descending order
	 * @param comparator the Comparator to use for comparing objects
	 */
	public static void sort(Comparable[] arr, Comparator comparator) {
		mergeSort(arr, 0, arr.length - 1, comparator);
	}

	/**
	 * Recursive merge sort.
	 * Divides the array in half until single elements, then merges back.
	 */
	private static void mergeSort(Comparable[] arr, int left, int right, Comparator comparator) {
		if (left < right) {
			int mid = (left + right) / 2;

			// Sort left half
			mergeSort(arr, left, mid, comparator);

			// Sort right half
			mergeSort(arr, mid + 1, right, comparator);

			// Merge both halves
			merge(arr, left, mid, right, comparator);
		}
	}

	/**
	 * Merges two sorted halves into one sorted section in DESCENDING order.
	 * Left half: arr[left..mid], Right half: arr[mid+1..right]
	 */
	private static void merge(Comparable[] arr, int left, int mid, int right, Comparator comparator) {
		// Size of the two sub-arrays
		int n1 = mid - left + 1;
		int n2 = right - mid;

		// Temp arrays
		Comparable[] leftArr = new Comparable[n1];
		Comparable[] rightArr = new Comparable[n2];

		// Copy data into temp arrays
		for (int i = 0; i < n1; i++) {
			leftArr[i] = arr[left + i];
		}
		for (int j = 0; j < n2; j++) {
			rightArr[j] = arr[mid + 1 + j];
		}

		// Merge back into arr[] in DESCENDING order
		int i = 0; // index for left array
		int j = 0; // index for right array
		int k = left; // index for merged array

		while (i < n1 && j < n2) {
			int compareResult;

			if (comparator != null) {
				compareResult = comparator.compare(leftArr[i], rightArr[j]);
			} else {
				compareResult = leftArr[i].compareTo(rightArr[j]);
			}

			// DESCENDING: put the LARGER element first
			// compareResult >= 0 means leftArr[i] >= rightArr[j]
			if (compareResult >= 0) {
				arr[k] = leftArr[i];
				i++;
			} else {
				arr[k] = rightArr[j];
				j++;
			}
			k++;
		}

		// Copy remaining elements of leftArr
		while (i < n1) {
			arr[k] = leftArr[i];
			i++;
			k++;
		}

		// Copy remaining elements of rightArr
		while (j < n2) {
			arr[k] = rightArr[j];
			j++;
			k++;
		}
	}
}
