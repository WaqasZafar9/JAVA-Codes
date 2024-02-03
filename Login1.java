import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.bson.Document;
import org.bson.types.Binary;
import java.util.HashMap;
import java.util.Map;

public class Login1 {
    private JPanel innerPanel;
    private JLabel heading;
    private JLabel userNameLabel;
    private JTextField userName;
    private JLabel passwordLabel;
    private JPasswordField password;
    private JButton loginButton;

    private mongoConnect mongoConnection; // Assuming you have a mongoConnect instance

    public Login1() {
        initGUI();
        addListener();
        mongoConnection = new mongoConnect(); // Initialize your MongoDB connection
    }

    void initGUI() {
        // Your existing GUI initialization code...

        loginButton = new JButton("LOGIN");
        innerPanel.add(loginButton);

        // Your existing GUI setup code...
    }

    void addListener() {
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String user = "Fuzail", pswd = "123";
                String enteredPassword = String.valueOf(password.getPassword());

                if (userName.getText().equals(user) && enteredPassword.equals(pswd)) {
                    JOptionPane.showMessageDialog(null, "User Login Successfully");

                    try {
                        String path = "E:\\Programms\\Java\\ACP-Tasks\\JAVA project\\Images\\1675105387954.jpeg";

                        Map<String, Object> documentMap = new HashMap<>();
                        documentMap.put("Ide", 39096);
                        documentMap.put("name", userName.getText());
                        documentMap.put("Password", String.valueOf(password.getPassword()));
                        documentMap.put("city", "Lahore");
                        documentMap.put("Image", mongoConnection.storeImage(path));

                        // Create a document in MongoDB
                        mongoConnection.createDocument(documentMap);

                        // Read the document from MongoDB
                        Document d = mongoConnection.readDocument(39096);

                        // Fetch image from the document and display it
                        JLabel imageLabel = mongoConnection.fetchImage(d.get("Image", Binary.class));
                        JFrame f1 = new JFrame();
                        f1.setVisible(true);
                        f1.add(imageLabel);

                        // Uncomment and adapt other MongoDB operations as needed
                        // mongoConnection.deleteDocument(39096);
                        // mongoConnection.updateDocument(39091, "Fuzail Raza");

                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "User Login Failed");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Login1 user = new Login1();
        });
    }
}
