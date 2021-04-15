package ThreadsEX;

import java.util.Scanner;
//in this case MyThread thread read it (while (running)), and main writes down variable(running)
// because  this thread changes  variable running inside the  method shutdown
public class KeyWordVolatile {
    public static void main(String[] args) {
        MyTHread myThread = new MyTHread();
        myThread.start();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();// start when i press enter

        myThread.shutdown();
    }
}
class MyTHread extends Thread{
   // private boolean running = true; //There is possibility that this code might not work( cash concurrence)
   private volatile boolean  running = true; // guarantee non-existence of cash concurrence;
    //necessary use in the case if one thread write down the variable and others read it 
    public void run(){
        while(running){
            System.out.println("Hello");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void shutdown(){
        this.running = false;
    }
}
