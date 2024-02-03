public class student {
    private int rollNo;
    private String name;

    // Default constructor
    public student() {
        this.rollNo = 0;
        this.name = "Unknown";
    }

    // Parameterized constructor
    public student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    // Copy constructor
    public student(student otherStudent) {
        this.rollNo = otherStudent.rollNo;
        this.name = otherStudent.name;
    }

    // Getter for rollNo
    public int getRollNo() {
        return rollNo;
    }

    // Setter for rollNo
    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Print method to display student information
    public void print() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
    }

    public static void main(String[] args) {
        // Creating objects using various constructors
        student student1 = new student(); // Default constructor
        student student2 = new student(101, "Alice"); // Parameterized constructor
        student student3 = new student(student2); // Copy constructor

        // Calling the print method on objects
        System.out.println("Student 1:");
        student1.print();

        System.out.println("Student 2:");
        student2.print();

        System.out.println("Student 3 (copy of Student 2):");
        student3.print();

        // Modifying and displaying student information using setters and getters
        student1.setRollNo(102);
        student1.setName("Bob");

        System.out.println("Updated Student 1:");
        student1.print();
    }
}
