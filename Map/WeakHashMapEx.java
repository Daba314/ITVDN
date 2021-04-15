package Map;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapEx {
    public static void main(String[] args) {
        Integer number = 5; //Strong Reference
        SoftReference<Integer> softReference = new SoftReference<>(number);
        number = null; // if main oject(number) equal null, garbage collector will get rid of this reference if there is no space anymore

        //weak reference
        WeakReference<Integer> weakReference = new WeakReference<>(number);
        number = null;
        //garbage collector will get rid from this reference as soon as main object(number) will be equal null

        //phantom reference
        PhantomReference<Integer> phantomReference = new PhantomReference<>(number, new ReferenceQueue<>());
        //after deleting the reference object will be accessible in the ReferenceQueue




        Map<String,String> weakHashMap = new WeakHashMap<>();
        Map<String,String> hashMap = new HashMap<>();

        String keyWeakHashMap = new String("keyWeakHashMap");
        String keyHashMap = new String("keyHashMap");

        weakHashMap.put(keyWeakHashMap,"weakHashMap");
        hashMap.put(keyHashMap,"HashMap");

        System.out.println("Before garbage collector "+weakHashMap.get("keyWeakHashMap") +" and " +hashMap.get("keyHashMap"));

        keyHashMap = null;
        keyWeakHashMap = null;
        System.gc();
        System.out.println("After garbage collector "+weakHashMap.get("keyWeakHashMap") +" and " +hashMap.get("keyHashMap"));

    }
}
