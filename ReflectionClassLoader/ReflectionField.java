package ReflectionClassLoader;

import java.lang.reflect.Field;

public class ReflectionField {

    private static final class CatFields{
        public String  name = "Marsel";
        private int age = 7;
        short ears = 30;
        protected long tail = 30;
    }
    public static void main(String[] args) {
        //just color
        String s = (char) 27 + "[31m";
        String s1 = (char) 27 + "[39m";
        String s2 = (char) 27 + "[34m";

        Class<?> cl = CatFields.class;
        System.out.println(s + "Public Reflection fields:");
        Field[] fields = cl.getFields();  // get fields return only public field
        for (Field field: fields) {
            Class<?> fieldType = field.getType();
            System.out.println(s2 + "\tName:" + s1 + field.getName());
            System.out.println(s2 + "\tType:" + s1 + fieldType.getName());
        }
        System.out.println(s + "All Modifies Reflection fields:");
        fields = cl.getDeclaredFields();
        for (Field field:
             fields) {
            Class<?> fieldType = field.getType();
            System.out.println(s2 + "\tName:" + s1 + field.getName());
            System.out.println(s2 + "\tType:" + s1 + fieldType.getName());
        }
    }
}
