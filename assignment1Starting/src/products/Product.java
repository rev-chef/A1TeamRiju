package products;

public abstract class Product implements Comparable<Product>{
	
	
	protected double originalPrice;
	protected double updatedPrice;
	
	public Product(double originalPrice, double updatedPrice) {
		this.originalPrice = originalPrice;
		this.updatedPrice = updatedPrice;
	}
	
	public abstract double calcRealDiff(double originalPrice, double updatedPrice);
	
	public int compareTo(Product other) {
		return Double.compare(this.calcRealDiff(this.originalPrice, this.updatedPrice), other.calcRealDiff(other.originalPrice, other.updatedPrice));
		
	}
	
	public double getOriginalPrice() {
		return originalPrice;
	}
	
	public double getUpdatedPrice() {
		return updatedPrice;
	}
}
