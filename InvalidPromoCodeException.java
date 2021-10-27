
package addressbook;

public class InvalidPromoCodeException extends Exception {

    public InvalidPromoCodeException(String em) {
        System.out.println(em);
    }
    public InvalidPromoCodeException(String em, double p) {
        System.out.println(em);
    }
}
