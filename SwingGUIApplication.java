package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingGUIApplication {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}

class MainFrame extends JFrame {
    private JTextField textField;
    private JButton openNewFrameButton;

    public MainFrame() {
        setTitle("Main Frame");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textField = new JTextField(15);
        openNewFrameButton = new JButton(" Next ");

        setLayout(new FlowLayout());
        add(new JLabel("Enter your age:"));
        add(textField);
        add(openNewFrameButton);

        openNewFrameButton.addActionListener(e -> {
            String userInput = textField.getText();
            if (!userInput.isEmpty()) {
                SecondFrame secondFrame = new SecondFrame(userInput);
                secondFrame.setVisible(true);
            }
        });
    }
}

class SecondFrame extends JFrame {
    private JLabel label;
    private JButton funnyButton;

    public SecondFrame(String age) {
        setTitle("Second Frame");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        label = new JLabel("Your age: " + age);
        funnyButton = new JButton("Tell me can I eligible!");

        setLayout(new FlowLayout());
        add(label);
        add(funnyButton);

        funnyButton.addActionListener(e -> {
            int userAge = Integer.parseInt(age);
            String Message;

            if (userAge < 18) {
                Message = "Not eligible!";
            } else {
                Message = "YOU are eligible";
            }

            JOptionPane.showMessageDialog(this, Message, "Message", JOptionPane.INFORMATION_MESSAGE);
        });
    }
}
