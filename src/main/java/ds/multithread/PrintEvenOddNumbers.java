package ds.multithread;

/**
 * Print Even Number using one thread and odd number in another thread
 * in sequential
 */
public class PrintEvenOddNumbers {
// Java program for the above approach

    static int N;
    // Starting counter
    int counter = 1;

    // Driver Code
    public static void main(String[] args) {
        // Given Number N
        N = 10;

        // Create an object of class
        PrintEvenOddNumbers mt = new PrintEvenOddNumbers();

        // Create thread t1
        Thread t1 = new Thread(() -> mt.printEvenNumber());
        t1.setName("Thread_1");

        // Create thread t2
        Thread t2 = new Thread(() -> mt.printOddNumber());
        t2.setName("Thread_2");

        // Start both threads
        t1.start();
        t2.start();
    }

    // Function to print odd numbers
    public void printOddNumber() {
        synchronized (this) {
            // Print number till the N
            while (counter < N) {

                // If count is even then print
                while (counter % 2 == 0) {

                    // Exception handle
                    try {
                        wait();
                    } catch (
                            InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // Print the number
                System.out.println(counter + " Thread: "+Thread.currentThread());

                // Increment counter
                counter++;

                // Notify to second thread
                notify();
            }
        }
    }

    // Function to print even numbers
    public void printEvenNumber() {
        synchronized (this) {
            // Print number till the N
            while (counter < N) {

                // If count is odd then print
                while (counter % 2 == 1) {

                    // Exception handle
                    try {
                        wait();
                    } catch (
                            InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // Print the number
                System.out.println(
                        counter + " Thread: "+Thread.currentThread());

                // Increment counter
                counter++;

                // Notify to 2nd thread
                notify();
            }
        }
    }
}

