import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class Crud {

    public Crud(){
        Gui();
    }
    private void Gui(){
        JFrame frame= new JFrame("Crud");
        JButton delete=new JButton("Delete");
        JButton save=new JButton("Save");
        JButton update=new JButton("Update");
        JButton read=new JButton("read");
        JTextField name=new JTextField();
        JTextField salary=new JTextField();
        JTextField role=new JTextField();

        name.setBounds(10,10,200,30);
        salary.setBounds(10,60,200,30);
        role.setBounds(10,120,200,30);
        save.setBounds(10,180,100,30);
        delete.setBounds(120,180,100,30);
        update.setBounds(10,230,100,30);
        read.setBounds(120,230,100,30);

        JPanel panel=new JPanel(null);
        panel.add(name);
        panel.add(salary);
        panel.add(role);
        panel.add(delete);
        panel.add(save);
        panel.add(update);
        panel.add(read);

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nam=name.getText();
                String sal=salary.getText();
                String rol=role.getText();
                insert(nam,sal,rol);
            }
        });
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nam=name.getText();
                String sal=salary.getText();
                String rol=role.getText();
                update(nam,sal,rol);
            }
        });
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nam=name.getText();
                delete(nam);
            }
        });
        read.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                read();
            }
        });
        frame.add(panel);
        frame.setSize(800,500);
        frame.setVisible(true);
    }

    public void insert(String name,String  salary,String role){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empcrud","root","");
            PreparedStatement ps=con.prepareStatement("insert into emp_data (name,salary,role) values(?,?,?)");
            ps.setString(1,name);
            ps.setString(2,salary);
            ps.setString(3,role);
            ps.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public void read(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empcrud","root","");
            Statement st=con.createStatement();
            ResultSet rs = st.executeQuery("select * from emp_data");
            while(rs.next()){
                String name=rs.getString("name");
                String salary=rs.getString("sal");
                String role=rs.getString("role");
                System.out.println(name+" "+salary+" "+role);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public void delete(String name){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empcrud","root","");
            PreparedStatement ps=con.prepareStatement("delete from emp_data where name='"+name+"'");
            ps.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public void update(String name,String  salary,String role){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empcrud","root","");
            PreparedStatement ps=con.prepareStatement("update emp_data   set salary=?,role=?  where name='"+name+"'");
            ps.setString(2,role);
            ps.setString(1,salary);
            ps.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args){
        new Crud();}
}