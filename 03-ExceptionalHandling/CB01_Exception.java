package CB16ExceptionalHandling;

public class CB01_Exception {

    public static void main(String[] args) {

        System.out.println(10);
        System.out.println(20);

        int a = 30;
        System.out.println(a/0); //Exception => Exception in thread "main" java.lang.ArithmeticException: / by zero
        // at CB12_ExceptionalHandling.CB01_Exception.main(CB01_Exception.java:10)

        //The rest of the code won't work as execution is from top to bottom.

        System.out.println(40);
        System.out.println(50);

        //ZNote01: Exceptions can be handled by a programmer using try, catch, etc. but errors cannot be handled.
    }
}
