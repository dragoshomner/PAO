package models;

import java.util.ArrayList;

public class Marketplace {
	private static int nextId = 0;
	private final int id;
	private final String code;
	private String name;
	private ArrayList<Customer> customers;
	private ArrayList<Product> products;
	
	public Marketplace(String code, String name) {
		this.id = getNextId();
		this.name = name;
		this.code = code;
		customers = new ArrayList<Customer>();
		products = new ArrayList<Product>();
	}

	private int getNextId() {
		return ++nextId;
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

	public int getId() {
		return id;
	}

	public void addCustomer(Customer customer) {
		customers.add(customer);
	}
	
	public int getNumberOfCustomers() {
		return customers.size();
	}

	public String getCode() {
		return code;
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
		}
		for (Product p : products) {
			System.out.println(p.toString());
		}
		if (customers.size() < 1) {
			System.out.println("Nu sunt clienti");
		}
		for (Customer c : customers) {
			System.out.println(c.toString());
		}
	}
	
	public void showOrders() { 
		System.out.println("------------------------------");
		System.out.println("Nume: " + name);
		for (Customer customer : customers) {
			customer.showOrders();
		}
	}

	public String toCSV() {
		return code + "," +
				name + "\n";
	}
}
