package MultiThreading.Ex1.Threads;

public class Main {
    public static void main(String[] args) {
        EggVoice egg = new EggVoice();
        System.out.println("debate is started");
        egg.start();
        sayChicken();
        isChickenOrEgg(egg);
    }

    private static void sayChicken() {
        for (int i = 0; i < 5; i++) {
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Chicken");
        }
    }

    private static void isChickenOrEgg(EggVoice eggVoice) {
        //If opposite side did not tell last word
        if(eggVoice.isAlive()){
            try{
                //join stop the current thread until other thread finish their executions
                //waiting till opponent stop his speech
                eggVoice.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //if opponent stop his speech
            System.out.println("The first one is egg");
        }
        else {
            System.out.println("The first one is chicken");
        }
        System.out.println("Debate is done!");
    }
}
class EggVoice extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("egg");
        }
    }
}