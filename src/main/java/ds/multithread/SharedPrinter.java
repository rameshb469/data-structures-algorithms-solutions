package ds.multithread;

import java.util.concurrent.Semaphore;

import static java.lang.Thread.currentThread;

public class SharedPrinter {

    private Semaphore oddSemaphore = new Semaphore(1);
    private Semaphore evenSemaphore = new Semaphore(0);

    public void printOdd(int number){

        try {
            oddSemaphore.acquire();
        } catch (InterruptedException e) {
            currentThread().interrupt();
        }
        System.out.println("number is "+number);
        evenSemaphore.release();
    }

    public void printEven(int number){

        try {
            evenSemaphore.acquire();
        } catch (InterruptedException e) {
            currentThread().interrupt();
        }
        System.out.println("number is "+number);
        oddSemaphore.release();
    }

    public static void main(String[] args) {
        SharedPrinter printer = new SharedPrinter();
        Odd odd = new Odd(printer, 1000);
        Even even= new Even(printer, 1000);

        Thread t1= new Thread(odd);
        Thread t2 = new Thread(even);

        t1.start();
        t2.start();

    }
}

class Odd implements Runnable {

    private SharedPrinter printer;

    private int max;

    public Odd(SharedPrinter printer, int max){
        this.printer = printer;
        this.max = max;
    }


    @Override
    public void run() {
        for (int i = 1; i <= max; i++) {
            printer.printOdd(i);
        }
    }
}

class Even implements Runnable {

    private SharedPrinter printer;

    private int max;
    public Even(SharedPrinter printer, int max){
        this.printer = printer;
        this.max = max;
    }

    @Override
    public void run() {
        for (int i = 1; i <= max; i=i+2) {
            printer.printEven(i);
        }
    }
}
