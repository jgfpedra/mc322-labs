package exceptions;

/**
 * Exception thrown when an invalid ride distance is provided.
 * <p>
 * This runtime exception indicates that the specified ride 
 * distance is not valid, typically because it is less than or 
 * equal to zero.
 * </p>
 */
public class InvalidRideDistanceException extends RuntimeException {
    /**
     * Constructs a new {@code InvalidRideDistanceException} 
     * with a default message indicating that the ride distance 
     * must be greater than zero.
     */
    public InvalidRideDistanceException() {
        super("Ride distance must be greater than zero");
    }
    /**
     * Constructs a new {@code InvalidRideDistanceException} 
     * with the specified detail message.
     *
     * @param message the detail message.
     */
    public InvalidRideDistanceException(String message) {
        super(message);
    }
    /**
     * Constructs a new {@code InvalidRideDistanceException} 
     * with the specified detail message and cause.
     *
     * @param message the detail message.
     * @param cause the cause of the exception.
     */
    public InvalidRideDistanceException(String message, Throwable cause) {
        super(message, cause);
    }
    /**
     * Constructs a new {@code InvalidRideDistanceException}
     * with the specified cause.
     *
     * @param cause the cause of the exception.
     */
    public InvalidRideDistanceException(Throwable cause) {
        super(cause);
    }
}
