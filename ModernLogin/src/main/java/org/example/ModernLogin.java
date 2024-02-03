package org.example;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModernLogin extends JFrame implements ActionListener {
    JPasswordField password;
    JTextField username;
    JLabel label_password, label_username, message, title;
    JButton btn, resetBtn;
    JCheckBox showPassword;

    ModernLogin() {


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setTitle("Modern Login Form");
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        label_username = new JLabel("Username");
        label_username.setForeground(Color.WHITE);
        username = new JTextField();
        username.setBackground(new Color(65, 105, 225));
        username.setForeground(Color.WHITE);

        label_password = new JLabel("Password");
        label_password.setForeground(Color.WHITE);
        password = new JPasswordField();
        password.setBackground(new Color(65, 105, 225));
        password.setForeground(Color.WHITE);

        showPassword = new JCheckBox("Show Password");
        showPassword.setForeground(Color.WHITE);
        showPassword.setBackground(new Color(65, 105, 225));
        showPassword.addActionListener(this);

        btn = new JButton("Sign In");
        btn.addActionListener(this);
        btn.setBackground(new Color(50, 205, 50));
        btn.setForeground(Color.WHITE);

        resetBtn = new JButton("RESET");
        resetBtn.addActionListener(this);
        resetBtn.setBackground(new Color(255, 69, 0));
        resetBtn.setForeground(Color.WHITE);

        formPanel.add(label_username);
        formPanel.add(username);
        formPanel.add(label_password);
        formPanel.add(password);
        formPanel.add(new JLabel());
        formPanel.add(showPassword);
        formPanel.add(btn);
        formPanel.add(resetBtn);

        this.add(formPanel, BorderLayout.CENTER);

        this.getContentPane().setBackground(new Color(30, 30, 30));
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn) {
            // Handle sign-in button click event here
            message.setText("Signed IN!");
        } else if (e.getSource() == resetBtn) {
            // Handle reset button click event here
            username.setText("");
            password.setText("");
            message.setText("Fields Reset!");
        } else if (e.getSource() == showPassword) {
            // Handle show password checkbox event here
            if (showPassword.isSelected()) {
                password.setEchoChar((char) 0);
            } else {
                password.setEchoChar('*');
            }
        }
    }

    public static void main(String[] args) {
        new ModernLogin();
    }
}
