package models;

import java.util.ArrayList;

public class Marketplace {
	String name;
	private ArrayList<Customer> customers;
	private ArrayList<Product> products;
	
	public Marketplace(String name) {
		this.name = name;
		customers = new ArrayList<Customer>();
		products = new ArrayList<Product>();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void addCustomer(Customer customer) {
		customers.add(customer);
	}
	
	public int getNumberOfCustomers() {
		return customers.size();
	}
	
	public void addProduct(Product product) {
		for (Product p : products) {
			if (p.equals(product)) {
				System.err.println("Produsul " + product.getName() + " era deja adaugat!");
				return ;
			}
		}
		products.add(product);
	}

	public void show() {
		System.out.println("------------------------------");
		System.out.println("Nume: " + name);
		if (products.size() < 1) {
			System.out.println("Nu sunt produse");
			return ;
		}
		for (Product p : products) {
			System.out.println(p.toString());
		}
	}
	
	public void showOrders() { 
		System.out.println("------------------------------");
		System.out.println("Nume: " + name);
		for (Customer customer : customers) {
			customer.showOrders();
		}
	}
}
