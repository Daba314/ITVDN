package LambdaStream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LambdaEx {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("AAAAAAAA");
        list.add("bA");
        list.add("IWANTTOBREAKFREE");
      /*  list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()>o2.length()){
                    return 1;
                }
                else if(o1.length()<o2.length()){
                    return -1;
                }
                else return 0;
            }
        });*/
        list.sort((String o1, String o2)->{
            if(o1.length()>o2.length()){
            return 1;
        }
        else if(o1.length()<o2.length()){
            return -1;
        }
        else return 0;});
        System.out.println(list);
    }
}
