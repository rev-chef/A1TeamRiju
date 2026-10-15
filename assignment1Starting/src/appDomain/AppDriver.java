package appDomain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;

import products.*;
import utilities.*;

/**
 * <p>
 * This application driver code is designed to be used as a basis for the
 * Complexity and Sorting assignment that will be developed in the CPRG304
 * class at SAIT. The implementors of this applications will be required
 * to add all the correct functionality.
 * </p>
 */
public class AppDriver
{
	/**
	 * The main method is the entry point of the application.
	 *
	 * @param args The input to control the execution of the application.
	 */
	public static void main(String[] args)
	{
		String fileName = null;
		String compareType = null;
		String sortAlgorithm = null;

		// =============================================
		// 1. PARSE COMMAND LINE ARGUMENTS
		// =============================================
		for (String arg : args)
		{
			String upper = arg.toUpperCase();

			if (upper.startsWith("-F"))
			{
				fileName = arg.substring(2);
			}
			else if (upper.startsWith("-T"))
			{
				compareType = arg.substring(2).toLowerCase();
			}
			else if (upper.startsWith("-S"))
			{
				sortAlgorithm = arg.substring(2).toLowerCase();
			}
			else
			{
				System.out.println("Error: Unknown argument '" + arg + "'");
				System.out.println("Usage: java -jar Sort.jar -f<file_name> -t<compare_type> -s<sort_algorithm>");
				System.out.println("  -f or -F: file name (e.g., -fproducts1.txt)");
				System.out.println("  -t or -T: compare type (o = original, u = updated, d = difference)");
				System.out.println("  -s or -S: sort algorithm (b = bubble, s = selection, i = insertion, m = merge, q = quick, z = custom)");
				return;
			}
		}

		// Validate all arguments are provided
		if (fileName == null || compareType == null || sortAlgorithm == null)
		{
			System.out.println("Error: Missing required arguments.");
			System.out.println("Usage: java -jar Sort.jar -f<file_name> -t<compare_type> -s<sort_algorithm>");
			System.out.println("  -f or -F: file name (e.g., -fproducts1.txt)");
			System.out.println("  -t or -T: compare type (o = original, u = updated, d = difference)");
			System.out.println("  -s or -S: sort algorithm (b = bubble, s = selection, i = insertion, m = merge, q = quick, z = custom)");
			return;
		}

		// Validate compare type
		if (!compareType.equals("o") && !compareType.equals("u") && !compareType.equals("d"))
		{
			System.out.println("Error: Invalid compare type '" + compareType + "'. Use o, u, or d.");
			return;
		}

		// Validate sort algorithm
		if (!sortAlgorithm.equals("b") && !sortAlgorithm.equals("s") && !sortAlgorithm.equals("i")
				&& !sortAlgorithm.equals("m") && !sortAlgorithm.equals("q") && !sortAlgorithm.equals("z"))
		{
			System.out.println("Error: Invalid sort algorithm '" + sortAlgorithm + "'. Use b, s, i, m, q, or z.");
			return;
		}

		// =============================================
		// 2. READ FILE AND CREATE PRODUCT OBJECTS
		// =============================================
		Product[] products = null;

		try
		{
			// Remove quotes if present in file path
			if (fileName.startsWith("\"") && fileName.endsWith("\""))
			{
				fileName = fileName.substring(1, fileName.length() - 1);
			}

			File inputFile = new File(fileName);
			Scanner file = new Scanner(inputFile);

			int arraySize = Integer.parseInt(file.nextLine().trim());
			products = new Product[arraySize];

			for (int i = 0; i < arraySize; i++)
			{
				String line = file.nextLine().trim();
				String[] data = line.split(" ");

				String type = data[0];
				double originalPrice = Double.parseDouble(data[1]);
				double updatedPrice = Double.parseDouble(data[2]);

				switch (type.toLowerCase())
				{
				case "jeans":
					products[i] = new Jeans(originalPrice, updatedPrice);
					break;
				case "tshirts":
					products[i] = new TShirts(originalPrice, updatedPrice);
					break;
				case "skirts":
					products[i] = new Skirts(originalPrice, updatedPrice);
					break;
				case "dresses":
					products[i] = new Dresses(originalPrice, updatedPrice);
					break;
				case "shorts":
					products[i] = new Shorts(originalPrice, updatedPrice);
					break;
				case "jackets":
					products[i] = new Jackets(originalPrice, updatedPrice);
					break;
				case "shoes":
					products[i] = new Shoes(originalPrice, updatedPrice);
					break;
				default:
					System.out.println("Error: Unknown product type '" + type + "' on line " + (i + 2));
					file.close();
					return;
				}
			}

			file.close();

		}
		catch (FileNotFoundException e)
		{
			System.out.println("Error: File '" + fileName + "' not found.");
			return;
		}
		catch (Exception e)
		{
			System.out.println("Error reading file: " + e.getMessage());
			return;
		}

		// =============================================
		// 3. SET UP COMPARATOR
		// =============================================
		Comparator<Product> comparator = null;
		String compareLabel = "";

		switch (compareType)
		{
		case "o":
			comparator = new OriginalCompare();
			compareLabel = "Original Price";
			break;
		case "u":
			comparator = new UpdatedCompare();
			compareLabel = "Updated Price";
			break;
		case "d":
			// comparator stays null — will use Comparable (compareTo / calcRealDiff)
			compareLabel = "Real Difference";
			break;
		}

		// =============================================
		// 4. SORT WITH BENCHMARKING
		// =============================================
		String sortName = "";

		long startTime = System.currentTimeMillis();

		switch (sortAlgorithm)
		{
		case "b":
			sortName = "Bubble Sort";
			if (comparator != null)
				BubbleSort.sort(products, comparator);
			else
				BubbleSort.sort(products);
			break;
		case "s":
			sortName = "Selection Sort";
			if (comparator != null)
				SelectionSort.sort(products, comparator);
			else
				SelectionSort.sort(products);
			break;
		case "i":
			sortName = "Insertion Sort";
			if (comparator != null)
				InsertionSort.sort(products, comparator);
			else
				InsertionSort.sort(products);
			break;
		case "m":
			sortName = "Merge Sort";
			if (comparator != null)
				MergeSort.sort(products, comparator);
			else
				MergeSort.sort(products);
			break;
		case "q":
			sortName = "Quick Sort";
			if (comparator != null)
				QuickSort.sort(products, comparator);
			else
				QuickSort.sort(products);
			break;
		case "z":
			sortName = "ICantBelieveItCanSort";
			if (comparator != null)
				ICantBelieveItCanSort.sort(products, comparator);
			else
				ICantBelieveItCanSort.sort(products);
			break;
		}

		long endTime = System.currentTimeMillis();

		// =============================================
		// 5. DISPLAY RESULTS
		// =============================================
		int n = products.length;

		if (n <= 10)
		{
			// Display ALL objects
			for (int i = 0; i < n; i++)
			{
				System.out.println((i + 1) + getSuffix(i + 1) + " element:\t\t"
						+ products[i].getClass().getName() + "\t\t"
						+ compareLabel + ": " + getCompareValue(products[i], compareType));
			}
		}
		else if (n <= 1000)
		{
			// Display first, every 100th, and last
			System.out.println("First element is:\t\t"
					+ products[0].getClass().getName() + "\t\t"
					+ compareLabel + ": " + getCompareValue(products[0], compareType));

			for (int i = 99; i < n - 1; i += 100)
			{
				System.out.println((i + 1) + "-th element:\t\t"
						+ products[i].getClass().getName() + "\t\t"
						+ compareLabel + ": " + getCompareValue(products[i], compareType));
			}

			System.out.println("Last element is:\t\t"
					+ products[n - 1].getClass().getName() + "\t\t"
					+ compareLabel + ": " + getCompareValue(products[n - 1], compareType));
		}
		else
		{
			// Display first, every 1000th, and last
			System.out.println("First element is:\t\t"
					+ products[0].getClass().getName() + "\t\t"
					+ compareLabel + ": " + getCompareValue(products[0], compareType));

			for (int i = 999; i < n - 1; i += 1000)
			{
				System.out.println((i + 1) + "-th element:\t\t"
						+ products[i].getClass().getName() + "\t\t"
						+ compareLabel + ": " + getCompareValue(products[i], compareType));
			}

			System.out.println("Last element is:\t\t"
					+ products[n - 1].getClass().getName() + "\t\t"
					+ compareLabel + ": " + getCompareValue(products[n - 1], compareType));
		}

		// Display benchmarking result
		System.out.println(sortName + " run time was: " + (endTime - startTime) + " milliseconds");
	}

	/**
	 * Gets the value used for comparison based on the compare type.
	 */
	private static double getCompareValue(Product product, String compareType)
	{
		switch (compareType)
		{
		case "o":
			return product.getOriginalPrice();
		case "u":
			return product.getUpdatedPrice();
		case "d":
			return product.calcRealDiff(product.getOriginalPrice(), product.getUpdatedPrice());
		default:
			return 0;
		}
	}

	/**
	 * Returns the ordinal suffix for a number (1st, 2nd, 3rd, 4th, etc.)
	 */
	private static String getSuffix(int num)
	{
		if (num >= 11 && num <= 13) return "-th";

		switch (num % 10)
		{
		case 1: return "-st";
		case 2: return "-nd";
		case 3: return "-rd";
		default: return "-th";
		}
	}
}
