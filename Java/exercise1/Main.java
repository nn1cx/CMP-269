import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Payable> paymentQueue = new ArrayList<Payable>();
        paymentQueue.add(new CreditCard("Alice", 500.0, 1000.0));
        paymentQueue.add(new MealPlan("Alice", 300.0));
        
        for (int i = 0; i < paymentQueue.size(); i++) {
            Payable paymentMethod = paymentQueue.get(i);
            paymentMethod.processPayment(50.0);
        }

        System.out.println("Total transactions: " + MealPlan.totalTransactions);

    }
}
