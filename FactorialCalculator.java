import java.awt.*;
import java.awt.event.*;

class FactorialCalculator extends Frame implements ActionListener {
    TextField tf;
    Button calculateButton;
    Label titleLabel, inputLabel, resultLabel;

    FactorialCalculator() {
        titleLabel = new Label("Factorial Calculator");
        inputLabel = new Label("Enter a number:");
        resultLabel = new Label();

        tf = new TextField();
        calculateButton = new Button("Calculate Factorial");

        titleLabel.setBounds(30, 40, 200, 20);
        inputLabel.setBounds(30, 70, 150, 20);
        resultLabel.setBounds(30, 170, 200, 20);
        tf.setBounds(30, 90, 190, 30);
        calculateButton.setBounds(30, 130, 190, 30);

        add(titleLabel);
        add(inputLabel);
        add(resultLabel);
        add(tf);
        add(calculateButton);

        setSize(250, 210);
        setLayout(null);
        setVisible(true);

        calculateButton.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            int num = Integer.parseInt(tf.getText());
            resultLabel.setText("Factorial of " + num + " is " + getFactorial(num));
        }
    }

    public int getFactorial(int x) {
        int result = 1;
        for (int i = x; i > 0; --i) {
            result = result * i;
        }
        return result;
    }

    public static void main(String[] args) {
        FactorialCalculator FactorialCalculator = new FactorialCalculator();
    }
}
