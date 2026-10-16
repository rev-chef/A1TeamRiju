package products;

public class Jackets extends Product{

	
	private final double ADJUSTMENT = 0.7;
	
	public Jackets(double originalPrice, double updatedPrice) {
		super(originalPrice, updatedPrice);
	}
	
	@Override
	public double calcRealDiff(double originalPrice, double updatedPrice) {
		
		return ADJUSTMENT * (Math.abs(updatedPrice - originalPrice));
	}


}
