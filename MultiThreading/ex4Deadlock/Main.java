package MultiThreading.ex4Deadlock;

public class Main {
    public static void main(String[] args) {
        MyThread1 ex1 = new MyThread1();
        MyThread2 ex2 = new MyThread2();
        ex1.setThread1(ex2);
        ex2.setThread2(ex1);

        ex1.start();
        ex2.start();

    }
}
class MyThread1 extends Thread{
    private Thread t1;

    MyThread1(){
        System.out.println("MyThread1 create");
    }
    public void setThread1(Thread t){
        this.t1 = t;
    }
    @Override
    public void run(){
        System.out.println("MyThread1 start");
        try{
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MyThread1 is interrupted meanwhile MyThread2 finish");
        try{
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MyThread1 is done ");
    }

}
class MyThread2 extends  Thread{
    private Thread t2;

    MyThread2(){
        System.out.println("MyThread2 create");
    }
    public void setThread2(Thread t){
        this.t2 = t;
    }
    @Override
    public void run(){
        System.out.println("MyThread2 start");
        System.out.println("MyThread2 is interrupted meanwhile MyThread1 finish ");
        try{
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MyThread2 is done ");
    }

}
