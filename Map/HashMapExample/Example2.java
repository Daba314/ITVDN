package Map.HashMapExample;

import java.util.HashMap;

public class Example2 {
    public static void main(String[] args) {
        Animal dog = new Animal(2000,"husky");
        Animal cat = new Animal(3010,"maykun");
        Animal bird = new Animal(1030,"parrot");

        HashMap<Animal,String> hm = new HashMap<>();
        hm.put(dog,"BARS");
        hm.put(cat,"VASKA");
        hm.put(bird,"GOSHA");

        Animal findName = new Animal(1030,"parrot");
        // It will be still equal if I change the price(equal method compare by breed, not price)

        System.out.println(hm.get(findName));

     }
}
class Animal{
    private String breed;
    private  int price;

    public Animal(int price, String breed) {

        this.price = price;
        this.breed = breed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        return breed.equals(animal.breed);
    }

    @Override
    public int hashCode() {
        return breed.hashCode();
    }

    @Override
    public String toString() {
        return "Animal{" +
                "breed='" + breed + '\'' +
                ", price=" + price +
                '}';
    }
}
