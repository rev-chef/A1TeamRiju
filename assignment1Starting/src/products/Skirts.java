package products;

public class Skirts extends Product{

	
	private final double ADJUSTMENT = 0.1;
	
	public Skirts(double originalPrice, double updatedPrice) {
		super(originalPrice, updatedPrice);
	}
	
	@Override
	public double calcRealDiff(double originalPrice, double updatedPrice) {
		
		return ADJUSTMENT * (Math.abs(updatedPrice - originalPrice));
	}


}

