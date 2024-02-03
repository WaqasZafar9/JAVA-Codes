import java.util.Scanner;

public class division {
    public static void main(String arg[]){
        int a;
        int b;
        System.out.println("Enter the first number");
        Scanner sc = new Scanner (System.in);
        a=sc.nextInt();
        System.out.println("Enter the second number");
        b=sc.nextInt();
        try {
            if(b!=0){
                double c=(double)a/b;
                System.out.println("The result is "+c);
            }else{
                throw new Exception("Division by zero not allowed");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
