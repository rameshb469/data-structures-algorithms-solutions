package ds.multithread;

/**
 * Creating multi-thread environment using @{@link Runnable} interface
 */
public class ThreadUsingRunnable implements  Runnable {
    @Override
    public void run() {
        System.out.println("Inside Run method");
    }

    public static void main(String[] args) {
        Runnable r1 = new ThreadUsingRunnable();

        Thread thread = new Thread(r1);
        thread.start();

        System.out.println("Inside the method");
    }
}
