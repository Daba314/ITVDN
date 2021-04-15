package MultiThreading.Ex2Synchronized.Synchronizeex3;

public class Main {
    public int counter;
    public static void main(String[] args) throws InterruptedException {
        Main main = new Main();
        main.doWork();
    }
    //we need object in the case of using synchronize(here for ex. synchronized(this))
    public synchronized void  increament() {
        counter++;
    }
    public void doWork() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                   increament();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    increament();
                }
            }
        });
        thread1.start();  // 1
        thread2.start(); // 2
        thread1.join();// stop the current thread( main) and finish thread1
        thread2.join(); // stop the current thread( main) and finish thread2
        //with just join the result might not be equal t0 20000 due to the fact that threads are not connected at all
        System.out.println(counter); //3
        //all of three lines start working at the same moment, that's why counter might be equal to 0(This this the idea of join)
    }




}
