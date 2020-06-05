public class LambdaTest {
    public static void main(String[] args){
        Function id = (i)-> {
            double result = Double.valueOf((Double) i);
            return i;
        };
        Function inverse = (inv) ->{
            double result = Double.valueOf((Double) inv)*-1;
            return result;
        };
        Function timesTen= (times)->{
            double result = Double.valueOf((Double) times)*10;
            return result;
        };
        Function divideByPi= (divide)-> {
            double result = Double.valueOf((Double) divide)/Math.PI;
            return result;
        };
        Function round = (i)-> {
            long result = Math.round((Double) i);
            return result;
        };

        /*Function <Double , Double > chain = makeChain(new Function [] { inverse , id ,
                timesTen , divideByPi });
        double tmp = 5.5;
        chain.calculate(tmp);
        System.out.print(chain);

         */
    }

  /*  public static Function<Double, Double> makeChain(final Function<Double, Double>[] funs){
        Function c = (double i)->{

        };
        return c;
    }
*/
}
interface Function<N extends Number, D extends Number> {
    N calculate(N n);
}

