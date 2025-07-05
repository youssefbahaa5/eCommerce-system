package system;

public abstract class Product {
	    private String name;
	    private double price;
	    private int quantity;

	    public Product(String name, double price, int quantity) {
	        this.name = name;
	        this.price = price;
	        this.quantity = quantity;
	    }

	    public String getName() {
	    	return name;
	    	}
	    public double getPrice() {
	    	return price;
	    	}
	    public int getQuantity() { 
	    	return quantity; 
	    	}
	    public void decreaseQuantity(int amount) { 
            if (amount > quantity){
            	throw new IllegalArgumentException("Cannot reduce more than available");
            }
            quantity -= amount; 
        }
	    
	    
	    
}
