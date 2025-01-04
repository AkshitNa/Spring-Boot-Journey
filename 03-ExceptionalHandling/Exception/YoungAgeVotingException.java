package CB16ExceptionalHandling.Exception;

public class YoungAgeVotingException extends RuntimeException {

    //Creating constructors

    public YoungAgeVotingException(){
        super("Go home!!"); //It passes the message to the default exceptional handler
    }

    public YoungAgeVotingException(String message){
        super(message); //It passes the message to the default exceptional handler
    }

    public YoungAgeVotingException(String message, int number){
        System.out.println(number + " year old brother, " + message);
    }

    public YoungAgeVotingException(String msg, Throwable cause){
        super(cause);
    }
}
