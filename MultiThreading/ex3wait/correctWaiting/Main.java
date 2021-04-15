package MultiThreading.ex3wait.correctWaiting;

public class Main {
    public static void main(String[] args) {
        Product p = new Product();
        Producer pc = new Producer(p,4);
        Consumer c = new Consumer(p,4);
        pc.start();
        c.start();
    }
}
class Product{
    int id;
    boolean isProduced;

    synchronized void getIdProduct(){
        //if the product is not ready(isProduced == false) when consumer does nothing
        if(!isProduced){
            try{
                wait();
            }
            catch(InterruptedException e){
                System.out.println(e);
            }
        }
        System.out.println("Get" + this.id);
        isProduced = false;
        //method notify ceases to block another Thread, which is in setIdProduct
        notify();
    }
    synchronized void setIdProduct(int id){
        //if the product is ready then the producer does nothing
        if(isProduced){
            try{
                wait();
            }
            catch (InterruptedException e){
                System.out.println(e);
            }
        }
        this.id = id;
        System.out.println("Set" + this.id);
        isProduced = true;
        //revive the Thread from getIdProduct
        notify();
    }

}
class Producer extends Thread{
    Product p;
    int count;

    Producer(Product p, int count){
        this.p = p;
        this.count = count;
    }

    @Override
    public void run(){
        for (int i = 1; i < count + 1; i++) {
            p.setIdProduct(i);
        }
    }

}
class Consumer extends Thread{
    Product p;
    int count;

    Consumer(Product p, int count) {
        this.p = p;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 1; i < count + 1; i++) {
            p.getIdProduct();
        }
     }
}
