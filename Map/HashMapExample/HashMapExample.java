package Map.HashMapExample;


import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) throws Exception {
        String [] students = new String[]{"Daba", "Noahn", "Egor", "Tyler"};
        HashMap<String,Human> map = addNewStudent(students);
        for (Map.Entry<String,Human> pair: map.entrySet()){
            //this order is running throw the hash, that's why such order

            System.out.println(pair.getKey()+"-"+pair.getValue());
        }
    }

    private static HashMap<String, Human> addNewStudent(String[] students) {
        HashMap<String, Human> all = new HashMap<>();
        for(String s: students){
            all.put(s,new Human(s));
        }
        return all;
    }
}
class Human{
    private String name;
    public Human(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name !=null ? name.toUpperCase() : null;
    }
}