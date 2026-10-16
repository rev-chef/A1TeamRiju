package utilities;

import java.util.Comparator;

import products.Product;

public class SelectionSort {
	
	 /**
     * Overloaded method: Sorts using the array's natural ordering (or default comparison).
     */
	public static void sort(Product[] products) {
        int s = products.length;
        
        // Outer loop: move through each element until the second-to-last item
        for (int i = 0; i < s - 1; i++) {
        	int maxIndex = i; // Assume the current index holds the maximum value
            
        	 // Inner loop: check the remaining unsorted elements to find a larger value
        	for (int j = i + 1; j < s; j++) {
        		// Default comparison: Change '< 0' to '> 0' if you want to switch ascending/descending
        		if (products[j].compareTo(products[maxIndex]) > 0) {
                    maxIndex = j; // Update maxIndex if a larger element is found
                }}
            
        	// Swap the found maximum element with the element at the current index i
            Product num = products[maxIndex];
            products[maxIndex] = products[i];
            products[i] = num; 
        }
	}

	
	/**
     * Overloaded method: Sorts using a custom Comparator passed by the benchmark runner.
     */
	
	public static void sort(Product[] products, Comparator<Product> comparator) {
        int s = products.length;
        
     // Outer loop: move through each element until the second-to-last item
        for (int i = 0; i < s - 1; i++) {
            int maxIndex = i; // Assume the current index holds the maximum value
            
         // Inner loop: check the remaining unsorted elements to find a larger value
            for (int j = i + 1; j < s; j++) {
                // Uses the comparator's custom rules to evaluate which item is "larger"
                if (comparator.compare(products[j], products[maxIndex]) > 0) {
                    maxIndex = j; // Update maxIndex if a larger element is found
                }
            }
            
            // Swap the found maximum element with the element at the current index i
            Product num = products[maxIndex];
            products[maxIndex] = products[i];
            products[i] = num;
        }
	}
}
