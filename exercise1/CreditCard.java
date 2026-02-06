package exercise1;
public class CreditCard extends PaymentMethod{
    private double creditLimit;

    public CreditCard(String accountHolder, double initialBalance, double creditLimit) {
        super(accountHolder, initialBalance);
        this.creditLimit = creditLimit;
    }

    @Override
    public void processPayment(double amount) {
        if (amount > creditLimit + super.balance) {
            System.out.println("Transaction declined.");
        }
        else {
            if (amount > super.balance) {
                double remaining = amount - super.balance;
                super.balance = 0;
                creditLimit -= remaining;
            } else {
                super.balance -= amount;
            }
            System.out.println("Transaction of " + amount + " approved.");
            super.totalTransactions++;
        }
    }

    @Override
    public String getPaymentStatus() {
        return "Account Holder: " + super.accountHolder + ", Balance: " + super.balance + ", Credit Limit: " + creditLimit;
    }

    @Override
    public void validateAccount() {
        System.out.println("Validating credit card account for " + super.accountHolder);
    }
}
