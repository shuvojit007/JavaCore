package Java_Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//Link : http://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/

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

            //===================================

        Arrays.stream(new int[] {1, 2, 3})
                .map(n -> 2 * n + 1)
                .average()
                .ifPresent(System.out::println);

        //===================
/*        Sometimes it's useful to transform a regular object stream to a primitive stream or vice versa.
        For that purpose object streams support the special mapping operations mapToInt(), mapToLong() and mapToDouble:*/
        Stream.of("a1", "a2", "a3")
                .map(s -> s.substring(1))
                .mapToInt(Integer::parseInt)
                .max()
                .ifPresent(System.out::println);
    }
}
