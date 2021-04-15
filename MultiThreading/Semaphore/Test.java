package MultiThreading.Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(200);
        Connection connection = Connection.getConnection();
        for (int i = 0; i < 200; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        connection.work();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }
}
//singleton  (we can create only one object of this class)
class Connection{
    private static Connection connection = new Connection(); // only this object will be used
    private int connectionsCount;
    private Semaphore semaphore = new Semaphore(10);

    private Connection(){

    }
    //can not create example of class in other classes
    public static Connection getConnection(){
        return  connection;
    }
    public void work() throws InterruptedException {
        semaphore.acquire(); // restriction which let execute only 10 threads at the same time
        try{doWork();}
        finally {
            semaphore.release();
        }
    }
    private void doWork() throws InterruptedException {
        synchronized (this){
            connectionsCount++;
            System.out.println(connectionsCount);
        }
        Thread.sleep(5000);

        synchronized (this){
            connectionsCount--;
        }
    }
}

