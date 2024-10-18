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
}