package org.example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

import javax.swing.*;

public class ClientGUI {
    private JFrame frame;
    private JTextField textField;
    private JTextArea textArea;
    private PrintWriter pr;
    private BufferedReader bf;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ClientGUI window = new ClientGUI();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ClientGUI() {
        initialize();
        connectToServer();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));

        textArea = new JTextArea();
        frame.getContentPane().add(new JScrollPane(textArea), BorderLayout.CENTER);

        textField = new JTextField();
        frame.getContentPane().add(textField, BorderLayout.SOUTH);
        textField.setColumns(10);

        JButton btnSend = new JButton("Send");
        btnSend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                sendMessage();
            }
        });
        frame.getContentPane().add(btnSend, BorderLayout.EAST);
    }

    private void connectToServer() {
        try {
            Socket s = new Socket("localhost", 4999);
            pr = new PrintWriter(s.getOutputStream());
            bf = new BufferedReader(new InputStreamReader(s.getInputStream()));
            new Thread(() -> receiveMessages()).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage() {
        String message = textField.getText();
        pr.println(message);
        pr.flush();
        textField.setText("");
    }

    private void receiveMessages() {
        try {
            while (true) {
                String response = bf.readLine();
                textArea.append("Server: " + response + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
