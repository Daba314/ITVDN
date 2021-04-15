package Collection.ArrayDequeEx;


import java.util.ArrayDeque;

public class ArrayDequeEx {
    public static void main(String[] args) {
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.add("Russia");
        queue.add("Canada");

        // add element at the start
        queue.push("zopa");

        // get element without deletion
        String sFirst = queue.getFirst();
        String sLast = queue.getLast();

        // this loop will return and delete all elements in deque until it get rid from all elements
        while(queue.peek()!=null){
            // removes and returns the first element of this deque
            System.out.println(queue.pop());
        }
        System.out.println(queue.size());

        ArrayDeque<Person> personArrayDeque = new ArrayDeque<>();
        personArrayDeque.addFirst(new Person("Gabriel"));
        personArrayDeque.addLast(new Person("Leo"));
        for (Person person: personArrayDeque){
            System.out.println(person.getName());
        }


    }
}
class Person{
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}