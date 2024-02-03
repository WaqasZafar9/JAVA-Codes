class Person {
    private String name;
    private int age;

    // Default constructor
    public Person() {
        this.name = "Unknown";
        this.age = 0;
    }

    // Parameterized constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructor
    public Person(Person otherPerson) {
        this.name = otherPerson.name;
        this.age = otherPerson.age;
    }

    public void print() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class Employee extends Person {
    private int employeeId;

    // Default constructor
    public Employee() {
        super(); // Call the default constructor of the base class (Person)
        this.employeeId = 0;
    }

    // Parameterized constructor
    public Employee(String name, int age, int employeeId) {
        super(name, age); // Call the parameterized constructor of the base class (Person)
        this.employeeId = employeeId;
    }

    // Copy constructor
    public Employee(Employee otherEmployee) {
        super(otherEmployee); // Call the copy constructor of the base class (Person)
        this.employeeId = otherEmployee.employeeId;
    }

    public void print() {
        super.print(); // Call the print method of the base class (Person)
        System.out.println("Employee ID: " + employeeId);
    }
}

class Teacher extends Employee {
    private String subject;

    // Default constructor
    public Teacher() {
        super(); // Call the default constructor of the base class (Employee)
        this.subject = "Unknown";
    }

    // Parameterized constructor
    public Teacher(String name, int age, int employeeId, String subject) {
        super(name, age, employeeId); // Call the parameterized constructor of the base class (Employee)
        this.subject = subject;
    }

    // Copy constructor
    public Teacher(Teacher otherTeacher) {
        super(otherTeacher); // Call the copy constructor of the base class (Employee)
        this.subject = otherTeacher.subject;
    }

    public void print() {
        super.print(); // Call the print method of the base class (Employee)
        System.out.println("Subject: " + subject);
    }
}

public class InheritanceExample {
    public static void main(String[] args) {
        Teacher teacher1 = new Teacher(); // Default constructor
        Teacher teacher2 = new Teacher("John", 35, 1001, "Math"); // Parameterized constructor
        Teacher teacher3 = new Teacher(teacher2); // Copy constructor

        System.out.println("Teacher 1:");
        teacher1.print();

        System.out.println("Teacher 2:");
        teacher2.print();

        System.out.println("Teacher 3 (copy of Teacher 2):");
        teacher3.print();
    }
}
