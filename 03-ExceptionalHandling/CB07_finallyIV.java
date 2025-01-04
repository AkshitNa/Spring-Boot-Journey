package CB16ExceptionalHandling;

public class CB07_finallyIV {

    public static void main(String[] args) {

        //Cannot introduce "finally block" here.

        try { //Exception Handling
            System.out.println(10);
            System.out.println(20);
            System.exit(0); //shutdown
        }

        finally { //This part will not execute this time as JVM shutdown => "System.exit(0);"
            System.out.println("I have finally found you!!");
        }

        System.out.println("I will not execute after finally as exception is not handled this time!!");
    }

    //If exception occurs, then "try-catch-finally" executes and if exception does not occur, then only try-finally executes.
}

/*

Q-Is there any way to skip Finally block of exception even if some exception occurs in the exception
block?

Ans: If an exception is raised in Try block, control passes to catch block if it exists otherwise to finally block.
The "finally block" is always executed when an exception occurs, and the only way to avoid execution of any
statements in Finally block is by aborting the code forcibly by writing the following line of
code at the end of try block:

System.exit(0);

 */
