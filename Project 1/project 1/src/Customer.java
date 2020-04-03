import java.util.ArrayList;

public class Customer {
	private static int nextId = 0;
	private final int id;

	String name;
	private Cart cart;
	private ArrayList<Order> orders;

	public Customer(String name) {
		id = getNextId();
		this.name = name;
		cart = new Cart();
		orders = new ArrayList<Order>();
	}
	
	private int getNextId() {
		return ++nextId;
	}
	
	public int getId() {
		return id;
	}
	
	public void addToCart(Product product, int quantity) {
		cart.addProduct(product, quantity);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Cart getCart() {
		return cart;
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void showCart() {
		cart.show();
	}
	
	public void toOrder() {
		if (cart.isEmpty()) {
			System.err.println("Nu se poate plasa comanda cu cosul gol!");
			return ;
		}
		Order newOrder = new Order(cart);
		orders.add(newOrder);
		cart.clear();
	}	
	
	public void showOrders() {
		if (orders.size() <= 0) {
			System.out.println("Clientul " + name + " nu are nicio comanda!");
			return ;
		}
		for (Order o : orders) {
			o.show();
		}
	}
}
