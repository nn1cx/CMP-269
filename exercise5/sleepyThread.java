public class sleepyThread implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            System.out.println("Thread " + Thread.currentThread().getName() + " was interrupted.");
            Thread.currentThread().interrupt();
        }
    }
    
    public static void main(String[] args) {
        Thread t1 = new Thread(new sleepyThread(), "Sleepy-Thread-1");
        System.out.println("State after creation: "+ t1.getState());

        t1.start();
        System.out.println("State after starting: "+ t1.getState());

        try {
            Thread.sleep(500);
            System.out.println("State after sleeping: "+ t1.getState());
        }
        catch (InterruptedException e) {
            System.out.println("Main thread was interrupted.");
            Thread.currentThread().interrupt();
        }

        try {
            t1.join();
            System.out.println("State after joining: "+ t1.getState());
        }
        catch (InterruptedException e) {
            System.out.println("Main thread was interrupted while joining.");
            Thread.currentThread().interrupt();
        }
        
    }
    
}
