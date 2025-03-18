public class InsufficientFundsException extends Exception{

    private double shortfall;

    public InsufficientFundsException(double shortfall) {
        super("You need more money!");
          this.shortfall = shortfall;
    }

    public double getShortfall(){
        return shortfall;
    }



}
