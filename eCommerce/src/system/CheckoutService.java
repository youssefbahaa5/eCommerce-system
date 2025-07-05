package system;

import java.util.*;


public class CheckoutService {
    public static void checkout(Customer customer, Cart cart){
        if(cart.isEmpty()) throw new IllegalStateException("Cart is empty");

        List<Shippable> toShip = new ArrayList<>();
        for(CartItem ci: cart.getItems()){
            Product p = ci.product;
            if(p.getQuantity() < ci.quantity)
                throw new IllegalStateException(p.getName()+" out of stock");
            if(p instanceof Expirable && ((Expirable)p).isExpired())
                throw new IllegalStateException(p.getName()+" is expired");

            if(p instanceof Shippable){
                for(int i=0;i<ci.quantity;i++) toShip.add((Shippable)p);
            }
        }

        double sub = cart.subTotal();
        double shipFee = ShippingService.ship(toShip);
        double amount  = sub + shipFee;

        customer.debit(amount);

        for(CartItem ci: cart.getItems()) ci.product.decreaseQuantity(ci.quantity);

        System.out.println("** Checkout receipt **");
        for(CartItem ci: cart.getItems()){
            System.out.printf("%dx %s %.0f%n", ci.quantity, ci.product.getName(), ci.lineTotal());
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal %.0f%n", sub);
        System.out.printf("Shipping %.0f%n", shipFee);
        System.out.printf("Amount %.0f%n", amount);
        System.out.printf("%s balance after payment %.0f%n", customer.getName(), customer.getBalance());

        cart.clear();
    }
}