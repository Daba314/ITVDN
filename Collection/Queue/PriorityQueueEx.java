package Collection.Queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueEx {
    public static void main(String[] args) {
        // capacity = 2 and create anonymous class which sort queue in reverse order
        Queue<Integer> queue = new PriorityQueue<>(2, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }

        });
        queue.offer(8);
        queue.offer(7);
        System.out.println(queue);
        queue.offer(1);
        queue.offer(10);
        System.out.println(queue); // на самом деле отсортировало суля по методу poll однако тут очень странно отобразило
        // method poll return and delete head element
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue);
    }
}
