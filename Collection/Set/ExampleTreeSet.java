package Collection.Set;

import java.util.NavigableSet;
import java.util.TreeSet;

public class ExampleTreeSet {
    public static void main(String[] args) {
        NavigableSet<Integer> treeSet = new TreeSet();
        treeSet.add(6);
        treeSet.add(4);
        treeSet.add(8);
        treeSet.add(1);
        treeSet.add(3);
        treeSet.add(2);
        System.out.println(treeSet);
        System.out.println(treeSet.ceiling(2));

    }
}
