import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInputForm extends JFrame {
    private JTextField userInputField;
    private JLabel displayLabel;

    public UserInputForm() {
        // Set up the JFrame
        setTitle("User Input Form");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create components
        userInputField = new JTextField(20);
        JButton displayButton = new JButton("Display Input");
        displayLabel = new JLabel("Your input will be displayed here.");

        // Set up layout
        setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter Text:"));
        inputPanel.add(userInputField);
        inputPanel.add(displayButton);

        // Add components to the frame
        add(inputPanel, BorderLayout.NORTH);
        add(displayLabel, BorderLayout.CENTER);

        // Add action listener to the button
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayUserInput();
            }
        });
    }

    private void displayUserInput() {
        String userInput = userInputField.getText();
        displayLabel.setText("Your input: " + userInput);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UserInputForm().setVisible(true);
            }
        });
    }
}

