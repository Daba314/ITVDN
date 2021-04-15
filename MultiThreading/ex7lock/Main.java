package MultiThreading.ex7lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        SimpleCounterThread[] counterThread = new SimpleCounterThread[10];
        fillingArrayOfCounterThreads(counter, counterThread);
        startingThreads(counterThread);
        joinThreads(counterThread);
        System.out.println(counter.getCounter());
    }

    private static void joinThreads(SimpleCounterThread[] counterThread) throws InterruptedException {
        for (SimpleCounterThread simpleCounterThread : counterThread) {
            simpleCounterThread.join();
        }
    }

    private static void startingThreads(SimpleCounterThread[] counterThread) {
        for (SimpleCounterThread simpleCounterThread : counterThread) {
            simpleCounterThread.start();
        }
    }

    private static void fillingArrayOfCounterThreads(Counter counter, SimpleCounterThread[] counterThread) {
        for (int i = 0; i < 10; i++) {
            counterThread[i] = new SimpleCounterThread(counter,1000); //1000*10
        }
    }
}
class Counter{
    private long counter = 0;
    private Lock reentrantLock = new ReentrantLock();

    public void incrementCurrentValue(){
        reentrantLock.lock();
        try{counter++;}
        finally {
            reentrantLock.unlock();
        }
    }
    public long getCounter(){
        return counter;
    }
}
class SimpleCounterThread extends Thread{
    private Counter counter;
    private int number;
    public SimpleCounterThread(Counter counter, int number) {
        this.counter = counter;
        this.number = number;
    }
    @Override
    public void run(){
        for (int i = 0; i < number; i++) {
            counter.incrementCurrentValue();
        }
    }
}