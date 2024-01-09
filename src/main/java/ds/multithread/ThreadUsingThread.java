package ds.multithread;

import algorithms.Singleton;

public class ThreadUsingThread extends Thread {

    public void run(){
        currentThread().interrupt();
        System.out.println("Called run method"+currentThread().getName());
    }

    public static void main(String[] args) {

        synchronized (Singleton.class){
            currentThread().setName("Test");
            Thread t1 = new ThreadUsingThread();
            t1.setPriority(MAX_PRIORITY);
            t1.start();
            System.out.println("Called inside main method"+currentThread().getName());
        }
    }
}
