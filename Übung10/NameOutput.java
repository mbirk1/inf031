import javax.swing.*;
import java.io.ObjectOutputStream;

public class NameOutput extends Thread {
    private String name;
    private int len;

    public static void main(String[] args) throws InterruptedException {
        int random = 3;
        Thread[] arr = new Thread[random];
        String[] names = new String[random];
        int len = arr.length;

        for(int i =0;i<arr.length;i++){
            arr[i] = new Thread(new NameOutput());
        }
        for(int i =0; i<arr.length;i++){
            names[i] = arr[i].getName();
        }

        while (true) {
            synchronized (NameOutput.class) {


            }
        }
    }
//wait und notify sollen besser sein

    public void run() {
        while(true){
            System.out.println(this.getName());
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


