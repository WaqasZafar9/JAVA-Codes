package org.example;

import java.util.Scanner;

public class DeleteElementFromArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();


        int[] array = new int[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }


        System.out.print("Enter the element to delete: ");
        int elementToDelete = scanner.nextInt();


        int newSize = removeElement(array, elementToDelete);


        System.out.println("Updated array after deleting the element:");
        for (int i = 0; i < newSize; i++) {
            System.out.print(array[i] + " ");
        }
    }

    private static int removeElement(int[] array, int elementToDelete) {
        int newSize = array.length;
        for (int i = 0; i < newSize; i++) {
            if (array[i] == elementToDelete) {

                for (int j = i; j < newSize - 1; j++) {
                    array[j] = array[j + 1];
                }
                newSize--;
                i--;
            }
        }
        return newSize;
    }
}
