package models;

import java.util.ArrayList;

public class Cart {
	private ArrayList<CartProduct> products;
	private double total = 0;
	
	public Cart() {
		products = new ArrayList<CartProduct>();
	}

	public ArrayList<CartProduct> getProducts() {
		return products;
	}

	public void addProduct(Product product, int quantity) {
		if (quantity <= 0) {
			System.err.println("Cantitatea trebuie sa fie mai mare decat 0");
			return ;
		}
		total += product.getPrice() * quantity;
		for (CartProduct p : products) {
			if (p.getProduct().equals(product)) {
				p.addQuantity(quantity);
				return ;
			}
		}
		
		CartProduct cartProduct = new CartProduct(product, quantity);
		products.add(cartProduct);
	}
	
	public double getTotal() {
		return total;
	}
	
	public void show() {
		if (products.size() > 0) {
			for (CartProduct product : products) {
				product.show();
			}
			System.out.printf("Total: %.2f lei\n", total);
		}
		else {
			System.out.println("Cosul este gol!");
		}
	}
	
	public void clear() {
		products.clear();
		total = 0;
	}
	
	public boolean isEmpty() {
		return products.isEmpty();
	}
}
