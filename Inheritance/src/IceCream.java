/**
 * Represents an ice cream item with a fixed price.
 */
public class IceCream extends Dessert {

    // Field specific to IceCream
    private double price; // Price of the ice cream

    /**
     * Constructs a new IceCream item.
     *
     * @param name  Name of the ice cream
     * @param price Price of the ice cream
     *
     * AUTOHR : UTSHAB NIRAULA
     */
    public IceCream(String name, double price) {
        super(name); // Call the Dessert constructor to set the name
        this.price = price;
    }

    /**
     * Gets the price of the ice cream.
     *
     * @return Price of the ice cream
     */
    @Override
    public double getPrice() {
        return price;
    }
}