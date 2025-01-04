package CB16ExceptionalHandling;

public class CB05_finallyII {

    public static void main(String[] args) {

         //Cannot introduce "finally block" here.

        try { //Exception Handling
            System.out.println(10);
            System.out.println(20);
            int a = 60;
            System.out.println(a / 0); //Exception
            System.out.println(40);
            System.out.println(50);
        } catch (ArithmeticException e) { //This part will not execute
            System.out.println("Bhai, app 0 se divide nahi kar sakte!!");
        }

        //int a = 10; //try-catch-finally in the same sequence, you cannot introduce method and variable here.

        finally {
            System.out.println("I have finally found you!!");
        }

        //Cannot introduce "finally block" here.

        System.out.println("I will execute after finally!!");

        //Cannot introduce "finally block" here.
    }

    //If exception occurs, then "try-catch-finally" executes and if exception does not occur, then only try-finally executes.
}
