import java.io.*;
import java.net.*;

public class client2 {
    public static void main(String[] args) {
        try {
            // Connect to the server running on localhost and port 12345
            Socket socket = new Socket("localhost", 12345);

            // Create input and output streams for communication
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Simulate user input (you can replace this with actual user input)
            String studentNumber = "85";

            // Send the student number to the server
            out.println(studentNumber);

            // Receive the calculated grade from the server
            String calculatedGrade = in.readLine();
            System.out.println("Received grade from server: " + calculatedGrade);

            // Close the connection with the server
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
