import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Barriers {

	private final static int NUMBER = 3;
	public static CyclicBarrier barrier = new CyclicBarrier(NUMBER);

	public static void main(String[] args) {
		NumberRunner[] runner = new NumberRunner[NUMBER];
		for (int i = 0; i < NUMBER; i++) {
			runner[i] = new NumberRunner(i);
		}
		for (int i = 0; i < NUMBER; i++) {
			runner[i].start();
		}
	}

}
class NumberRunner extends Thread {

	private int number;

	public NumberRunner(int n) {
		number = n;
	}
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			for(int j=0; j<10;j++){
				System.out.println("Thread " + number + ": " + i+j);
			}
			if(i%10==0){
				try {
					Barriers.barrier.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
			}

			try {
				if(Barriers.barrier.await()==3) {
					Barriers.barrier.reset();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
		}
		//in der aufgabe steht jeweils 10 ausgaben. Dürfen es auch weniger als 10 sein solange es nicht mehr als 10 sind?
	}
}
