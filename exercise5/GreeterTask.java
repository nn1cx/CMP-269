public class GreeterTask implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello from " + Thread.currentThread().getName());
            try {
                Thread.sleep(500);
            }
            catch (InterruptedException e) {
                System.out.println("Thread " + Thread.currentThread().getName() + " was interrupted.");
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new GreeterTask(), "Lehman-Thread-1");
        Thread t2 = new Thread(new GreeterTask(), "Lehman-Thread-2");

        t1.start();
        t2.start();
    }
} 
