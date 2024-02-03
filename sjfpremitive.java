import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Arrays;
import java.util.Comparator;

public class SJFPreemptiveExample {

    static class Process {
        int pid;
        int at; // Arrival Time
        int bt; // Burst Time
        int ct; // Completion Time
        int tat; // Turn Around Time
        int wt; // Waiting Time
        int remainingBt; // Remaining Burst Time for preemptive SJF

        public Process(int pid, int at, int bt) {
            this.pid = pid;
            this.at = at;
            this.bt = bt;
            this.remainingBt = bt;
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of processes:"));

        // Create an array of processes
        Process[] processes = new Process[n];
        for (int i = 0; i < n; i++) {
            processes[i] = getUserInputForProcess(i + 1);
        }

        calculateTimesSJF(processes, n);
    }

    static Process getUserInputForProcess(int processNumber) {
        int pid = Integer.parseInt(JOptionPane.showInputDialog("Enter Process " + processNumber + " ID:"));
        int at = Integer.parseInt(JOptionPane.showInputDialog("Enter Arrival Time for Process " + processNumber + ":"));
        int bt = Integer.parseInt(JOptionPane.showInputDialog("Enter Burst Time for Process " + processNumber + ":"));

        return new Process(pid, at, bt);
    }

    static void calculateTimesSJF(Process[] processes, int n) {
        Arrays.sort(processes, 0, n, Comparator.comparingInt(p -> p.at));

        boolean[] completed = new boolean[n];
        int currentTime = 0;
        int completedCount = 0;

        while (completedCount != n) {
            int shortest = -1;
            int shortestBurst = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (!completed[i] && processes[i].at <= currentTime && processes[i].remainingBt < shortestBurst) {
                    shortestBurst = processes[i].remainingBt;
                    shortest = i;
                }
            }

            if (shortest == -1) {
                currentTime++;
            } else {
                processes[shortest].remainingBt--;

                if (processes[shortest].remainingBt == 0) {
                    processes[shortest].ct = currentTime + 1;
                    processes[shortest].tat = processes[shortest].ct - processes[shortest].at;
                    processes[shortest].wt = processes[shortest].tat - processes[shortest].bt;

                    completed[shortest] = true;
                    completedCount++;
                }

                currentTime++;
            }
        }

        displayResultsInTable(processes, n);
    }

    static void displayResultsInTable(Process[] processes, int n) {
        JFrame frame = new JFrame();

        String[] column = {"ProcessID", "Arrival Time", "Burst Time", "Completion Time", "Turn Around Time", "Waiting Time"};
        DefaultTableModel model = new DefaultTableModel(null, column);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(30, 50, 450, 350);

        model.setRowCount(0);
        for (int i = 0; i < n; i++) {
            model.addRow(new Object[]{
                    processes[i].pid,
                    processes[i].at,
                    processes[i].bt,
                    processes[i].ct,
                    processes[i].tat,
                    processes[i].wt
            });
        }

        frame.add(scrollPane);
        frame.setSize(600, 500);
        frame.setVisible(true);
    }
}