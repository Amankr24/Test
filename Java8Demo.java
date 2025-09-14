package Java8Stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Java8Demo {
    public static void main(String[] args) {
        //stream

        // Java 8 ---minimal code, functional programming

        //lambda expression

        //predicate interface - Functional interface (boolean valued functioN)
        Predicate<Integer> isEvem = x -> x%2==0;
        System.out.println(isEvem.test(4));

        Predicate<String> isWordStartWithA = x ->x.toLowerCase().startsWith("A");
        System.out.println(isWordStartWithA.test("Ankit"));

        Predicate<String> isWordStartWithT = x ->x.toLowerCase().endsWith("T");
        Predicate<String> and = isWordStartWithA.and(isWordStartWithT);

        System.out.println(isWordStartWithA.test("Ankit"));

        //Function -> work for you
        Function<Integer,Integer> doubleIt = x-> 2*x;
        Function<Integer,Integer> tripleIt = x-> 3*x;
        System.out.println(doubleIt.apply(100));

        System.out.println(doubleIt.andThen(tripleIt).apply(20));
        System.out.println(tripleIt.andThen(doubleIt).apply(20));
        System.out.println(doubleIt.compose(tripleIt).apply(20));

        Function<Integer,Integer> identity = Function.identity();
        Integer res2 = identity.apply(5);
        System.out.println(res2);

        //consumer
        Consumer<Integer> consumer = x-> System.out.println(x);
        consumer.accept(3);
        List<Integer> list = Arrays.asList(1,2,3,4);

        //supplier
        Supplier<String> giveHello = () -> "Hello";
        System.out.println(giveHello.get());


        //combined example


        //Method reference -- > use method without invoking and in place of lambda expression
        List<String> students = Arrays.asList("Ram","Shynam","Ghan");
        students.forEach(x-> System.out.println(x));
        students.forEach(System.out::println);

        //constructor reference
        List<String> names =Arrays.asList("a","b","c");
        List<MobilePhone> mobilePhonesList = names.stream().map(MobilePhone::new).collect(Collectors.toList());

    }


}
class MobilePhone{
    String name;

    public MobilePhone(String name){
        this.name=name;
    }
}