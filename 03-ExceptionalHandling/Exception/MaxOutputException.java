package CB16ExceptionalHandling.Exception;

public class MaxOutputException extends RuntimeException {

    public MaxOutputException(){
        super("Output greater than 10,000 is not allowed");
    }
}
