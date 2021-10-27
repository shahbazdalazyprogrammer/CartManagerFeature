
package addressbook;

import java.util.ArrayList;

public class CartManager {
    ArrayList<CartItem> items;
    CartManager() {
        items = new ArrayList<>();
    }
    public void addItem(CartItem item){
        items.add(item);
    }
    public double getTotalPrice(){
        double sum = 0;
        for(CartItem item: items){
            sum += item.price;
        }
        return sum;
    }
    public void applyPromo(String promoCode, double p) {
        try{
            if( !(promoCode.equals("ENJOY50") || promoCode.equals("HELLO100"))){
                throw new InvalidPromoCodeException(promoCode+" is not a valid promo code right now.");
            }
            else if( (promoCode.equals("ENJOY50") && p < 250)){
                throw new InvalidPromoCodeException(promoCode+" can't be applied for order of "+p);
            }
            else if( (promoCode.equals("HELLO100") && p < 500)){
                throw new InvalidPromoCodeException(promoCode+" can't be applied for order of "+p);
            }
            else{
                System.out.println("Promo code applied successfully!");
            }
        }catch(InvalidPromoCodeException e){
            
        }
    }
    public static void main(String[] args) {
        CartItem c1 = new CartItem("burger", 79);
        
        CartItem c2 = new CartItem("sandwich", 20);
        
        CartItem c3 = new CartItem("pizza", 100);
        
        CartManager o1 = new CartManager();
        
        o1.addItem(c3);
        
        o1.addItem(c2);
        
        o1.addItem(c1);
        
        CartItem cc1 = new CartItem("burger", 289);
        
        CartItem cc2 = new CartItem("sandwich", 20);
        
        CartItem cc3 = new CartItem("pizza", 200);
        
        CartManager o2 = new CartManager();
        
        o2.addItem(cc3);
        
        o2.addItem(cc2);
        
        o2.addItem(cc1);
        
        double p = o1.getTotalPrice();
        double p1 = o2.getTotalPrice();
        //System.out.println("TOTAL ORDER = "+p);
        o1.applyPromo("ENJOY50", p);
        //System.out.println("TOTAL ORDER = "+p1);
        //o2.applyPromo("HELLO10", p1);
        
    }
    
}
