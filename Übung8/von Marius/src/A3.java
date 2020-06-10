import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class A3 {
    public static void main(String[] args) throws IOException {
        String url = "https://uol.de/en/computingscience/se/publications";
        Connect connect = new Connect(url);
        BufferedReader in = null;
        in = connect.connect();
        connect.count(in);
    }
}
