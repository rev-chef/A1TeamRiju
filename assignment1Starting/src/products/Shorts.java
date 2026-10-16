package products;

public class Shorts extends Product{

	
	private final double ADJUSTMENT = 0.3;
	
	public Shorts(double originalPrice, double updatedPrice) {
		super(originalPrice, updatedPrice);
	}
	
	@Override
	public double calcRealDiff(double originalPrice, double updatedPrice) {
		
		return ADJUSTMENT * (Math.abs(updatedPrice - originalPrice));
	}


}
