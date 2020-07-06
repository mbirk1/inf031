class Output extends Thread {

	public void run() {
		synchronized (InOut.getLock()) {
			if (!InOut.isEntered()) {
				try {
					InOut.getLock().wait();
				} catch (InterruptedException e) {
				}
			}
			System.out.println(InOut.getValue() * InOut.getValue());
		}
	}
}

class Input extends Thread {

	public void run() {
		synchronized (InOut.getLock()) {
			InOut.setValue(IO.readInt("Value: "));
			InOut.setEntered(true);
			InOut.getLock().notify();
		}
	}
}

public class InOut {

	private static Object lock = new Object();
	private static boolean entered = false;
	private static int value = 0;
	
	public static Object getLock() {
		return lock;
	}
	
	public static boolean isEntered() {
		return entered;
	}
	
	public static void setEntered(boolean entered) {
		InOut.entered = entered;
	}
	
	public static int getValue() {
		return value;
	}
	
	public static void setValue(int value) {
		InOut.value = value;
	}

	public static void main(String[] args) {
		new Output().start();
		new Input().start();
	}

}