package MultiThreading.Ex1.TwoWays.thread;

public class Main extends Thread{
    private String word;
    private int delay;

    private Main(String word, int delay){
        this.word = word;
        this.delay = delay;
    }
    @Override
    public void run(){
        for( ; ;){
            System.out.print(word + " ");
            try{
                sleep(delay);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        Main ping = new Main("ping", 33);
        Main pong = new Main("pong", 100);
        ping.start();
        pong.start();
    }

}
