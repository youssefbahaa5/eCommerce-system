package system;

import java.util.*;

public class Cart {
    private final List<CartItem> items = new ArrayList<>();

    public void add(Product price ,int quantity){
    	
        if(quantity<=0) 
        	throw new IllegalArgumentException("quantity must be >0");
        
        if(price instanceof Expirable && ((Expirable)price).isExpired())
            throw new IllegalStateException(price.getName()+" is expired");
        
        if(price.getQuantity()<quantity) 
        	throw new IllegalStateException("Only "+price.getQuantity()+" "+ price.getName()+" in stock");

        CartItem line = null;
        for(CartItem cartItem: items){
            if(cartItem.product == price){
            	line = cartItem;
                break; }
        }
        if(line==null){
            items.add(new CartItem(price,quantity));
        }
        else{
            if(price.getQuantity()< line.quantity + quantity)
                throw new IllegalStateException("Stock insufficient for "+price.getName());
            line.quantity += quantity;
        }
    }

    public boolean isEmpty(){ return items.isEmpty(); }
    public List<CartItem> getItems(){ return items; }
    public double subTotal(){
        double sum=0;
        for(CartItem cartItem: items) sum += cartItem.lineTotal();
        return sum;
    }
    public void clear(){ items.clear(); }
}
