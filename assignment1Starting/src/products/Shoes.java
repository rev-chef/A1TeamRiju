package products;

public class Shoes extends Product{

	
	private final double ADJUSTMENT = 0.4;
	
	public Shoes(double originalPrice, double updatedPrice) {
		super(originalPrice, updatedPrice);
	}
	
	@Override
	public double calcRealDiff(double originalPrice, double updatedPrice) {
		
		return ADJUSTMENT * (Math.abs(updatedPrice - originalPrice));
	}

}
