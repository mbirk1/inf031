import java.util.concurrent.Semaphore;
class OutputThreaded extends Thread {
    static Semaphore semaphore = new Semaphore(1);
    public void run() {
        try {
            semaphore.acquire();
            System.out.println(InOut.getValue() * InOut.getValue());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }
}

class InputThreaded extends Thread {
    static Semaphore semaphore = new Semaphore(1);
    public void run() {
        try {
            semaphore.acquire();
            InOut.setValue(IO.readInt("Value: "));
            InOut.setEntered(true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }
}public class InOutThreaded {
    private static Object lock = new Object();
    private static boolean entered = false;
    private static int value = 0;
    public static boolean isEntered() {
            return entered;
        }
    public static void setEntered(boolean entered) {
            InOutThreaded.entered = entered;
        }
    public static int getValue() {
            return value;
        }
    public static void setValue(int value) {
            InOutThreaded.value = value;
        }
    public static void main(String[] args) {

        new Output().start();
        new Input().start();
    }
}

