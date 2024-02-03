import java.io.*;
import java.net.Socket;

public class client {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 4999);

            PrintWriter pr = new PrintWriter(s.getOutputStream());
            pr.println("is it working");
            pr.flush();

            InputStreamReader in = new InputStreamReader(s.getInputStream());
            BufferedReader bf = new BufferedReader(in);
            String str = bf.readLine();
            System.out.println("Server: " + str);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
