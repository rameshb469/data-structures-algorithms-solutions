package ds.multithread;

/**
 * Print Even Number using one thread and odd number in another thread
 * in sequential
 */
public class PrintNumbers {

    public void printEvenNumbers() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            Thread.currentThread().wait();
            System.out.println(i);
            Thread.currentThread().notify();
        }
    }
}
