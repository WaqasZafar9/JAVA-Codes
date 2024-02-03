package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static int[][] arr = {{9, 8}, {2, 6}, {2, 5}, {1, 9}, {7, 6}, {12, 26}};
    private static List<Integer> peakIndices = new ArrayList<>();

    public static List<Integer> findPeakGrid(int[][] arr, JPanel panel) {
        List<Integer> result = new ArrayList<>();
        int row = arr.length;
        int column = arr[0].length;
        int maxPeak = Integer.MIN_VALUE;
        int maxPeakRow = -1;
        int maxPeakColumn = -1;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i > 0 && arr[i][j] < arr[i - 1][j]) continue;
                if (j < column - 1 && arr[i][j] < arr[i][j + 1]) continue;
                if (i < row - 1 && arr[i][j] < arr[i + 1][j]) continue;
                if (j > 0 && arr[i][j] < arr[i][j - 1]) continue;

                if (arr[i][j] > maxPeak) {
                    maxPeak = arr[i][j];
                    maxPeakRow = i;
                    maxPeakColumn = j;
                }

                SwingUtilities.invokeLater(() -> {
                    visualizeArray(panel);
                    try {
                        Thread.sleep(1000); // Delay for 1 second to observe each iteration
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        }

        result.add(maxPeakRow);
        result.add(maxPeakColumn);
        return result;
    }

    private static void visualizeArray(JPanel panel) {
        panel.removeAll();
        panel.setLayout(new GridLayout(arr.length, arr[0].length));

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                JButton button = new JButton(String.valueOf(arr[i][j]));
                button.setEnabled(false);
                if (peakIndices.contains(i) && peakIndices.contains(j)) {
                    button.setOpaque(true);
                    button.setBackground(Color.YELLOW);
                }
                panel.add(button);
            }
        }

        JFrame frame = new JFrame("Array Visualization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JPanel panel = new JPanel();
            peakIndices = findPeakGrid(arr, panel);

            JOptionPane.showMessageDialog(null,
                    "Highest peak element found at index: " + peakIndices.get(0) + ", " + peakIndices.get(1),
                    "Highest Peak Element",
                    JOptionPane.INFORMATION_MESSAGE);

            visualizeArray(panel);
        });
    }
}
