import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class calculator implements ActionListener {
    private JTextField textfield;
    private JButton[] numberButtons;
    private JButton[] functionButtons;
    private JButton addButton, subButton, mulButton, divButton;
    private JButton decButton, equButton, delButton, clrButton;
    private JPanel panel;
    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    public calculator() {
        // Create the main JFrame
        JFrame frame = new JFrame("Calculator");
        frame.setSize(400, 390);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize and configure the textfield
        textfield = new JTextField();
        textfield.setHorizontalAlignment(JTextField.RIGHT);
        textfield.setEditable(false);
        textfield.setFont(new Font("Arial", Font.PLAIN, 24));

        // Initialize the main panel with BorderLayout
        panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add the textfield to the top of the main panel
        panel.add(BorderLayout.NORTH, textfield);

        // Create the buttonPanel with GridLayout
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 9, 9));

        // Create and configure operator buttons
        addButton = createButton("+");
        subButton = createButton("-");
        mulButton = createButton("*");
        divButton = createButton("/");

        // Create and configure number buttons
        numberButtons = new JButton[10];
        for (int i = 1; i <= 9; i++) {
            numberButtons[i] = createButton(String.valueOf(i));
        }
        numberButtons[0] = createButton("0");

        // Create and configure other buttons
        decButton = createButton(".");
        equButton = createButton("=");
        delButton = createButton("Del");
        clrButton = createButton("Cl");

        // Order of functionButtons array corresponds to the layout of buttonPanel
        functionButtons = new JButton[]{addButton, subButton, mulButton, divButton,
                                        delButton, numberButtons[7], numberButtons[8], numberButtons[9],
                                        numberButtons[4], clrButton, numberButtons[5], numberButtons[6],
                                        numberButtons[1], numberButtons[2], equButton, numberButtons[3]};

        // Add all buttons to the buttonPanel
        for (JButton button : functionButtons) {
            buttonPanel.add(button);
        }

        // Add special buttons to the buttonPanel
        buttonPanel.add(decButton);
        buttonPanel.add(numberButtons[0]);

        // Add the buttonPanel to the center of the main panel
        panel.add(BorderLayout.CENTER, buttonPanel);

        // Add the main panel to the content pane of the frame
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    // Helper method to create a button with common configurations
    private JButton createButton(String label) {
        JButton button = new JButton(label);
        button.addActionListener(this);
        button.setFocusable(false);
        button.setFont(new Font("Arial", Font.PLAIN, 18));
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new calculator());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            textfield.setText(textfield.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textfield.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clrButton) {
            textfield.setText("");
        }
        if (e.getSource() == delButton) {
            String string = textfield.getText();
            textfield.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textfield.setText(textfield.getText() + string.charAt(i));
            }
        }
    }
}
