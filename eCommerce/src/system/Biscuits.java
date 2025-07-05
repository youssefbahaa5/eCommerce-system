package system;

import java.time.LocalDate;

public class Biscuits extends Product implements Expirable, Shippable {
    private final double weight;
    private final LocalDate expiryDate;
    
    public Biscuits(String name,double price,int quantity,double weight,LocalDate expiryDate){
        super(name,price,quantity);
        this.weight=weight; 
        this.expiryDate=expiryDate;
    }
    public double getWeight(){
    	return weight; 
    	}
    public LocalDate getExpiryDate(){ 
    	return expiryDate;
    	}
}
