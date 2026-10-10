package products;

public class Shoes extends Product{

	private double originalPrice;
	private double updatedPrice;
	private final double ADJUSTMENT = 0.4;
	
	public Shoes(double originalPrice, double updatedPrice) {
		super(originalPrice, updatedPrice);
	}
	
	@Override
	double calcRealDiff(double originalPrice, double updatedPrice) {
		
		return ADJUSTMENT * (Math.abs(originalPrice - updatedPrice));
	}

}
