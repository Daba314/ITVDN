package ReflectionClassLoader;

import java.util.Map;

public class SimpleReflection {
    public static void main(String[] args) throws ClassNotFoundException {
        //1 method
        SimpleReflection simpleReflection = new SimpleReflection();
        Class<?> cl1 = simpleReflection.getClass();

        int [] arr = new int[10];
        Class<?> cl2 = arr.getClass();

        Class<?> cl3 = "word".getClass();

        Class<?> cl4 = Integer.valueOf(5).getClass();

        System.out.println(cl1);
        System.out.println(cl2);
        System.out.println(cl3);
        System.out.println(cl4);

        //2 method

        Class<?> cll1 = SimpleReflection.class;
        Class<?> cll2 = int[].class;

        //3 method Class.forName()

        Class<?> clla1 = Class.forName("java.lang.String");
        System.out.println(clla1);

        Class<?> clla2 = Class.forName("[I");
        System.out.println(clla2);

        //4 method
        Class<?> clll1 = Integer.class.getSuperclass();
        System.out.println(clll1);

        Class<?> clll2 = Map.Entry.class.getEnclosingClass();
        System.out.println(clll2);





    }
}
