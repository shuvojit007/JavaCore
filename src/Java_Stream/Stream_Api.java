package Java_Stream;

import java.util.Arrays;
import java.util.List;

public class Stream_Api {
    public static void main(String[] args) {
        System.out.println("Shuvojit Kar Manna");

        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
        myList
                .stream()
                .filter(s ->s.startsWith("a"))
                .map(String::toUpperCase) //use to transform
                .sorted()
                .forEach(System.out::println);
    }
}
