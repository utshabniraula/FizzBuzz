public class BankAccount {

    private int accountNumber;
    private double balance;

    public BankAccount(int accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double depositAmount) {

        if ( depositAmount < 0) {
            throw new IllegalArgumentException("Cannot deposit a negative amount");
        }else {
            this.balance += depositAmount;
        }
    }

        public void withdraw(double withdrawAmount) throws InsufficientFundsException {
        if ( withdrawAmount < 0) {
            throw new IllegalArgumentException("Cannot withdraw a negative amount");
        }else if (this.balance < withdrawAmount) {
            throw new InsufficientFundsException(withdrawAmount - balance);
        }else {
            this.balance -= withdrawAmount;
        }
    }

}
