package Java_Stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Stream_Consumer {
    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1,2,3,4,5,6,7,8,9,10);


       // Consumer<Integer> con = new ConsImpl();
        Consumer<Integer> con = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
            System.out.println(integer);
            }
        };
        //Consumer<Integer> con = (Integer i)->System.out.println(i);

        values.forEach(System.out::println);
    }
}
class ConsImpl implements Consumer<Integer>{

    @Override
    public void accept(Integer integer) {
        System.out.println(integer);
    }
}