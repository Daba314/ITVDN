package Collection.QueueAndDeque;

public class SimpleQueue {
    private int maxSize;
    private long [] queueArray;
    private int front;
    private int rear;
    private int nItems;

    public SimpleQueue(int maxSize) {
        this.maxSize = maxSize;
        this.queueArray = new long[maxSize];
        this.front = 0;
        this.rear = -1;
        this.nItems = 0;
    }
    public void insert(long element){
        if(rear == maxSize - 1){
            rear = -1;
        }
        queueArray[++rear] = element;
        nItems++;
    }

    public long remove(){
        long tmp = queueArray[front++];
        if(front == maxSize){
            front = 0;
        }
        nItems--;
        return tmp;
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }
}

 class Tester{
     public static void main(String[] args) {
         SimpleQueue simpleQueue = new SimpleQueue(4);
        simpleQueue.insert(1);
         simpleQueue.insert(12);
         simpleQueue.insert(10);
         simpleQueue.insert(22);

         simpleQueue.remove();


         while(!simpleQueue.isEmpty()){
            long n = simpleQueue.remove();
             System.out.print(n + " ");
         }

     }
}
