package MultiThreading.CallableFuture;

/*import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static int count;
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(()->{   //alternative for submit(new Runnable(){public void run(){}})
            System.out.println("Started");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Finished");
            count++;
        });
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS); //like join
        System.out.println(count);
    }
}*/

import Exceptions.Throw;

import java.util.Random;
import java.util.concurrent.*;

public class Main{
    public static void main(String[] args) throws  InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        //to get access from returning we need to use interface Future
        Future<Integer> future = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("Started");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Finished");
                Random random = new Random();
                int randomValue = random.nextInt(10); // the main idea is that i can use this functional interface for returning smth
                if(randomValue<5){
                    throw new Exception("Smth bad happened");
                }
                return randomValue;
            }
        });
        executorService.shutdown();
        int result = 0;
        try {
            result = future.get();
        } catch (ExecutionException e) {
            Throwable ex = e.getCause();
            System.out.println(ex.getMessage());
        }
        System.out.println(result);
    }
}
