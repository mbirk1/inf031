public class Main {
   public static void main(String[] args) {
      Bill bill = new Bill("Rolls Royce");

      bill.add(new CarPart.Motor());
      bill.add(new CarPart.Seat());
      bill.add(new CarPart.Wheel());
      bill.add(new CarPart.Wheel());
      bill.add(new CarPart.Wheel());
      bill.add(new CarPart.Wheel());


      System.out.println(bill.toString());

   }

}
