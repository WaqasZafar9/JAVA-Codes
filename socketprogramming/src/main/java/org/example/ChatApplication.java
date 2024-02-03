package org.example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.*;

public class ChatApplication {
    private JFrame clientFrame;
    private JTextField clientTextField;
    private JTextArea clientTextArea;
    private PrintWriter clientPrintWriter;
    private BufferedReader clientBufferedReader;

    private JFrame serverFrame;
    private JTextArea serverTextArea;
    private PrintWriter serverPrintWriter;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ChatApplication window = new ChatApplication();
                window.clientFrame.setVisible(true);
                window.serverFrame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ChatApplication() {
        initializeClient();
        initializeServer();
        connectToServer();
    }

    private void initializeClient() {
        clientFrame = new JFrame();
        clientFrame.setBounds(100, 100, 450, 300);
        clientFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        clientFrame.getContentPane().setLayout(new BorderLayout(0, 0));

        clientTextArea = new JTextArea();
        clientFrame.getContentPane().add(new JScrollPane(clientTextArea), BorderLayout.CENTER);

        clientTextField = new JTextField();
        clientFrame.getContentPane().add(clientTextField, BorderLayout.SOUTH);
        clientTextField.setColumns(10);

        JButton btnSend = new JButton("Send");
        btnSend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                sendMessage(clientPrintWriter, clientTextField.getText(), "Client");
            }
        });
        clientFrame.getContentPane().add(btnSend, BorderLayout.EAST);
    }

    private void initializeServer() {
        serverFrame = new JFrame();
        serverFrame.setBounds(550, 100, 450, 300);
        serverFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        serverFrame.getContentPane().setLayout(new BorderLayout(0, 0));

        serverTextArea = new JTextArea();
        serverFrame.getContentPane().add(new JScrollPane(serverTextArea), BorderLayout.CENTER);
    }

    private void connectToServer() {
        try {
            // Server setup
            ServerSocket ss = new ServerSocket(4999);
            Socket s = ss.accept();
            serverPrintWriter = new PrintWriter(s.getOutputStream());
            new Thread(() -> receiveMessages(serverTextArea, s)).start();

            // Client setup
            Socket clientSocket = new Socket("localhost", 4999);
            clientPrintWriter = new PrintWriter(clientSocket.getOutputStream());
            clientBufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            new Thread(() -> receiveMessages(clientTextArea, clientSocket)).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage(PrintWriter printWriter, String message, String source) {
        printWriter.println(message);
        printWriter.flush();
        appendMessage(source + ": " + message, source.equals("Client") ? clientTextArea : serverTextArea);
        clientTextField.setText("");
    }

    private void receiveMessages(JTextArea textArea, Socket socket) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                String message = bufferedReader.readLine();
                appendMessage("Server: " + message, textArea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void appendMessage(String message, JTextArea textArea) {
        SwingUtilities.invokeLater(() -> {
            textArea.append(message + "\n");
        });
    }
}
