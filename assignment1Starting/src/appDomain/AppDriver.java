package appDomain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import products.*;

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
	 *  The main method is the entry point of the application.
	 *  
	 *  @param args The input to control the execution of the application.
	 */
	public static void main( String[] args )
	{
		File products1 = new File("res/products1.txt");
		File products2 = new File("res/products2.txt");
		File products3 = new File("res/products3.txt");
		
		
		try {
			
			Scanner file = new Scanner(products1);
			
			int arraySize = Integer.parseInt(file.nextLine());
			
			Product[] products = new Product[arraySize];
			
			
			for(int i=0; i<=arraySize; i++)
			{
				String line = file.nextLine();
				String[] data = line.split(",");
				
				double originalPrice = Double.parseDouble(data[1]);
				double updatedPrice = Double.parseDouble(data[2]);
				
				switch(data[0].toLowerCase())
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
					
				}
			}
			System.out.println(products);
			
			
		} 
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Dresses d1 = new Dresses(16.67, 19.82);
		Dresses d2 = new Dresses(1.67, 1.82);
		
		System.out.println(d1.compareTo(d2));
	}
	
	public void determineType(String type, double oPrice, double uPrice) {
		
		
	}
}
