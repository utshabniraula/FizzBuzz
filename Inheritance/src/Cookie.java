/**
 * Represents a cookie item sold by the dozen.
 * AUTHOR : UTSHAB NIRAULA
 */
public class Cookie extends Dessert {

    // Fields specific to Cookie
    private double pricePerDozen; // Price per dozen cookies
    private int itemCount;        // Number of cookies

    /**
     * Constructs a new Cookie item.
     *
     * @param name          Name of the cookie
     * @param pricePerDozen Price per dozen cookies
     * @param itemCount     Number of cookies
     */
    public Cookie(String name, double pricePerDozen, int itemCount) {
        super(name); // Call the Dessert constructor to set the name
        this.pricePerDozen = pricePerDozen;
        this.itemCount = itemCount;
    }

    /**
     * Gets the number of cookies.
     *
     * @return Number of cookies
     */
    public int getItemCount() {
        return itemCount;
    }

    /**
     * Gets the price per dozen cookies.
     *
     * @return Price per dozen cookies
     */
    public double getPricePerDozen() {
        return pricePerDozen;
    }

    /**
     * Calculates the total price of the cookies.
     *
     * @return Total price of the cookies (price per dozen / 12 * itemCount)
     */
    @Override
    public double getPrice() {
        return (pricePerDozen / 12) * itemCount;
    }
}