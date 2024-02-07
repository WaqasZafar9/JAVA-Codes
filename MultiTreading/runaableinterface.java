package org.example;

class myrunable implements Runnable{
    @Override
    public void run(){
        int i=0;
        while(i<10){
            System.out.println("My cooking thread is running");
            System.out.println("I am HAPPY");
            i++;
        }
    }
}

class myrunable2 implements Runnable{
    @Override
    public void run(){
        int i=0;
        while(i<10){
            System.out.println("Thread 2 for chatting");
            System.out.println("I am SAD!");
            i++;
        }
    }
}
public class runaableinterface {
    public static void main(String[] args){

        myrunable t1 = new myrunable();
        Thread gun1= new Thread(t1);
        myrunable2 t2 = new myrunable2();
        Thread gun2 = new Thread(t2);
        gun1.start();
        gun2.start();
    }
}
