public class Zahlenfolge1 {
    public static void main(String[] args){
        Sequence1 s = new Naturals1();
        Sequence1 nature = new Naturals1();
        Sequence1 s1 = new ZapMultiples(3, nature);
        Sequence1 prime = new Primes(nature);
        System.out.print(prime.getNext());
        System.out.print(prime.getNext());

        System.out.print(prime.getNext());

        System.out.print(prime.getNext());

        System.out.print(prime.getNext());

        System.out.print(prime.getNext());

        System.out.print(prime.getNext());

        System.out.print(prime.getNext());

        System.out.print(prime.getNext());

        System.out.print(prime.getNext());




    }
}
interface Sequence1{
    public int current();
    public int getNext();
}

class Naturals1 implements Sequence1 {
    private int cur=0;
    @Override public int current(){
        return cur;
    }
    @Override public int getNext(){
        cur= cur+1;
        return cur;
    }
}
abstract class Filter implements Sequence1{
    public Filter(Sequence1 sequence) {
        Object s = sequence;
    }
}
class ZapMultiples extends Filter{
    private int cur=0;
    private int basic;
    public ZapMultiples(int base, Sequence1 sequence) {
        super(sequence);
        basic = base;
    }

    @Override public int current(){
        return cur;
    }
    @Override public int getNext(){
        cur++;
        if(cur%basic ==0){
            cur=cur+1;
            return cur;
        }else{
            return cur;
        }
    }
}

class Primes extends Filter{
    private int cur=1;
    Integer[] cut = new Integer[10];
    public Primes(Sequence1 sequence) {
        super(sequence);
        for(int i = 0; i< cut.length-1; i++) {
            cut[i] = 0;
        }
        cut[0]=2;
    }


    @Override public int current(){
        return cur;
    }
    @Override public int getNext(){
        if(cur<2){
            cur=2;
        }
        for(int i = 0; i< cut.length-1; i++) {
            if(i<0){
                if(cur>cut[i-1]){
                    cut[i]=cur;
                }
            }
        }
        for(int i = 0; i< cut.length-1; i++) {
            System.out.print(cut[i]);
        }

        cur++;
        return cur;
    }
}
