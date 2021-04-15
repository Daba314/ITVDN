package ReflectionClassLoader;

import java.lang.reflect.Field;
import java.util.Date;

public class Access {
    private static final class Dog{
        private int age = 3;
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Class<?> cl = Dog.class;
        Dog dog = new Dog();
        Field field = cl.getDeclaredField("age");
        field.setAccessible(true); // change modifier to public (age)
        System.out.println("Private field value: " + field.getInt(dog));
        field.setInt(dog, 5);
        System.out.println("New private field value: " + field.getInt(dog));
    }
}
