import jdk.jshell.execution.Util;

import javax.print.DocFlavor;

public class Compare {
    public static void main(String[] args){
        Object[] objects = new Object[3];
        Comparable one = new ComparableInteger(1);
        Comparable four = new ComparableInteger(4);
        Comparable seven = new ComparableInteger(7);

        objects[0] = one;
        objects[1] = four;
        objects[2] = seven;

        Utils util = new Utils();
        Comparable getMinimum;
    }
}
interface Comparable{
    public int compareTo(Comparable obj);
    public int getValue();
    public void setValue(int i);
}

class Utils{
    public static Comparable getMinimum(Comparable[] elements){
        ComparableInteger min= new ComparableInteger(0);
        for(int i =0; i<elements.length;i++){

            if (min.getValue() > elements[i].getValue()) {
                min.setValue(i);
            }
        }
        return elements[min.getValue()];
    }

}
class Integer{
    protected int value;
    public Integer(int value){
        this.value=value;
    }
    public int getValue(){
        return value;
    }
}
class ComparableInteger implements Comparable{
    protected int value;
    public ComparableInteger(int value){
        this.value=value;
    }
    public int getValue(){
        return value;
    }

    @Override public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Comparable obj) {
        return 0;
    }
}