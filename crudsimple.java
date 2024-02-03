import java.sql.*;

public class crudsimple {

    public void crud() {
        insert("John", "50000", "Manager");
    read();
    update("John", "55000", "Senior Manager");
    read();
    delete("John");
    read();
    }

    public void insert(String name, String salary, String role) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empcrud", "root", "");
            PreparedStatement ps = con.prepareStatement("insert into emp_data (name, salary, role) values(?,?,?)");
            ps.setString(1, name);
            ps.setString(2, salary);
            ps.setString(3, role);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void read() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empcrud", "root", "");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from emp_data");
            while (rs.next()) {
                String name = rs.getString("name");
                String salary = rs.getString("salary");
                String role = rs.getString("role");
                System.out.println(name + " " + salary + " " + role);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void delete(String name) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empcrud", "root", "");
            PreparedStatement ps = con.prepareStatement("delete from emp_data where name=?");
            ps.setString(1, name);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void update(String name, String salary, String role) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empcrud", "root", "");
            PreparedStatement ps = con.prepareStatement("update emp_data set salary=?, role=? where name=?");
            ps.setString(1, salary);
            ps.setString(2, role);
            ps.setString(3, name);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Crud crud = new Crud();
        crud.insert("John", "50000", "Manager");
        crud.read();
        crud.update("John", "55000", "Senior Manager");
        crud.read();
        crud.delete("John");
        crud.read();
    }
}
