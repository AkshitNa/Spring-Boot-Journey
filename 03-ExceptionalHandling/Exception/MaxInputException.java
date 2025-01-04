package CB16ExceptionalHandling.Exception;

public class MaxInputException extends Exception {

    public MaxInputException(){
        super("Input cannot be greater than 1000");
    }
}
