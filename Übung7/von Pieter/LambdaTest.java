public class LambdaTest {

   public static void main(String[] args) {
      //@SuppressWarnings("unchecked")
      //Function<Double, Double> chain = makeChain(new Function[]{inverse, id, timesTen, divideByPi});
      //AUFGABE 1 B

      // i) map x to itself
      Function<Double> id = (x) -> x;
      System.out.println(id.calculate(5.0));

      //ii) map x to inverse self:
      Function<Double> inverse = (x) -> x * -1;
      System.out.println(inverse.calculate(5.0));

      //iii) map x to x*10
      Function<Double> timesTen = (x) -> x * 10;
      System.out.println(timesTen.calculate(5.0));

      //iv) map x to x/pi
      Function<Double> divideByPi = (x) -> x / Math.PI;
      System.out.println(divideByPi.calculate(5.0));


      //AUFGABE 1 C
      Function round = (x) -> Math.round(x.doubleValue());
      System.out.println(round.calculate(5.5421235223));
      System.out.println(round.calculate(5.5421235223).getClass().toString());

      //AUFGABE 1 D
      Function testChain = (x) -> x.doubleValue();
      Number a = inverse.calculate(id.calculate(timesTen.calculate(divideByPi.calculate(5.0))));

   }
/*

   public Function makeChain(final Function[] funs, Number n) {
      Function c;
      c =(x) -> funs[];

      return c;
   }

 */
}
