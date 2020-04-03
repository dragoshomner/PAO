import java.util.ArrayList;

public class Order {
	private static int nextId = 0;
	private final int id;
	private ArrayList<OrderProduct> products;
	private OrderStatus status;
	private final double total;
	
	public Order(Cart cart) {
		this.id = getNextId();
		this.products = new ArrayList<OrderProduct>();
		
		for (CartProduct product : cart.getProducts()) {
			OrderProduct orderProduct;
			Product p = product.getProduct();
			int qty = product.getQuantity();
			orderProduct = new OrderProduct(p, qty);
			products.add(orderProduct);
		}
		total = cart.getTotal();
		status = new OrderStatus();
	}

	private int getNextId() {
		return ++nextId;
	}
	
	public int getId() {
		return id;
	}
	
	public String getCurrentStatus() {
		return status.getStatus();
	}
	
	public void nextStatus() {
		status.nextStatus();
	}
	
	public void show() {
		System.out.println("------------------------------");
		System.out.println("Order ID: " + getId());
		for (OrderProduct p : products) {
			System.out.println(p.toString());
		}
		System.out.println("Total: " + total + " lei");
		System.out.println("Status: " + getCurrentStatus());
	}
}
