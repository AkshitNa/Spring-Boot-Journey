package CB16ExceptionalHandling;

public class CB02_tryCatchI {

    public static void main(String[] args) {

        System.out.println(10);
        System.out.println(20);

        int a = 30;

        //Exception Handling
        try {
            System.out.println(a/0);
        }

        catch (Exception e){ //In java, exception is an object
            System.out.println(e);
            System.out.println("Bhai, app 0 se divide nahi kar sakte!!");
        }

        //The rest of the code will work now as exception is handled using try-catch block.

        System.out.println(40);
        System.out.println(50);
    }
}
