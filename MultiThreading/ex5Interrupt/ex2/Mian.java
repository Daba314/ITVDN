package MultiThreading.ex5Interrupt.ex2;

public class Mian extends Thread {
    private int counter;
    private String word;
    private Thread thread;

    Mian(int counter, String word){
        this.counter = counter;
        this.word = word;
    }
    private void setThread(Thread thread){
        this.thread = thread;
    }
    @Override
    public  void  run(){
        //the interrupted() method is used to check whether the thread is interrupted or not.
        // But this method clears the interrupted status and returns true if the method is interrupted else false
        //Note: If the interrupted() method is called twice
        // on one thread then the second call always returns false because the first call clears the status.
        while(!interrupted()){
            //The interrupt() method of thread class is used to interrupt the thread.
            // If any thread is in sleeping or waiting state (i.e. sleep() or wait() is invoked) then using the interrupt() method,
            // we can interrupt the thread execution by throwing InterruptedException.
            //If the thread is not in the sleeping or waiting state then calling the interrupt() method performs a normal behavior
            // and doesn't interrupt the thread but sets the interrupt flag to true.
            thread.interrupt();
            for (int i = 0; i < counter; i++) {
                System.out.println(word + i);
            }
        }
    }
    public static void main(String[] args) {
        Mian th1 = new Mian(5,"Did");
        Mian th2 = new Mian(5,"Did not");
        th1.setThread(th2);
        th2.setThread(th1);
        th1.setName("Second Thread");
        th2.setName("First Thread");
        th1.start();
        th2.start();
    }
}
