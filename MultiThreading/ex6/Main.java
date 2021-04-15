package MultiThreading.ex6;

public class Main {
    //The whole isea about Daemon thread based on the fact that after user thread is done all Daemons is done too
    public static void main(String[] args) {
        Daemon daemon1 = new Daemon();
        Daemon daemon2 = new Daemon();
        daemon1.setDaemon(true);
        //daemon2.setDaemon(true); u will see nothing
        daemon1.start();
        daemon2.start();
    }
}
class Daemon extends Thread{
    @Override
    public void run(){
        try{
            if(isDaemon()){
                System.out.println("start daemon thread");
                sleep(1000);
            }
            else {
                System.out.println("Start simple Thread");
                //sleep(10); finally will work only for user thread
                sleep(1000);// works fine because Thread Daemon finished later then simple thread
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if(!isDaemon()){
                System.out.println("Simple thread is finished");
            }
            else{
                System.out.println("Daemon thread is done ");
            }
        }
    }
}
