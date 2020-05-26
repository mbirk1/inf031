import java.util.ArrayList;

public class Bill {

   //fields

   String name;
   double billPrice = 0;
   ArrayList<BillItem> items = new ArrayList<>();

   //methods

   public void add(CarPart part) {
      items.add(new BillItem(part));
   }

   //getter - setter

   public double getTotalPrice() {
      return billPrice;
   }

   public String toString() {
      StringBuffer tempString = new StringBuffer("Receipt for Bill: ");
      double receipTotal = 0;
      tempString.append(this.name);
      tempString.append("\n");
      for (int i = 0; i < items.size(); i++) {
         tempString.append(items.get(i).item.getName());//add ItemName
         tempString.append("\t");
         tempString.append(items.get(i).item.getPrice());//add ItemPrice
         tempString.append("\n");
         receipTotal = receipTotal + items.get(i).item.getPrice();
      }
      tempString.append("\n");
      Math.nextUp(receipTotal);//doesn't work for some reason.
      tempString.append("In Total this receipt is: " + receipTotal);
      String output = tempString.toString();
      return output;
   }

   //constructors

   public Bill(String name) {
      this.name = name;
   }

   //nested classes

   private class BillItem {

      //fields

      CarPart item;

      //methods

      //getter - setter

      public CarPart getItem() {
         return item;
      }

      public void setItem(CarPart item) {
         this.item = item;
      }

      public BillItem(CarPart item) {
         this.item = item;
      }
   }

}
