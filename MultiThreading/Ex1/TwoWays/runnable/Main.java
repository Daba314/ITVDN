package MultiThreading.Ex1.TwoWays.runnable;

public class Main implements Runnable {
    private String word;
    private int delay;
    public Main(String word, int delay){
        this.word = word;
        this.delay = delay;
    }
    @Override
    public void run(){
        for( ; ;){   //endless
            System.out.print(word + " ");
            try{
                Thread.sleep(delay);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        Main ping = new Main("ping", 33);
        Main pong = new Main("pong", 100);
        Thread t1 = new Thread(ping);
        Thread t2 = new Thread(pong);
        t1.start();
        t2.start();
    }
}
