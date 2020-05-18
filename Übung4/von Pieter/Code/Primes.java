import java.util.ArrayList;

public class Primes implements Sequence {

   Sequence sequence = new Naturals();
   int next = 1;
   ArrayList<Integer> primes = new ArrayList<>();

   private void incNext() {
      next++;
   }

   @Override
   public int getNext() {
      if (checkIfPrime()) {
         primes.add(next);
         incNext();
         return sequence.getNext();
      } else {
         incNext();
         sequence.getNext();
         return getNext();
      }
      /*if (checkIfPrime(next) && next != 1) {
         incNext();
         return sequence.getNext();
      } else {
         incNext();
         sequence.getNext();
         return getNext();
      }*/
   }

   private boolean checkIfPrime() {
      if (next == 1) {
         return false;
      }
      if (isDividableByPrim(next)) {
         return false;
      } else return true;
      /*
      for (int i = 2; i < number; i++) {
         if (next % i == 0) {
            return false;
         }
      }
      return true;
      */
   }

   private boolean isDividableByPrim(int next) {
      for (Integer i : primes) {
         if (next % i == 0) {
            return true;
         }
      }
      return false;
   }

   public Primes() {
   }
}