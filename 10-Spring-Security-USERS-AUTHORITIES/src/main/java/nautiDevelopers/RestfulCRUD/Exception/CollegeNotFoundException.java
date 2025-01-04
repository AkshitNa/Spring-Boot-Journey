package nautiDevelopers.RestfulCRUD.Exception;

public class CollegeNotFoundException extends RuntimeException{

    public CollegeNotFoundException(String message) {
        super(message);
    }

    public CollegeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CollegeNotFoundException(Throwable cause) {
        super(cause);
    }
}
