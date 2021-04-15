package ThreadsEX;
//threads are not synchronised
public class Main {
    public static void main(String[] args) throws InterruptedException {
  /*      MyThread myThread = new MyThread();
        myThread.start(); // notice that min sout start firstly
        MyThread myThread1 = new MyThread();
        myThread1.start();
        System.out.println("hello from main thread");
        //just chaos*/


        /*System.out.println("I am going to sleep");
        Thread.sleep(2000); //timer
        System.out.println("I am awake");*/

        Thread thread = new Thread(new Runner());
        thread.start();
    }
}
//second method
class Runner implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hello from MyThread " + i);
        }
    }
}
    //first method to create a thread
    class MyThread extends Thread {
        public void run() {
            for (int i = 0; i < 1000; i++) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("hello from MyThread " + i);
            }
        }
    }

