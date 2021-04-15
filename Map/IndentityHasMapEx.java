package Map;

import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

public class IndentityHasMapEx {
    public static void main(String[] args) {
        IdentityHashMap<Integer,String> identityHashMap = new IdentityHashMap<>();
        //it check the citation of key
        identityHashMap.put(new Integer(1), "one");
        identityHashMap.put(new Integer(11), "eleven");
        identityHashMap.put(new Integer(1), "one");
        identityHashMap.put(new Integer(22), "twenty two");
        identityHashMap.put(new Integer(11), "three");
        Set set = identityHashMap.entrySet();
        for(Object o: set){
            Map.Entry<Integer,String> m = (Map.Entry<Integer, String>) o;
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }

}
