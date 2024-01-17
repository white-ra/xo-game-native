package core.exception;

public class NoSuchInstanceException extends RuntimeException {
    public <T> NoSuchInstanceException(Class<T> clazz) {
        super("No such instance '%s'".formatted(clazz.getName()));
    }
}
