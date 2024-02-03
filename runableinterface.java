import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentFormGUI extends JFrame {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USERNAME = "your_username";
    private static final String PASSWORD = "your_password";

    private JTextField nameTextField;
    private JTextField sapIdTextField;
    private JTextField phoneTextField;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;

    public StudentFormGUI() {
        // Set up the JFrame
        super("Student Information Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLayout(new GridLayout(6, 2));

        // Create form components
        JLabel nameLabel = new JLabel("Name:");
        nameTextField = new JTextField();

        JLabel sapIdLabel = new JLabel("SAP ID:");
        sapIdTextField = new JTextField();

        JLabel phoneLabel = new JLabel("Phone Number:");
        phoneTextField = new JTextField();

        JLabel genderLabel = new JLabel("Gender:");
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitForm();
            }
        });

        // Add components to the frame
        add(nameLabel);
        add(nameTextField);
        add(sapIdLabel);
        add(sapIdTextField);
        add(phoneLabel);
        add(phoneTextField);
        add(genderLabel);
        add(maleRadioButton);
        add(new JLabel()); // Empty cell to align radio buttons
        add(femaleRadioButton);
        add(submitButton);

        // Display the frame
        setVisible(true);
    }

    private void submitForm() {
        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // Insert data into the "student" table
            insertStudent(connection, nameTextField.getText(), sapIdTextField.getText(),
                    phoneTextField.getText(), maleRadioButton.isSelected() ? "Male" : "Female");

            // Close the database connection
            connection.close();

            // Show a success message
            JOptionPane.showMessageDialog(this, "Student information added successfully!");

            // Clear the form fields
            nameTextField.setText("");
            sapIdTextField.setText("");
            phoneTextField.setText("");
            maleRadioButton.setSelected(false);
            femaleRadioButton.setSelected(false);

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error adding student information. Please try again.");
        }
    }

    private void insertStudent(Connection connection, String name, String sapId, String phoneNumber, String gender) throws SQLException {
        String insertQuery = "INSERT INTO student (name, sapid, phone_number, gender) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, sapId);
            preparedStatement.setString(3, phoneNumber);
            preparedStatement.setString(4, gender);
            preparedStatement.executeUpdate();
        }
    }

    public static void main(String[] args) {
        // Ensure that the Swing components are created on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StudentFormGUI();
            }
        });
    }
}