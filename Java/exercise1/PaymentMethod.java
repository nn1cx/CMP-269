public abstract class PaymentMethod implements Payable{
    protected String accountHolder;
    protected double balance;
    static int totalTransactions = 0;

    public PaymentMethod(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public abstract void validateAccount();

}
