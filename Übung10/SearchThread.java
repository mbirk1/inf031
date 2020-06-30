import java.util.ArrayList;
import java.util.Scanner;

public class SearchThread extends Thread{
    private ArrayList<Integer> search;
    private int searched;
    private boolean found;
    public SearchThread(ArrayList<Integer> second, int searched) {
        search = second;
        this.searched = searched;
    }

    public void run(){
        if(search.contains(searched)){
            found = true;
        }else {
            found = false;
        }
    }
    public static void main(String[] args){
        int width= (int) (Math.random()*10);
        int[] array = new int[width];
        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();
        for(int i =0; i<array.length;i++){
            double rand=Math.round(Math.random()*10);
            array[i]=(int) rand;
        }
        for(int i=0; i<(array.length/2);i++){
             first.add(array[i]);
        }
        for(int i = array.length/2;i<array.length;i++){
            second.add(array[i]);
        }
        System.out.print("Array: ");
        for(int i = 0; i<array.length;i++){
            System.out.print(array[i]+", ");
        }
        System.out.println();
        Scanner in = new Scanner(System.in);
        System.out.println("Eingabe: ");
        int searched = in.nextInt();
        
        SearchThread search1 = new SearchThread(first, searched);
        SearchThread search2 = new SearchThread(second, searched);
        search1.start();
        search2.start();

        try{
            search1.join();
            search2.join();
        }catch (InterruptedException e){}
        System.out.println(search1.getName()+": "+search1.found);
        System.out.println(search2.getName()+": "+search2.found);

        if(search1.found==true || search2.found==true){
            System.out.println("Found: true");
        }else{
            System.out.print("Found: false");
        }
    }
}
