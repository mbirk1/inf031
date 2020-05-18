public class Naturals implements Sequence {
   int current = 0;

   @Override
   public int getNext() {
      current++;
      return current;
   }
}