package MultiThreading.ex5Interrupt.bestEx;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                for (int i = 0; i < 100000; i++) {
                    if(Thread.currentThread().isInterrupted()){ //without this block just will show exception
                        System.out.println("Thread was interrupted");
                        break;
                    }
                    Math.sin(random.nextDouble());
                }
            }
        });
        System.out.println("Starting thread");
        thread.start();
        thread.interrupt(); // must be order like this
        thread.join();
        System.out.println("Thread is finished");
    }
}
