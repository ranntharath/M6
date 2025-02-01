
import java.util.*;
class Person{
    int id;
    String name;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


public class Test{
    public static void main(String[] args) {
        TreeSet<Integer> num = new TreeSet<>();


        num.add(1);
        num.add(3);
        num.add(2);

        System.out.println(num.lower(1));


    }
}
