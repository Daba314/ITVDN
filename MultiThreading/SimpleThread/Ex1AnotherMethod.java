package MultiThreading.SimpleThread;

import java.util.ArrayList;

//1 way to create Thread
public class Ex1AnotherMethod implements Runnable {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Thread t = new Thread(new Ex1AnotherMethod());
        t.start();// implicitly call method run from functional interface Runnable

        ArrayList all = new ArrayList();
        for (int i = 0; i < 10000; i++) {
            all.add(new Object());
        }
        System.out.println("Hello");
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

}
