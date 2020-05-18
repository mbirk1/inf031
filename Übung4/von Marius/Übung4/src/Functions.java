import java.lang.Math;
//Dieser Code läuft für das explizite Beispiel aus der Aufgabe.
public class Functions {
    public static void main(String[]  args){
        double i = 2;
        Function chain = new SineFunction(new SquareFunction());
        chain.calculate(i);
    }

}
interface Function{
    void calculate(double i);
    double  result=0;
}
class SineFunction implements Function{
    private String function =" ";
    public SineFunction(SquareFunction squareFunction) {
        if(squareFunction.getClass()== SquareFunction.class){
            function="square";
        }
        else{
            function="sine";
        }
        //Diese If Abfragen können bei beliebiger Reihenfolge der Funktionen entsprechend erweitert werden.
        //Weitere Anpassungen am Code sind dann aber noch nötig.
    }
    @Override public void calculate(double i ){
        if(function.equals("sqaure")){
            i=i*i;
        }
        i=Math.sin(i);
        System.out.println(i);
    }
}
class SquareFunction implements Function{
    @Override
    public void calculate(double i) {

    }
}


