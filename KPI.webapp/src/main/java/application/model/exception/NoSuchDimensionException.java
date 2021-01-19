package application.model.exception;

public class NoSuchDimensionException extends RuntimeException {
    public NoSuchDimensionException() {
        super("Such dimencion doesn't exist");
    }

    public NoSuchDimensionException(String message) {
        super(message);

    }
}
