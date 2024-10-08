package exceptions;

public class UnsupportedObjectTypeException extends RuntimeException {
    public UnsupportedObjectTypeException() {
        super("Trying to insert unsupported object type for database insertion");
    }

    public UnsupportedObjectTypeException(String message) {
        super(message);
    }

    public UnsupportedObjectTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedObjectTypeException(Throwable cause) {
        super(cause);
    }
}