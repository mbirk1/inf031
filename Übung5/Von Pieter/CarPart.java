public class CarPart implements CarComponent {
   String name;
   double price;

   @Override
   public String getName() {
      return null;
   }

   public double getPrice() {
      return price;
   }

   public static class Seat extends CarPart {
      String name = new String("Seat");
      double price = 2000.0;

      @Override
      public String getName() {
         return name;
      }

      public double getPrice() {
         return price;
      }
   }

   public static class Wheel extends CarPart {
      String name = new String("Wheel");

      double price = 1000.0;

      @Override
      public String getName() {
         return name;
      }

      public double getPrice() {
         return price;
      }
   }

   public static class Motor extends CarPart {
      String name = new String("Motor");

      double price = 100000;

      @Override
      public String getName() {
         return name;
      }

      public double getPrice() {
         return price;
      }
   }
}
