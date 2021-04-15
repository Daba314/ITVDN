package Collection.Set;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetEx {
    public static void main(String[] args) {
        NavigableSet<Car> cars = new TreeSet<>();
        cars.add(new Car(2000));
        cars.add(new Car(3000));
        System.out.println(cars);
        NavigableSet<Car> cars1 = cars.headSet(new Car(2000),true);
        System.out.println(cars1);
        //cars1.add(new Car(3000)); impisible since max mo more than 2000
        cars1.add(new Car(1000));
        System.out.println(cars1);
        System.out.println(cars);
        Iterator<Car> iterator = cars.iterator();
        while(iterator.hasNext()){
            Car tmp = iterator.next();
            int tmpInt = tmp.getPrice() ;
            tmpInt +=1050;
            tmp.setPrice(tmpInt);
        }
        System.out.println(cars);
    }


}
class Car implements Comparable<Car>{
    private int price;

    public Car(int price) {
        this.price = price;
    }
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "price=" + price +
                '}';
    }

    @Override
    public int compareTo(Car o) {
        return this.price - o.price;
    }
}