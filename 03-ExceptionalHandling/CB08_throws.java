package CB16ExceptionalHandling;

public class CB08_throws {

    public static void divide(int a, int b) throws ArithmeticException{
        System.out.println(a/b); //I am not handling the exception here. Jo person use karega iss method ko wahi handle kre.
        //I am telling you that this method can cause exception in the future.
    }

    //If I make a function to open a file, I can follow the same approach

    public static void main(String[] args) {

        int a = 10;
        System.out.println(a);

        try { //exception is occurring in divide method and not in "main method."
            divide(10, 0);
        }catch (Exception e){
            System.out.println("Bhai, app 0 se divide nahi kar sakte!!");
        }

        System.out.println("Hello");
    }
}

/*

1. throws keyword method ke saath use hota hai.
2. throws keyword is used to declare an exception and not to handle exception in the method.
2. "throws keyword" is used in method declarations to specify that a method can
   potentially throw certain exceptions. This allows the method to pass the responsibility
   of handling those exceptions to the caller of the method. It's part of exception handling and is
   typically used for checked exceptions, which need to be either caught or declared.

 */
