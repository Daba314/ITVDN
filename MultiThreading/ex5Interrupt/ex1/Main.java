package MultiThreading.ex5Interrupt.ex1;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        counter.start();
        Thread.sleep(3000);
        counter.interrupt();
    }
}
class Counter extends Thread{
    @Override
    public void run(){
        int i = 0;
        //Tests whether this thread has been interrupted. Thread will be still interrupted. method run is interrupted
        while(!isInterrupted()){
            System.out.println("i=" + i++);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
               break;
            }
        }

    }
}
