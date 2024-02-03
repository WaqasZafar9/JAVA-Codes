import java.io.*;
import java.net.*;

public class server2 {
    public static void main(String[] args) {
        try {
            // Create a ServerSocket and bind it to port 12345
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server is listening on port 12345...");

            // Server runs indefinitely
            while (true) {
                // Accept incoming client connections
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                // Create input and output streams for communication
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                // Read student number from the client
                String studentNumber = in.readLine();
                System.out.println("Received student number: " + studentNumber);

                // Calculate grade based on the student number (simple example)
                int studentNumberInt = Integer.parseInt(studentNumber);
                String grade = calculateGrade(studentNumberInt);

                // Send the calculated grade back to the client
                out.println("Grade of student " + studentNumber + ": " + grade);

                // Close the connection with the current client
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String calculateGrade(int studentNumber) {
        // Simple grading logic (you can customize this based on your requirements)
        if (studentNumber >= 90) {
            return "A";
        } else if (studentNumber >= 80) {
            return "B";
        } else if (studentNumber >= 70) {
            return "C";
        } else {
            return "F";
        }
    }
}
