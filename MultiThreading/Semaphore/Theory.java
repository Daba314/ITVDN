package MultiThreading.Semaphore;

import java.util.concurrent.Semaphore;

public class Theory {
    public static void main(String[] args) throws InterruptedException {
        //cable's capacity is limited, we need to divide among Threads
        Semaphore semaphore = new Semaphore(3); // how many threads can sent data on this server
        semaphore.acquire(); //take 1 permit and start working with the resource
        semaphore.acquire();
        semaphore.acquire();
        System.out.println("all permits have been acquired");
        semaphore.acquire();
        System.out.println("never reach this line");
        //if 4th thread call acquire then acquire doesn't let him go(only 3 permits)
        semaphore.release(); // cal this method then we finish working with resource
        System.out.println(semaphore.availablePermits());
    }
}
