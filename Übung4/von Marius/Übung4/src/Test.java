public class Test {
    public static void main(String args[]){
        Function chain = (Function) new SineFunction(new SquareFunction());
        double x = 12.3;
        chain.setValue(x);
        System.out.println(chain.calculate());

    }

}
