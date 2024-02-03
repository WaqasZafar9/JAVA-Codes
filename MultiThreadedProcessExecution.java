import java.util.Scanner;

class ProcessThread extends Thread {
    private int processNumber;

    public ProcessThread(int processNumber) {
        this.processNumber = processNumber;
    }

    @Override
    public void run() {
        System.out.println("Executing Process " + processNumber);

        // Simulate some work
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Process " + processNumber + " completed.");
    }
}

public class MultiThreadedProcessExecution {
    public static void main(String[] args) {
        // Take the number of processes from the user
        int numProcesses = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the number of processes: ");
            numProcesses = scanner.nextInt();
        } catch (Exception e) {
            System.err.println("Invalid input. Please enter a valid number.");
            System.exit(1);
        }

        // Create and start threads for each process
        for (int i = 1; i <= numProcesses; i++) {
            ProcessThread thread = new ProcessThread(i);
            thread.start();
        }

        System.out.println("Main Thread exiting.");
    }
}
