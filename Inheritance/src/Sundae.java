/**
 * Represents a sundae, which is an ice cream item with a topping.
 * AUTHOR : UTSHAB NIRAULA
 */
public class Sundae extends IceCream {

    // Field specific to Sundae
    private Dessert topping; // Topping for the sundae

    /**
     * Constructs a new Sundae item.
     *
     * @param iceCream The base ice cream
     * @param topping  The topping (can be any Dessert type)
     */
    public Sundae(IceCream iceCream, Dessert topping) {
        super(iceCream.getName() + " topped with " + topping.getName(), iceCream.getPrice() +
                topping.getPrice());
        this.topping = topping;
    }
}
