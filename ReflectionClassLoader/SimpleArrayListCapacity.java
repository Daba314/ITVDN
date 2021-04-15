package ReflectionClassLoader;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class SimpleArrayListCapacity {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Integer> arrayList = new ArrayList<>();
        System.out.println(getCapacity(arrayList));
        arrayList.add(1);
        System.out.println(getCapacity(arrayList));
        //if remove will be 10 anyway

    }
    public static int getCapacity(ArrayList<?> arr) throws NoSuchFieldException, IllegalAccessException {
        Field dataField = ArrayList.class.getDeclaredField("elementData");
        dataField.setAccessible(true);
        return ((Object[])dataField.get(arr)).length;
    }
}
