import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import ProcessManagmentFrame.ProcessManagmentFrame;

public class MenuFrame {
    private JFrame frame;
    private JPanel mainPanel;
    private JButton processManagmentButton;
    private JButton memoryManagementButton;
    private JButton IOManagementButton;
    private JButton otherOperationsButton;
    private JLabel heading;
    private JButton exitButton;

    public MenuFrame() {

        initGUI();

    }

    void initGUI(){

        frame = new JFrame("Operating System");

        frame.setSize(837,485);

        mainPanel=addContent();
        frame.add(mainPanel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    JPanel addContent(){

        JPanel temp = new JPanel(null);
        processManagmentButton = new JButton("Process Management");
        memoryManagementButton = new JButton("Memory Management");
        IOManagementButton = new JButton("I/O Management");
        otherOperationsButton = new JButton("Other Operations");
        heading = new JLabel("Operating System");
        heading = new JLabel("Operating System");
        Font boldFont = new Font(heading.getFont().getName(), Font.BOLD, 18);
        heading.setFont(boldFont);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        exitButton = new JButton("Exit");


        temp.add(processManagmentButton);
        temp.add(memoryManagementButton);
        temp.add(IOManagementButton);
        temp.add(otherOperationsButton);
        temp.add(heading);
        temp.add(exitButton);

        processManagmentButton.setBounds(195, 145, 170, 45);
        memoryManagementButton.setBounds(445, 145, 170, 45);
        IOManagementButton.setBounds(195, 240, 170, 45);
        otherOperationsButton.setBounds(445, 240, 170, 45);
        heading.setBounds(300, 60, 195, 40);
        exitButton.setBounds(320, 320, 170, 45);

        processManagmentButton.addActionListener(buttonListner);
        memoryManagementButton.addActionListener(buttonListner);
        IOManagementButton.addActionListener(buttonListner);
        otherOperationsButton.addActionListener(buttonListner);
        exitButton.addActionListener(buttonListner);

        return temp;
    }

    ActionListener buttonListner=new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Process Management")){
                new ProcessManagmentFrame();
                frame.dispose();
            }
            else if(e.getActionCommand().equals("Exit")){
                new ProcessManagmentFrame();
                frame.dispose();
            }
        }
    };

    public static void main(String[] args) {

            new MenuFrame();

    }
}