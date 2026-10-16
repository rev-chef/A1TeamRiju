package products;

public class Jeans extends Product{

	
	private final double ADJUSTMENT = 0.5;
	
	public Jeans(double originalPrice, double updatedPrice) {
		super(originalPrice, updatedPrice);
	}
	
	@Override
	public double calcRealDiff(double originalPrice, double updatedPrice) {
		
		return ADJUSTMENT * (Math.abs(updatedPrice - originalPrice));
	}


}
