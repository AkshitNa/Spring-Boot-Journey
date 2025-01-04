package CB16ExceptionalHandling;

import CB16ExceptionalHandling.Exception.InvalidInputException;
import CB16ExceptionalHandling.Exception.MaxInputException;
import CB16ExceptionalHandling.Exception.MaxOutputException;

import java.util.Scanner;

public class CB12_Calculator {

    public static void isValidOperator(char operator) throws InvalidInputException {
        if (operator != '+' && operator != '*' && operator != '-' && operator != '/' && operator != 'x' && operator != 'X') {
            throw new InvalidInputException();
        }
    }

    public static double add(double a, double b) throws MaxInputException, MaxOutputException {
        if (a > 1000 || b > 1000) {
            throw new MaxInputException();
        }
        if (a + b > 10000) {
            throw new MaxOutputException();
        }
        return a + b;
    }

    public static double subtract(double a, double b) throws MaxInputException {
        if (a > 1000 || b > 1000) {
            throw new MaxInputException();
        }
        return a - b;
    }

    public static double multiply(double a, double b) throws MaxInputException, MaxOutputException {
        if (a > 1000 || b > 1000) {
            throw new MaxInputException();
        }
        if (a * b > 10000) {
            throw new MaxOutputException();
        }
        return a * b;
    }

    public static double divide(double a, double b) throws MaxInputException, ArithmeticException {
        if (a > 1000 || b > 1000) {
            throw new MaxInputException();
        }
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by 0!!");
        }
        return a / b;
    }

    public static void main(String[] args) {
        char operator;
        double a, b;

        Scanner sc = new Scanner(System.in); // Keep the Scanner declaration outside the loop
        // to prevent repeated creation of the scanner object.

        while (true) {
            System.out.print("Enter First Number  : ");
            a = sc.nextDouble();
            System.out.print("Enter Second Number : ");
            b = sc.nextDouble();

            System.out.println("Choose from MAIN MENU: ");
            System.out.println(" + => Addition ");
            System.out.println(" - => Subtraction ");
            System.out.println(" * => Multiply ");
            System.out.println(" / => Division ");
            System.out.println(" x => Exit");

            System.out.print("Choose Operation: ");
            operator = sc.next().charAt(0);

            if (operator == 'x' || operator == 'X') {
                System.out.println("Exiting...");
                break;  // Exit the loop
            }

            // Single try-catch block for the entire switch statement
            try {
                isValidOperator(operator);
                switch (operator) {
                    case '+':
                        System.out.println(add(a, b));
                        break;
                    case '-':
                        System.out.println(subtract(a, b));
                        break;
                    case '*':
                        System.out.println(multiply(a, b));
                        break;
                    case '/':
                        System.out.println(divide(a, b));
                        break;
                }

            } catch (InvalidInputException | MaxInputException | MaxOutputException | ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        sc.close(); // Close the scanner after loop
    }
}
