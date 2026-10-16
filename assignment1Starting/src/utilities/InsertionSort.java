package utilities;

import java.util.Comparator;

import products.Product;

public class InsertionSort {
	
	/**
     * Sorts an array of Integers in-place using the Insertion Sort algorithm.
     * Note: The current condition (products[j] < key) sorts the array in descending order.
     *
     * @param products the array of Integer objects to be sorted
     */
    
	public static void sort(Product[] products) {
        int in = products.length;
        
    	// Traverse through the array starting from the second element (index 1)
        for (int i = 1; i < in; ++i) {
            
        	// The value to be positioned in the sorted portion of the array
        	Product key = products[i]; 
        	
        	// Index of the last element in the sorted left-hand portion
            int j = i - 1;
            
         // Shift elements of the sorted portion that are smaller than the key to the right
         // Change '> 0' to '< 0' if you want to swap ascending/descending order
            while (j >= 0 && products[j].compareTo(key) > 0) {
                products[j + 1] = products[j];
                j--; // Move left through the sorted portion
            }
            
         // Place the key into its correct sorted position
            products[j + 1] = key;
        }
    }
	
	 /**
     * Overloaded method: Sorts using a custom Comparator passed by the benchmark runner.
     */
	
	public static void sort(Product[] products, Comparator<Product> comparator) {
        int n = products.length;
        
     // Traverse through the array starting from the second element (index 1)
        for (int i = 1; i < n; ++i) {
            
        	// The value to be positioned in the sorted portion of the array
        	Product key = products[i];
            
         // Index of the last element in the sorted left-hand portion
            int j = i - 1;

            // Move elements based on the custom comparator rule
            // Change '> 0' to '< 0' if you want to swap ascending/descending order
            while (j >= 0 && comparator.compare(products[j], key) > 0) {
                products[j + 1] = products[j];
                j = j - 1; // Move left through the sorted portion
            }
            
         // Place the key into its correct sorted position
            products[j + 1] = key;
        }
    }
	
}
