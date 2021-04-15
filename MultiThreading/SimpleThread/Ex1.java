package MultiThreading.SimpleThread;

import java.util.ArrayList;
//1 way to create Thread
//since class can inherit only from one class(I mean i can not extend one more class) this method is suitable for easy App
public class Ex1 extends Thread {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        //create new Thread object , which use object new Ex1()'s method run
        Thread t = new Thread(new Ex1());
        t.start();// implicitly call method run from functional interface Runnable
        //create "zaderzku"
        ArrayList<Object> all = new ArrayList<>();
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
