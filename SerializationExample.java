import java.io.*;

class User implements Serializable {
    private String username;
    private String email;
    private int age;

    public User(String username, String email, int age) {
        this.username = username;
        this.email = email;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }

    public static void serializeUser(User user, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(user);
            System.out.println("Serialization successful. User object written to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static User deserializeUser(String fileName) {
        User user = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            user = (User) ois.readObject();
            System.out.println("Deserialization successful. User object read from " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }
}

public class SerializationExample {
    public static void main(String[] args) {
       
        User user = new User("waqas zafar", "waqaszafar771@gmail.com", 20);

      
        User.serializeUser(user, "C:\\Users\\M F C\\Downloads\\user.txt");

     
        User deserializedUser = User.deserializeUser("C:\\Users\\M F C\\Downloads\\user.txt");

      
        if (deserializedUser != null) {
            System.out.println("Deserialized User: " + deserializedUser);
        }
    }
}
