package CB16ExceptionalHandling;

public class CB06_finallyIII {

    public static void main(String[] args) {

        //Cannot introduce "finally block" here.

        try { //Exception Handling
            System.out.println(10);
            System.out.println(20);
            int a = 60;
            System.out.println(a / 0); //Exception and abnormal termination
            System.out.println(40);
            System.out.println(50);
        }

        finally { //This part still executes.
            System.out.println("I have finally found you!!");
        }

        System.out.println("I will not execute after finally as exception is not handled this time!!");
    }

    //If exception occurs, then "try-catch-finally" executes and if exception does not occur, then only try-finally executes.
}
