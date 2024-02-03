package org.example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Tes extends JFrame {

    private JPanel contentPane;
    private JTextField t1;
    private JTextField t2;
    private JTextField t3;
    private JTextField t4;
    private JTextField t5;
    private JTextField t6;
    private JTextField t7;
    private JTextField t8;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Tes frame = new Tes();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Tes() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 394, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(9, 9, 9, 9));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel l1 = new JLabel("EMPID");
        l1.setBounds(10, 29, 49, 14);
        contentPane.add(l1);

        JLabel l2 = new JLabel("ENAME");
        l2.setBounds(10, 69, 49, 14);
        contentPane.add(l2);

        JLabel l3 = new JLabel("JOB");
        l3.setBounds(10, 126, 49, 14);
        contentPane.add(l3);

        JLabel l4 = new JLabel("MGR");
        l4.setBounds(10, 169, 49, 14);
        contentPane.add(l4);

        JLabel l6 = new JLabel("SAL");
        l6.setBounds(10, 240, 49, 14);
        contentPane.add(l6);

        JLabel l7 = new JLabel("COMM");
        l7.setBounds(10, 280, 49, 14);
        contentPane.add(l7);

        t1 = new JTextField();
        t1.setBounds(66, 26, 96, 20);
        contentPane.add(t1);
        t1.setColumns(10);

        t2 = new JTextField();
        t2.setBounds(66, 66, 96, 20);
        contentPane.add(t2);
        t2.setColumns(10);

        t3 = new JTextField();
        t3.setBounds(66, 123, 96, 20);
        contentPane.add(t3);
        t3.setColumns(10);

        t4 = new JTextField();
        t4.setBounds(66, 166, 96, 20);
        contentPane.add(t4);
        t4.setColumns(10);

        t6 = new JTextField();
        t6.setBounds(66, 240, 96, 20);
        contentPane.add(t6);
        t6.setColumns(10);

        t7 = new JTextField();
        t7.setBounds(66, 280, 96, 20);
        contentPane.add(t7);
        t7.setColumns(10);

        JButton b1 = new JButton("Submit");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String EMPID = t1.getText();
                String ENAME = t2.getText();
                String JOB = t3.getText();
                String MGR = t4.getText();
                String SAL = t6.getText();
                String COMM = t7.getText();

                String result = Main.getData(EMPID, ENAME, JOB, MGR, SAL, COMM);

                t8.setText(result);
            }
        });
        b1.setBounds(212, 165, 89, 23);
        contentPane.add(b1);
        t8 = new JTextField();
        t8.setBounds(177, 199, 193, 20);
        contentPane.add(t8);
        t8.setColumns(10);
    }
}
