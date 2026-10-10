package utilities;

import java.util.Comparator;

import products.Product;

public class OriginalCompare implements Comparator<Product>{

	@Override
	public int compare(Product p1, Product p2) {
		
		if( p1.getOriginalPrice() > p2.getOriginalPrice() )
		{
			return 1;
		}
		else if( p1.getOriginalPrice() < p2.getOriginalPrice() )
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}



}
