
    // Example of Coupling
class Printer {
    void print(String message) {
        System.out.println(message);
    }
}

class Calculator {
    void calculateAndPrint(int a, int b, Printer printer) {
        int result = a + b;
        printer.print("Result: " + result);
    }
}

// Example of Cohesion
class MathOperations {
    int add(int a, int b) {
        return a + b;
    }

    int subtract(int a, int b) {
        return a - b;
    }
}

// Example of Association
class Department {
    String name;

    Department(String name) {
        this.name = name;
    }
}

class Employee {
    String name;
    Department department;

    Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }
}

// Example of Aggregation
class Engine {
    String type;

    Engine(String type) {
        this.type = type;
    }
}

class Car {
    Engine engine;

    Car(Engine engine) {
        this.engine = engine;
    }
}

// Example of Composition
class Leg {
}

class Body {
    Leg leg = new Leg();
}

public class assignment1 {
    public static void main(String[] args) {
        // Coupling Example
        Printer printer = new Printer();
        Calculator calculator = new Calculator();
        calculator.calculateAndPrint(5, 3, printer);

        // Cohesion Example
        MathOperations mathOps = new MathOperations();
        int sum = mathOps.add(10, 5);
        int difference = mathOps.subtract(10, 5);
        System.out.println("Sum: " + sum + ", Difference: " + difference);

        // Association Example
        Department hrDepartment = new Department("HR");
        Employee employee = new Employee("John Doe", hrDepartment);
        System.out.println(employee.name + " works in the " + employee.department.name + " department");

        // Aggregation Example
        Engine carEngine = new Engine("V8");
        Car myCar = new Car(carEngine);
        System.out.println("My car has a " + myCar.engine.type + " engine");

        // Composition Example
        Body humanBody = new Body();
        System.out.println("A human body has a leg");
    }
}

