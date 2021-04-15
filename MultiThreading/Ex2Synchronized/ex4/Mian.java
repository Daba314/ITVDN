package MultiThreading.Ex2Synchronized.ex4;



import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mian {
    public static void main(String[] args) throws InterruptedException {
        new Worker().main();
    }

}
class Worker{
    //could be any object, just in this case used parent class Object
    Object lock1 = new Object();

    Object lock2 = new Object();

    Random random = new Random();
    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    public void  addToListOne() throws InterruptedException {
        synchronized (lock1){
        Thread.sleep(1);
        list1.add(random.nextInt(100)); // random number 0 ... 99
        }
    }

    public void addToListTwo() throws InterruptedException {
        synchronized (lock2) {
            Thread.sleep(1);
            list2.add(random.nextInt(100)); // random number 0 ... 99
        }
    }
    //Not necessary to use synchronized with methods because we use two different lists and they won't cross

    public void work() throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            addToListOne();
            addToListTwo();
        }

    }
    public void main() throws InterruptedException {
        long before = System.currentTimeMillis();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    work();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    work();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        long after = System.currentTimeMillis();
        System.out.println("Program took " + (after-before) + " mls to run");
        System.out.println(list1.size());
        System.out.println(list2.size());

    }
}
