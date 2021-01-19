package application.model.exception;

public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException(){
        super("Incorrect password");
    }
    public InvalidPasswordException(String message){
        super(message);
    }
}
