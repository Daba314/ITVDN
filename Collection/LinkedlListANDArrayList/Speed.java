package Collection.LinkedlListANDArrayList;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Speed {
    public static void main(String[] args) {
        System.out.println(getTimesMsOfInsert(new ArrayList()));
        System.out.println(getTimesMsOfInsert(new LinkedList()));
    }

    private static long getTimesMsOfInsert(List list) {
        Date currentTime = new Date();
        insert10000(list);
        Date newTime = new Date();
        long msDelay = newTime.getTime() - currentTime.getTime();
        System.out.println("Time distance is " + msDelay);
        return  msDelay;
    }

    private static void insert10000(List list) {
        for (int i = 0; i <10000; i++) {
            list.add(0, new Object());
        }
    }
}
