public class coordination implements Runnable{
    public static long result = 0;

    @Override
    public void run() {
        try{
            Thread.sleep(500);
        }
        catch (InterruptedException e) {
            System.out.println("Thread " + Thread.currentThread().getName() + " was interrupted.");
            Thread.currentThread().interrupt();
        }

        System.out.println("Thread " + Thread.currentThread().getName() + " performing heavy calculation.");
        for (int i = 0; i < 1000000; i++) {
            result += i;
        }
    }

    public static void main(String[] args) {
        coordination coord = new coordination();
        Thread t1 = new Thread(coord, "Coordination-Thread-1");

        t1.start();
        
        try {
            t1.join();
            System.out.println("Calculation Finished: " + result);
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted.");
        }
    }
    
}
