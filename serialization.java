import java.io.*;
public class serialization {
    public static void main(String[] args) {
        students s = new students();
        s.rollNo = 21;
        s.name = "WAQAS ZAFAR";
        String filename = "C:\\Users\\M F C\\Downloads\\student.txt";
        try{
FileOutputStream fos = new FileOutputStream(filename);
ObjectOutputStream oos = new ObjectOutputStream(fos);
oos.close();
fos.close();

System.out.println("Saved Successfully");
System.out.println(fos);
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println(e);
        }
    }
}
