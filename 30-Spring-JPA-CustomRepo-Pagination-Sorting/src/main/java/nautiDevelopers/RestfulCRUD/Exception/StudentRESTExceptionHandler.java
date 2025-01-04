package nautiDevelopers.RestfulCRUD.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//Exception Handling Code
@ControllerAdvice
public class StudentRESTExceptionHandler {

    //Adding Exceptional Handler, now it will handle Exception in more than One REST Controller.
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e){

        //Create sn object (error) of the CollegeErrorResponse Class.
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(e.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        error.setMyMessage("ID does not match!!");

        //Since the Exception is an object, so it will take it data from an error object.
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    //MethodOverloading with "Exception e" so
    // that it can catch any type of exception => "BAD_REQUEST"
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception e)
    {
        //Create sn object (error) of the CollegeErrorResponse Class.
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(e.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        error.setMyMessage("ID does not match!!");

        //Since the Exception is an object, so it will take it data from an error object.
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
