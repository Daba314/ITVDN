package MultiThreading.Latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    //There are 4 threads , three of them create new Processor and decrement latch , one is the mai thread
    public static void main(String[] args) throws InterruptedException {
        //thread safe class(dont need to use synchronized)
        CountDownLatch countDownLatch = new CountDownLatch(3);//zachelka
        //3 is the number of iteration afterwards latch will open
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            executorService.submit(new Processor(countDownLatch,i));
        }
        executorService.shutdown(); // stop submitting new tasks
        //1 version
        /*countDownLatch.await(); //main thread is waiting till latch opens(three thread are running)
        System.out.println("Latch has been opened, main thread is proceeding");*/
        System.out.println("ndndn");
        //2 version
        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            countDownLatch.countDown();
        }
    }
}
class Processor implements Runnable{
    //2nd version
    private int id;
    private CountDownLatch countDownLatch;
    public Processor(CountDownLatch countDownLatch, int id){
        this.countDownLatch = countDownLatch;
        this.id = id;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //1st version
      /*  countDownLatch.countDown(); *///decrement countdown

        //2nd version
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread with id " + id + " proceeded");
    }
}