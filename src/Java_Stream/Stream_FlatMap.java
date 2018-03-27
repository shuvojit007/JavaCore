package Java_Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class Stream_FlatMap {

    public static void main(String[] args) {

        List<User> users = Arrays.asList(
                new User("Peter", 20, Arrays.asList("1","5", "2")),
                new User("Sam", 40, Arrays.asList("3", "4", "5")),
                new User("Ryan", 60, Arrays.asList("6")),
                new User("Adam", 70, Arrays.asList("7", "8"))
        );


        System.out.println("Functional Style: ");

        Optional<String> stringOptional1=users.stream()
                .map(new Function<User,Stream<String>>() {
                    @Override
                    public Stream<String> apply(User user) {
                        return user.getPhoneNumbers().stream();
                    }
                })
                .flatMap(new Function<Stream<String>, Stream<String>>() {
                    @Override
                    public Stream<String> apply(Stream<String> stringStream) {
                        return stringStream.filter(phn->phn.equals("5"));
                    }
                }).findAny();
        stringOptional1.ifPresent(System.out::println);
        System.out.println("Method 2");


        Optional<String> stringOptional = users.stream()
                .map(user -> user.getPhoneNumbers().stream())
                .flatMap(stringStream -> stringStream.filter(phoneNo -> phoneNo.equals("10")))
                .findAny();

        //findAny() another Strem Api...if its find any value then its
        //stop the stream its return type optional

        stringOptional.ifPresent(System.out::println);

    }

    private static boolean isNotSam(String name) {
        return !name.equals("Sam");
    }


    static class User {
        private String name;
        private Integer age = 30;
        private List<String> phoneNumbers;

        public User(String name, Integer age, List<String> phoneNumbers) {
            this.name = name;
            this.age = age;
            this.phoneNumbers = phoneNumbers;
        }

        public List<String> getPhoneNumbers() {
            return phoneNumbers;
        }

        public void setPhoneNumbers(List<String> phoneNumbers) {
            this.phoneNumbers = phoneNumbers;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "name : " + name + " age : " + age;
        }
    }
}
