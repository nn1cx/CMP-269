public class MealPlan extends PaymentMethod{
    
    public MealPlan(String accountHolder, double initialBalance) {
        super(accountHolder, initialBalance);
    }

    @Override
    public void processPayment(double amount) {
        if (amount > super.balance) {
            System.out.println("Insufficient funds in meal plan account.");
        } else {
            super.balance -= amount;
            System.out.println("Meal plan payment of " + amount + " processed.");
            super.totalTransactions++;
        }
    }

    @Override
    public void validateAccount() {
        System.out.println("Meal plan account for " + super.accountHolder + " is valid.");
    }

    @Override
    public String getPaymentStatus() {
        return "Account Holder: " + super.accountHolder + ", Meal Plan Balance: " + super.balance;
    }
}
