package ReflectionClassLoader;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionMethods {
    private static final class CatFields{
        public String  name = "Marsel";
        private int age = 7;
        short ears = 30;
        protected long tail = 30;
        public CatFields(){}

        public CatFields(int age) {
            this.age = age;
        }

        public CatFields(String name, int age, short ears, long tail) {
            this.name = name;
            this.age = age;
            this.ears = ears;
            this.tail = tail;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public short getEars() {
            return ears;
        }

        public void setEars(short ears) {
            this.ears = ears;
        }

        public long getTail() {
            return tail;
        }

        public void setTail(long tail) {
            this.tail = tail;
        }
    }
    public static void main(String[] args) {
        //just color
        String s = (char) 27 + "[31m";
        String s1 = (char) 27 + "[39m";
        String s2 = (char) 27 + "[34m";

        Class<?> cl = CatFields.class;
        System.out.println(s + "Constructors:" + s1);
        //get constructors array
        Constructor<?> [] constructors = cl.getConstructors();
        int i = 0;
        for(Constructor<?> ctr: constructors ){
            //print parameters type of each constructors
            System.out.print(s + "\tConstructor" + (++i) + ":");
            Class<?>[] paramTypes = ctr.getParameterTypes();
            for(Class<?> paramType: paramTypes){
                System.out.print(s1 + paramType.getName() + " ");
            }
            System.out.println();
        }
        try{
            Class<?>[] paramTypes = new Class<?>[]{
                    int.class
            };
            Constructor<?> ctr = cl.getConstructor(paramTypes); // access to constructor with one parameter int
            CatFields cf = (CatFields) ctr.newInstance(Integer.valueOf(1)); // create new object instance of CatField
            System.out.println(s + "Field: " + s1 + "Age - " + cf.getAge() + " ,Name - " + cf.getName() +" ,Ears - " + cf.getEars() + " , Tail - " + cf.getTail());


        } catch (Exception e) {
            e.printStackTrace();
        }
        Method [] methods = cl.getMethods();
        for(Method method:methods){
            System.out.println(s + "Name:" + s2 + method.getName());
            System.out.println(s + "\tReturn type:" + s1 + method.getReturnType().getName());
            Class<?>[] paramTypes = method.getParameterTypes();
            System.out.println(s + "\tParam types:" + s1);
            for(Class<?> paramType:paramTypes){
                System.out.println(" " + paramType.getName());
            }
            System.out.println();
        }
        try{
            CatFields cf = new CatFields();
            Class<?>[] paramTypes = new Class[]{int.class};
            Method method = cl.getMethod("setAge", paramTypes);
            Object [] objArguments = new Object[]{Integer.valueOf(8)};
            //method invoke takes two parameters : 1st param  - object which class inherit or  announced  this method;
            //2nd is param array , which are transmitted to calling method
            method.invoke(cf,objArguments);
            System.out.println(s + "Age: " + s1 + cf.getAge());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try{
            //did wrong on purpose just to demonstrate how catch block works
            CatFields obj = new CatFields();
            Class<?>[] paramTypes = new Class[]{String.class};
            Method method = cl.getMethod("justMethod", paramTypes);
            Object [] arguments = new Object[]{String.valueOf("Hello")};
            method.invoke(obj,arguments);
        } catch (Exception e) {
            System.out.println(e.toString());
        }


    }
}
