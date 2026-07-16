import java.util.ArrayList;
import java.util.ListIterator;

public class IteratorExample {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Banana");

        ListIterator<String> iterator = fruits.listIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
