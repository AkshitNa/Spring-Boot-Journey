package CB16ExceptionalHandling;

public class CB03_tryCatchII {

    public static void main(String[] args) {

        //Exception Handling
        try {
            System.out.println(10);
            System.out.println(20);
            int a = 30;
            System.out.println(a/0);
            //The rest of the code won't work now as exception is handled using try-catch block, so
            //it will directly jump into catch block and print the exception.
            System.out.println(40);
            System.out.println(50);
        }

        catch (ArithmeticException e){ //In java, exception is an object

            //Other ways of printing exception
            System.out.println("First way: Bhai, app 0 se divide nahi kar sakte!!");
            System.out.println("Second way: " + e);
            System.out.println("Third way: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
