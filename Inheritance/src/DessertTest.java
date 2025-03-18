/** Code to test various dessert classes */
public class DessertTest {
    public static void main(String[] args) {
        System.out.println("Let's play with desserts!");

        // 1.33 lbs of gummy worms at $0.89/lb
        Candy candy = new Candy("Gummy Worms", 0.89, 1.33);
        double candyWeight = candy.getWeightInPounds();
        double candyPrice = candy.getPricePerPound();
        System.out.println(candyWeight + " pounds of " + candy.getName() +
                " at $" + candyPrice + "/lb");


        // 4 cookies at $3.99/dozen (so $3.99/12 per cookie)
        Cookie cookie = new Cookie("Oatmeal Raisin Cookies", 3.99, 4);
        int cookieCount = cookie.getItemCount();
        double cookiePrice = cookie.getPricePerDozen();
        System.out.println(cookieCount + " " + cookie.getName() +
                " at $" + cookiePrice + "/dozen");

        IceCream iceCream = new IceCream("Vanilla Ice Cream", 1.05);
        Candy topping = new Candy("Chocolate Sprinkles", 2.49, 0.1);
        Sundae candySundae = new Sundae(iceCream, topping);
        String sundaeName = candySundae.getName();
        System.out.println(sundaeName);

        Sundae cookieSundae = new Sundae(new IceCream("Strawberry Ice Cream", 1.25),
                new Cookie("Oreos", 3.49, 5));
        System.out.println(cookieSundae.getName());

        // A sundae can be topped with any dessert, even another sundae!
        Sundae sundaeSundae = new Sundae(iceCream, cookieSundae);
        System.out.println(sundaeSundae.getName());

        // Since a sundae is a kind of ice cream, we can base a sundae on another sundae.
        Sundae anotherSundae = new Sundae(candySundae, candy);
        System.out.println(anotherSundae.getName());

        // We should be able to use a new kind of dessert in our sundaes.
        // Using an anonymous class to define some cake.
        Dessert cake = new Dessert("Carrot Cake") {
            public double getPrice() {
                return 1.23;
            }
        };
        System.out.println(cake.getName());
        Sundae cakeSundae = new Sundae(iceCream, cake);
        System.out.println(cakeSundae.getName());
        Sundae cakeSundaeCakeSundae = new Sundae(cakeSundae, cakeSundae);
        System.out.println(cakeSundaeCakeSundae.getName());

        System.out.println();

        System.out.println("Put some desserts into an array and loop over them");
        Dessert[] desserts = new Dessert[] {
                candy, cookie, iceCream, topping,
                candySundae, cookieSundae, sundaeSundae, anotherSundae,
                new Candy("Peanut Butter Fudge", 3.99, 2.25),
                new Cookie("Chocolate Chip Cookies", 4.99, 3),
                new Candy("Candy Corn", 1.09, 3.0),
                cake, cakeSundae, cakeSundaeCakeSundae
        };

        for(Dessert d : desserts) {
            String name = d.getName();
            double price = d.getPrice();
            System.out.printf("%s will cost $%.2f%n", name, price);
        }
    }
}