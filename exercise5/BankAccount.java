public class BankAccount implements Runnable{
    private int balance = 1000;

    @Override
    public void run() {
        try{
            Thread.sleep(500);
        }
        catch (InterruptedException e) {
            System.out.println("Thread " + Thread.currentThread().getName() + " was interrupted.");
            Thread.currentThread().interrupt();
        }
        withdraw(700);
    }
    
    private synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ". Current Balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " attempted to withdraw " + amount + ", but insufficient funds. Current Balance: " + balance);
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Thread h = new Thread(account, "Husband");
        Thread w = new Thread(account, "Wife");

        h.start();
        w.start();
    }

}
