package org.example;

class mythread extends Thread{
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

class mythread2 extends Thread{
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
    public class ExtendingThreadClass{
    public static void main(String[] args){
        mythread t1 = new mythread();
        mythread2 t2 = new mythread2();
        t1.start();
        t2.start();
    }
    }
