package MultiThreading.Ex2Synchronized.Synchr;

public class Ticket {
    public boolean isBought;
    public int place;

    public Ticket(int place) {
        this.place = place;
    }
    //Ticket will be bought by cashier
    //synchronized means that only one thread can execute it at the same time
     synchronized void buy(Cashier c) throws InterruptedException {
        if(!isBought){
            Thread.sleep(1000);
            isBought = true;
            System.out.println("Cashier " + c.id + ", ticket " + this.place);
        }
    }
}
