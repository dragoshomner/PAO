package models;

public class Product {
	private static int nextId = 0;
	private final int id;
	private String name;
	private double price;
	
	public Product(String name, double price) {
		this.id = getNextId();
		this.name = name;
		this.price = price;
	}

	private int getNextId() {
		return ++nextId;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

    @Override
    public boolean equals(Object o) { 

        if (o == this) { 
            return true; 
        } 
  
        if (!(o instanceof Product)) { 
            return false; 
        } 
          
        Product p = (Product) o; 
          
        return id == p.id; 
    } 
    
    @Override
    public String toString() {
    	return "Produs: " + name + " | Price: " + price + " lei";
    }

}
