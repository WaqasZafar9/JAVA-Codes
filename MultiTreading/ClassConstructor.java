package org.example;


public class ClassConstructor extends Thread {

    public ClassConstructor(String name) {
        super(name);
    }

    public void run() {
        int i = 34;
        System.out.println("Thank You");
    }

    public static void main(String[] args) {
        ClassConstructor t1 = new ClassConstructor("ADAM");
        ClassConstructor t2 = new ClassConstructor("Sara");
        t1.start();
        t2.start();
        System.out.println("The id of thread t is " + t1.getId());
        System.out.println("The id of thread t is " + t1.getName());
        System.out.println("The id of thread t is " + t2.getId());
        System.out.println("The id of thread t is " + t2.getName());
    }
}
