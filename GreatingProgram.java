import javax.swing.*;

public class GreatingProgram {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Greeting Program");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            String name = JOptionPane.showInputDialog("Enter your name:");
            String greetingMessage = "Hello, " + name + "!";
            JOptionPane.showMessageDialog(frame, greetingMessage);
        });
    }
}
