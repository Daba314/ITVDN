package MultiThreading.Ex1.ThreadInfo;

public class Main  {
    public static void main(String[] args) throws InterruptedException {
        Thread myThread = Thread.currentThread();
        System.out.println(myThread.getName());
        myThread.setName("MyThread");
        System.out.println(myThread.getName());
        //Figuring out the priory of Thread, By default for main is 5
        System.out.println(myThread.getPriority());

        //Priority from 1 ....10
        myThread.setPriority(10);
        System.out.println(myThread.getPriority());

        //Checking out if the thread is still alive
        System.out.println(myThread.isAlive());

        // It is unknown which of the Thread execute firstly
        new OtherThread().start();
        for (int i = 0; i < 500000; i++) {
            Thread.sleep(2000);
            System.out.println("i = " + i);
        }

    }
}
class OtherThread extends Thread{

    @Override
    public void run() {
        for (int j = 0; j < 4; j++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("j = " + j);
        }
    }
}
