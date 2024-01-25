package core.di.exception;

public class CreateInstanceException extends RuntimeException {
    public <T> CreateInstanceException(Class<T> clazz) {
        super("An error occurred while creating instance. Class '%s'".formatted(clazz.getName()));
    }
}
