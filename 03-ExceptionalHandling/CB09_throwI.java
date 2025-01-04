package CB16ExceptionalHandling;

public class CB09_throwI {

    // Method that declares it can throw an ArithmeticException
    public static int divide(int numerator, int denominator) throws ArithmeticException {
        if (denominator == 0) {
            throw new ArithmeticException("Bhai, app 0 se divide nahi kar sakte!!");
            // System.out.println("You cannot write anything after throw"); [Unreachable]
        }
        return numerator / denominator;
    }

    public static void main(String[] args) {

        try {
            // Calling the divide method that can throw an exception
            int result = divide(10, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            // Handling the exception
            System.out.println("Error: " + e.getMessage());
        }
    }
}

// "throw" keyword is used to create our own exception object.
// therefore, we use "new" keyword
