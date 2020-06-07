import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {

   public static void main(String[] args) {

      //AUFGABE 2 A
      Stream<Integer> naturals = Stream.iterate(1, i -> i + 1).limit(100);
      //naturals.forEach(System.out::println);

      //AUFGABE 2 B

      Stream<Integer> integers = Stream.iterate(0, i -> i + 1)
              .filter(i -> i % 2 == 0)
              .limit(10);

      Integer result = integers.mapToInt(Integer::intValue).sum();
      System.out.println(result);
   }
}
