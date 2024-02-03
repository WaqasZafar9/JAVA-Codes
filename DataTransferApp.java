import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DataTransferApp extends JFrame {
    private JPanel panel1;
    private JPanel panel2;
    private JTextField dataField;

    public DataTransferApp() {
       
        setTitle("Data Transfer Application");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       
        dataField = new JTextField(20);
        JButton transferButton = new JButton("Transfer Data");
        panel1 = new JPanel();
        panel2 = new JPanel();

      
        setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter Data:"));
        inputPanel.add(dataField);
        inputPanel.add(transferButton);

        // Add components to the frame
        add(inputPanel, BorderLayout.NORTH);
        add(panel1, BorderLayout.CENTER);
        add(panel2, BorderLayout.SOUTH);

        // Add action listener to the button
        transferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transferData();
            }
        });
    }

    private void transferData() {
        String data = dataField.getText();
        JLabel label = new JLabel("Transferred Data: " + data);

        // Clear existing components in panel2
        panel2.removeAll();

        // Add the new label to panel2
        panel2.add(label);

        // Refresh the UI
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DataTransferApp().setVisible(true);
            }
        });
    }
}
