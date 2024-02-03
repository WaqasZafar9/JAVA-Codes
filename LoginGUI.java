import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel messageLabel;

    public LoginGUI() {
        // Set up the JFrame
        setTitle("Login Form");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Create a JPanel with a GridLayout
        JPanel panel = new JPanel(new GridLayout(3, 2));

        // Add components to the panel
        panel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        // Create a button with an ActionListener for form submission
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validateAndSubmitForm();
            }
        });
        panel.add(submitButton);

        // Create a label for displaying messages
        messageLabel = new JLabel();
        panel.add(messageLabel);

        // Add the panel to the JFrame
        add(panel);

        // Make the JFrame visible
        setVisible(true);
    }

    private void validateAndSubmitForm() {
        // Get the entered username and password
        String username = usernameField.getText();
        char[] password = passwordField.getPassword();
        String enteredPassword = new String(password);

        // Basic validation: check if both fields are filled
        if (username.isEmpty() || enteredPassword.isEmpty()) {
            messageLabel.setText("Please enter both username and password.");
        } else {
            // Perform authentication (you can replace this with your authentication logic)
            if ("waqas".equals(username) && "123".equals(enteredPassword)) {
                messageLabel.setText("Login successful!");
            } else {
                messageLabel.setText("Invalid username or password. Please try again.");
            }
        }

        // Clear the password field for security
        passwordField.setText("");
    }

    public static void main(String[] args) {
        // Run the GUI on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginGUI();
            }
        });
    }
}
