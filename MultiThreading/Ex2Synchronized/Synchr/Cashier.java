package MultiThreading.Ex2Synchronized.Synchr;



public class Cashier extends Thread {
     int id;
    Ticket[] tickets;

    public Cashier(int id, Ticket[] tickets) {
        this.id = id;
        this.tickets = tickets;
    }
// all other Threads which are called for this method will be blocked until current thread executes
    @Override
    public synchronized void run() {
       /* for (int i = 0; i < tickets.length; i++) {
            if(!tickets[i].isBought){
                try{
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tickets[i].isBought = true;
                System.out.println("Cashier " + id +" tickets " + tickets[i].place);
            }
        }*/
        // bad architecture logic



        for (int i = 0; i < tickets.length ; i++) {

                //just this refers to the entire object
               // tickets[i].buy(new Cashier(id,tickets));
            try {
                tickets[i].buy(this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}