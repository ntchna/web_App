package application.model.exception;

public class NoSuchDirectionException extends RuntimeException {
    public NoSuchDirectionException(){
        super("No such dsrection exist");
    }
    public NoSuchDirectionException(String message){
        super(message);
    }
}
