package MultiThreading.Ex2Synchronized.WithoutSynchr;

public class Cashier extends Thread {
    private int id;
    Ticket[] tickets;

    public Cashier(int id, Ticket[] tickets) {
        this.id = id;
        this.tickets = tickets;
    }

    public void run() {
        for (int i = 0; i < tickets.length; i++) {
            if(!tickets[i].isBought){
                try{
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tickets[i].isBought = true;
                System.out.println("Cashier " + id +" tickets " + tickets[i].place);
            }
        }
    }
}
