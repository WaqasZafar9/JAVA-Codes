package org.example;

public class OddNumberException extends Exception {
    public OddNumberException(String message) {
        super(message);
    }

    public static void main(String[] args) {
        try {
            int number = 6;
            checkEvenNumber(number);
            System.out.println(number + " is an even number.");
        } catch (OddNumberException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void checkEvenNumber(int number) throws OddNumberException {
        if (number % 2 != 0) {
            throw new OddNumberException("Error: Odd number not allowed.");
        }
    }
}
