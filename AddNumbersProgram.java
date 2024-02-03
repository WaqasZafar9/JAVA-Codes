import javax.swing.*;

public class AddNumbersProgram {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Add Numbers Program");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            JTextField num1Field = new JTextField(10);
            JTextField num2Field = new JTextField(10);
            JButton addButton = new JButton("Add");
            JLabel resultLabel = new JLabel("Result: ");

            addButton.addActionListener(e -> {
                try {
                    int num1 = Integer.parseInt(num1Field.getText());
                    int num2 = Integer.parseInt(num2Field.getText());
                    int sum = num1 + num2;
                    resultLabel.setText("Result: " + sum);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input.");
                }
            });

            JPanel panel = new JPanel();
            panel.add(new JLabel("Number 1: "));
            panel.add(num1Field);
            panel.add(new JLabel("Number 2: "));
            panel.add(num2Field);
            panel.add(addButton);
            panel.add(resultLabel);

            frame.add(panel);
            frame.pack();
            frame.setVisible(true);
        });
    }
}
