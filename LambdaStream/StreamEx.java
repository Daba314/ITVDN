package LambdaStream;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class StreamEx {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int[] array = new int[10];
        fillArray(array);
        fillList(list);
     /*   System.out.println(Arrays.toString(array));
        System.out.println(list)*/;
       /* for (int i = 0; i < 10; i++) {
            array[i] = array[i]*2;
            list.set(i, list.get(i)*2);
        }*/

        //map method

        array = Arrays.stream(array).map(i -> i * 2).toArray();
        list = list.stream().map(a -> a * 2).collect(Collectors.toList());
        //array = Arrays.stream(array).map(i -> 3).toArray();

        System.out.println(Arrays.toString(array));
        System.out.println(list);

        //filter method
        List<Integer> list2 = new ArrayList<>();
        int[] array2 = new int[10];

        fillArray(array2);
        fillList(list2);

        //it will filter array, and leave only numbers which meet requirement
        array2 = Arrays.stream(array2).filter(a -> a % 2 == 0).toArray();
        list2 = list2.stream().filter(a -> a % 2 == 0).collect(Collectors.toList());

        System.out.println(Arrays.toString(array2));
        System.out.println(list2);
        Arrays.stream(array2).forEach(a -> System.out.print(a + " "));
        System.out.println();
        list2.forEach(System.out::print); //or like this
        System.out.println();


        //reduce method
        List<Integer> list3 = new ArrayList<>();
        int[] array3 = new int[10];

        fillArray(array3);
        fillList(list3);

        // for ex.[1,2,3]
        //b is a current element acc is the first element in array
        //we can assign value to acc
        // for ex.  int sum = Arrays.stream(array3).reduce(0,(acc, b) -> acc + b);
        //in the case without specific acc(like 0 in example) firstly acc = 0 and b = 1
        //just like acc+= b;
        int sum1 = Arrays.stream(array3).reduce((acc, b) -> acc + b).getAsInt();
        int sum2 = list3.stream().reduce((acc, b) -> acc * b).get();

        System.out.println(sum1);
        System.out.println(sum2);

//only odd numbers(nechetnui) which are multiplied to two
        int[] array4 = new int[10];

        fillArray(array4);
        Arrays.stream(array4).filter(a -> a % 2 !=0).map(a -> a*2).forEach(System.out::print);
        System.out.println();

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(200);
        set.add(5);
        set = set.stream().map(a -> a*3).collect(Collectors.toSet());
        System.out.println(set);

    }

    private static void fillArray(int[] array) {
        for (int i = 0; i < 10; i++) {
            array[i] = i+1;
        }
    }

    private static void fillList(List<Integer> list) {
        for (int i = 0; i < 10; i++) {
            list.add(i+1);
        }
    }
}
