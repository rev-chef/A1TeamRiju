package products;

public class Dresses extends Product{
	
	
	private final double ADJUSTMENT = 0.6;
	
	public Dresses(double originalPrice, double updatedPrice) {
		super(originalPrice, updatedPrice);
	}
	
	@Override
	public double calcRealDiff(double originalPrice, double updatedPrice) {
		
		return ADJUSTMENT * (Math.abs(updatedPrice - originalPrice));
	}

}
