package MultiThreading.ex8PoolThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2); // create two Threads
        //2 threads will concurrently do(in parallel) this task
        for (int i = 0; i < 5; i++) {
            executorService.submit(new Worker(i)); //give 5 tasks
        }
        executorService.shutdown(); // no more tasks start working with 5 tasks  like start()
        System.out.println("All tasks are submitted");
        // Blocks until all tasks have completed execution after a shutdown
        //     * request, or the timeout occurs, or the current thread is
        //     * interrupted, whichever happens first
        executorService.awaitTermination(1, TimeUnit.DAYS);  // like join();
    }
}
class Worker implements Runnable{
    private int id;
    Worker(int id){
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Work " + id + " is completed");
    }
}
