package Collection.Set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class ExampleHashSetLinkedHashSet {
    public static void main(String[] args) {
        //the order depends on hashcode
        Set<String> set = new HashSet<>();
        //set.add(null); I can add null, however can not use method hashCode with null
        set.add("guitar");
        set.add("drum");
        set.add("piano");
        set.add("vocal");
        for(String text:set){
            System.out.println(text+" "+ text.hashCode());
        }
        System.out.println();
        //normal order as I added it
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("guitar");
        linkedHashSet.add("drum");
        linkedHashSet.add("piano");
        linkedHashSet.add("vocal");
        for(String text2:linkedHashSet){
            System.out.println(text2+" "+ text2.hashCode());
        }
    }
}
