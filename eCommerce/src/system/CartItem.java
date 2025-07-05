package system;

public class CartItem {
    Product product;
    int quantity;
    public CartItem(Product product,int quantity){
    	this.product=product;
    	this.quantity=quantity;
    	}
    public double lineTotal(){ 
    	return quantity*product.getPrice(); 
    	}
}