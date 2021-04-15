package Map;

import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class EnumMapExample {
    public static void main(String[] args) {
        Map<Animal,String> enumMap = new EnumMap<Animal, String>(Animal.class);
        enumMap.put(Animal.CAT,"MYAW");
        enumMap.put(Animal.DOG,"WAW");
        enumMap.put(Animal.FROG,"KWA");

        Set set = enumMap.entrySet();
        for (Object o : set) {
            Map.Entry m = (Map.Entry) o;
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }


}
enum Animal{
    CAT,DOG,FROG
}
