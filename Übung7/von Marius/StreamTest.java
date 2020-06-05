import java.util.stream.Stream;
public class StreamTest {
    public static void main(final String[] args){
        final Stream<Integer> naturals =  Stream.iterate(1, x->x+1);
        final Stream<Integer> integers = Stream.iterate(0, (Integer x) ->{
            if(x<=0){
                x=x*-1;
                x=x+1;
            }else{
                x=x*-1;
            }
            return x;
        });
        
        System.out.println("Naturals:" + filterAndSum(naturals));
        System.out.print("Integers:" + filterAndSum(integers));
    }

    public static int filterAndSum(Stream<Integer> stream) {
        Stream<Integer> result = stream.filter(x -> x % 2 == 0).limit(10);
        int result1 = result.mapToInt(Integer::intValue).sum();
        if (result != null) {
            return result1;
        } else {
            return 0;
        }
    }
}
