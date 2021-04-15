package MultiThreading.ex4Deadlock.ex2;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Runner runner = new Runner();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                runner.doThread1();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                runner.doThread2();
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        runner.finished();

    }
}
class Runner{
    public Runner() {
        account1.setBalance(2000);
        account2.setBalance(1000);
    }

    Random random = new Random();
    private Account account1 = new Account();
    private Account account2 = new Account();

    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();



    public void doThread1(){
        locking(account1, account2);
    }

    public void doThread2(){
        locking(account2, account1);
    }


    private void locking(Account account2, Account account1) {
            lock1.lock(); //if we make this part not in the same order for both threads it will cause deadlock
            lock2.lock();
            try{

                Account.transfer(account2, account1,random.nextInt(100));
            }
            finally {
                lock1.unlock();
                lock2.unlock();
            }

    }
    public void finished(){

        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());
        System.out.println("Total balance: " + (account1.getBalance()+account2.getBalance()) );
    }


}
class Account{
    private int balance;

    public void deposit(int amount){
        balance+= amount;
    }
    public void withdraw(int amount){
        balance-= amount;
    }
    public static void transfer(Account account1, Account account2, int amount) {
        account1.withdraw(amount);
        account2.deposit(amount);
    }
    public int getBalance(){
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
