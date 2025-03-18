/**
 * Represents a candy item sold by weight.
 * Author : UTSHAB NIRAULA
 */
public class Candy extends Dessert {

    // Fields specific to Candy
    private double pricePerPound; // Price per pound of candy
    private double weight;        // Weight of candy in pounds

    /**
     * Constructs a new Candy item.
     *
     * @param name          Name of the candy
     * @param pricePerPound Price per pound of the candy
     * @param weight        Weight of the candy in pounds
     */
    public Candy(String name, double pricePerPound, double weight) {
        super(name); // Call the Dessert constructor to set the name
        this.pricePerPound = pricePerPound;
        this.weight = weight;
    }

    /**
     * Gets the weight of the candy in pounds.
     *
     * @return Weight of the candy in pounds
     */
    public double getWeightInPounds() {
        return weight;
    }

    /**
     * Gets the price per pound of the candy.
     *
     * @return Price per pound of the candy
     */
    public double getPricePerPound() {
        return pricePerPound;
    }

    /**
     * Calculates the total price of the candy.
     *
     * @return Total price of the candy (price per pound * weight)
     */
    @Override
    public double getPrice() {
        return pricePerPound * weight;
    }
}