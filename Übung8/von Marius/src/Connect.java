import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class Connect {
    private String url;
    private int proceeding;
    private int articel;
    private int phdthesis;
    private String input;
    public Connect(String url) {
        this.url =url;
        proceeding =0;
        articel = 0;
        phdthesis = 0;
    }
    public BufferedReader connect() throws IOException {
        URL web = new URL(url);
        BufferedReader in=null;
        StringBuilder inputLine = new StringBuilder();
        try{
            URLConnection connect = web.openConnection();
            in = new BufferedReader(new InputStreamReader(connect.getInputStream()));

        }catch(IOException e){
            e.printStackTrace();
        }finally{
            return in;
        }

    }
    public void count(BufferedReader in) throws IOException {
        ArrayList<String> tmp = new ArrayList<>();
        while((input=in.readLine())!= null){
            tmp.add(input);
        }
        for(int i = 0; i<tmp.size();i++){
            if(tmp.get(i).contains("inproceedings")){
                proceeding+=1;
            }
            if(tmp.get(i).contains("[article]")){
                articel+=1;
            }
            if(tmp.get(i).contains("[phdthesis]")){
                phdthesis+=1;
            }
        }
        System.out.print("proceeding: "+proceeding+", article: "+articel+", phdthesis: "+phdthesis);
    }

}
