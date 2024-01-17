package core.exception;

public class CreateInstanceException extends RuntimeException {
    public CreateInstanceException(String message) {
        super("An error occurred while creating instance. Error '%s'".formatted(message));
    }
}
