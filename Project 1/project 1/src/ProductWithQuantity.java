
public class ProductWithQuantity {
	private Product product;
	private int quantity;
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ProductWithQuantity(Product product, int quantity)
	{
		this.product = product;
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return product.toString() + " | Quantity: " + getQuantity();
	}
}
