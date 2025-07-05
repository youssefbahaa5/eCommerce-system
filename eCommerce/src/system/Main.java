package system;
import java.time.LocalDate;
public class Main {
	

	
	    public static void main(String[] args) {
	        Cheese cheese = new Cheese("Cheese",100,10,0.2, LocalDate.now().plusDays(5));
	        Biscuits biscuits = new Biscuits("Biscuits",150,5,0.7, LocalDate.now().plusDays(10));
	        TV tv = new TV("TV",3000,3,10);
	        MobileScratchCard scratch = new MobileScratchCard("Mobile scratch card",30,20);

	        Customer youssef = new Customer("Youssef", 1000);
	        Cart cart = new Cart();

	        cart.add(cheese,2);
	        cart.add(biscuits,1);
	        cart.add(scratch,1);

	        CheckoutService.checkout(youssef, cart);

	        try{
	            Cart c2=new Cart();
	            c2.add(tv,4);
	        }catch(Exception e){ System.out.println("Error: "+e.getMessage()); }
	    
	        try {
	            Customer omar = new Customer("omar", 1000);
	            Cart om = new Cart(); 
	            CheckoutService.checkout(omar, om);
	        } catch (Exception e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    try {
	        Customer c = new Customer("Ahmed", 1000); 
	        Cart c1= new Cart();
	        c1.add(new TV("TV", 3000, 3, 10), 1); 
	        CheckoutService.checkout(c, c1);
	    } catch (Exception e) {
	        System.out.println("Error: " + e.getMessage());
	    }
	    try {
            Cheese oldCheese = new Cheese("Cheese", 50, 5, 0.2, LocalDate.now().minusDays(1));
            Customer t = new Customer("tobby", 1000);
            Cart c3 = new Cart();
            c3.add(oldCheese, 1);
            CheckoutService.checkout(t, c3);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
    }

