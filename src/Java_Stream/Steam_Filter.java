package Java_Stream;

import java.util.Arrays;
import java.util.List;

public class Steam_Filter {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Peter", "Sam", "Greg", "Ryan");


        for (String name : names) {
            if (!name.equals("Sam")) {
                System.out.println(name);
            }
        }

        System.out.println("Functional Style: ");

        names.stream()
                .filter(Steam_Filter::isNotSam)
                .forEach(System.out::println);


    }

    private static boolean isNotSam(String name) {
        return !name.equals("Sam");
    }
}
