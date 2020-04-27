package models;

public class CartProduct extends ProductWithQuantity {

	public CartProduct(Product product, int quantity) {
		super(product, quantity);
	}
	
	public void addQuantity(int qty) {
		if (qty < 1) {
			return ;
		}
		setQuantity(getQuantity() + qty);
	}
	
	public void show() {
		System.out.println(this.toString());
	}
}
