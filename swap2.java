import java.util.Scanner;
//swap 2 number with out any third value
public class swap2 {
    public static void main(String[] args) {
        int a, b;
        System.out.println("Enter range:");
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        System.out.println("before swappin:" + a + "." + b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("after swapping:" + a + "." + b);
    }
}
