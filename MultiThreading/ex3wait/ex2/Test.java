package MultiThreading.ex3wait.ex2;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        WaitOrNotify wn = new WaitOrNotify();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

    }
}
class WaitOrNotify{
    public void produce() throws InterruptedException {
        synchronized (this){
            System.out.println("Producer thread started");
            wait(); //1 -give intrinsic lock, 2-
            //method wait and notify might be used only in synchronized block or method
            System.out.println("Producer thread resumed");
        }

    }
    public void consume() throws InterruptedException {
        Thread.sleep(2000);// to make produce start firstly
        Scanner scanner = new Scanner(System.in);
        synchronized (this){
            System.out.println("waiting for return key pressed");
            scanner.nextLine();
            notify();
            Thread.sleep(3000); // to show that notify doesn't finish this thread immediately
            // second thread will start after current thread finish
        }

    }

}
