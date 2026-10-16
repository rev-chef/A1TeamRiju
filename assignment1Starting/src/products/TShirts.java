package products;

public class TShirts extends Product{

	
	private final double ADJUSTMENT = 0.2;
	
	public TShirts(double originalPrice, double updatedPrice) {
		super(originalPrice, updatedPrice);
	}
	
	@Override
	public double calcRealDiff(double originalPrice, double updatedPrice) {
		
		return ADJUSTMENT * (Math.abs(updatedPrice - originalPrice));
	}
}
