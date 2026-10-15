package utilities;

import java.util.Comparator;

/**
 * QuickSort implementation that sorts in DESCENDING order.
 * Uses the Median-of-3 approach for pivot selection.
 */
public class QuickSort {

	/**
	 * Sorts using Comparable (for -td: calcRealDiff comparison).
	 * @param arr array of Comparable objects to sort in descending order
	 */
	public static void sort(Comparable[] arr) {
		quickSort(arr, 0, arr.length - 1, null);
	}

	/**
	 * Sorts using a Comparator (for -to: original price, -tu: updated price).
	 * @param arr array of Comparable objects to sort in descending order
	 * @param comparator the Comparator to use for comparing objects
	 */
	public static void sort(Comparable[] arr, Comparator comparator) {
		quickSort(arr, 0, arr.length - 1, comparator);
	}

	/**
	 * Recursive quick sort.
	 */
	private static void quickSort(Comparable[] arr, int low, int high, Comparator comparator) {
		if (low < high) {
			// For small sub-arrays, just do the sort directly
			if (high - low < 3) {
				// Use insertion sort for tiny sub-arrays (less than 3 elements)
				insertionSort(arr, low, high, comparator);
				return;
			}

			// Choose pivot using Median-of-3
			medianOfThree(arr, low, high, comparator);

			// Partition and get pivot index
			int pivotIndex = partition(arr, low, high, comparator);

			// Recursively sort left and right of pivot
			quickSort(arr, low, pivotIndex - 1, comparator);
			quickSort(arr, pivotIndex + 1, high, comparator);
		}
	}

	/**
	 * Median-of-3 pivot selection.
	 * Sorts arr[low], arr[mid], arr[high] among themselves in DESCENDING order,
	 * then places the median (pivot) at arr[high - 1].
	 */
	private static void medianOfThree(Comparable[] arr, int low, int high, Comparator comparator) {
		int mid = (low + high) / 2;

		// Sort low, mid, high in DESCENDING order (largest first)
		// After this: arr[low] >= arr[mid] >= arr[high]

		if (compare(arr[low], arr[mid], comparator) < 0) {
			swap(arr, low, mid);
		}
		if (compare(arr[low], arr[high], comparator) < 0) {
			swap(arr, low, high);
		}
		if (compare(arr[mid], arr[high], comparator) < 0) {
			swap(arr, mid, high);
		}

		// Place pivot (median) at high - 1
		swap(arr, mid, high - 1);
	}

	/**
	 * Partitions the array around the pivot (stored at arr[high - 1]).
	 * Elements LARGER than pivot go to the left (descending order).
	 * Elements SMALLER than pivot go to the right.
	 * Returns the final position of the pivot.
	 */
	private static int partition(Comparable[] arr, int low, int high, Comparator comparator) {
		Comparable pivot = arr[high - 1];

		int i = low;       // left pointer
		int j = high - 1;  // right pointer (starts at pivot position)

		while (true) {
			// Move left pointer right: find element SMALLER than pivot (doesn't belong on left in descending)
			while (compare(arr[++i], pivot, comparator) > 0);

			// Move right pointer left: find element LARGER than pivot (doesn't belong on right in descending)
			while (j > low && compare(arr[--j], pivot, comparator) < 0);

			if (i >= j) {
				break;
			}

			swap(arr, i, j);
		}

		// Restore pivot to its correct position
		swap(arr, i, high - 1);

		return i;
	}

	/**
	 * Helper: compares two elements using Comparator if provided, otherwise Comparable.
	 */
	private static int compare(Comparable a, Comparable b, Comparator comparator) {
		if (comparator != null) {
			return comparator.compare(a, b);
		} else {
			return a.compareTo(b);
		}
	}

	/**
	 * Helper: swaps two elements in the array.
	 */
	private static void swap(Comparable[] arr, int i, int j) {
		Comparable temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	/**
	 * Simple insertion sort for small sub-arrays (used when sub-array has fewer than 3 elements).
	 * Sorts in DESCENDING order.
	 */
	private static void insertionSort(Comparable[] arr, int low, int high, Comparator comparator) {
		for (int i = low + 1; i <= high; i++) {
			Comparable key = arr[i];
			int j = i - 1;

			while (j >= low && compare(arr[j], key, comparator) < 0) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
	}
}
