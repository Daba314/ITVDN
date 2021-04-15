package Collection.QueueAndDeque;

public class SimpleStack {
    private int maxSize;
    private long [] stackArray;
    private int top;


    public SimpleStack(int maxSize) {
        this.maxSize = maxSize;
        this.stackArray = new long[maxSize];
        this.top = -1;

    }
    public void push(long element){

        stackArray[++top] = element;

    }

    public long pop(){
        long tmp = stackArray[top--];

        return tmp;
    }
    public long peek(){
        return stackArray[top];
    }


    public boolean isEmpty() {
        return top==-1;
    }
}

class StackTester {
    public static void main(String[] args) {
        SimpleStack simpleQueue = new SimpleStack(10);
        simpleQueue.push(1);
        simpleQueue.push(2);
        simpleQueue.push(3);
        simpleQueue.push(4);
        simpleQueue.push(5);
        simpleQueue.push(6);
        simpleQueue.pop();
        simpleQueue.peek();

        while(!simpleQueue.isEmpty()){

            System.out.println(simpleQueue.pop()+"");
        }






    }
}