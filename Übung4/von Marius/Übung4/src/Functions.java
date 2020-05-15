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
    private boolean square=true;
    public SineFunction(SquareFunction squareFunction) {
        if(squareFunction.){
            square=true;
        }
        else{
            square=false;
        }
    }
    @Override public void calculate(double i ){

    }
}
class SquareFunction implements Function{


    @Override
    public void calculate(double i) {

    }
}


