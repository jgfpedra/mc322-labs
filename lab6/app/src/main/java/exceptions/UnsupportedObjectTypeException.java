package exceptions;
/**
 * Exception thrown when an unsupported object type is attempted
 * to be inserted into a database.
 * <p>
 * This runtime exception indicates that the operation cannot be
 * completed due to the object type not being supported for
 * database insertion.
 * </p>
 */
public class UnsupportedObjectTypeException extends RuntimeException {
    /**
     * Constructs a new {@code UnsupportedObjectTypeException}
     * with a default message.
     */
    public UnsupportedObjectTypeException(String message) {
        super(message);
    }
}