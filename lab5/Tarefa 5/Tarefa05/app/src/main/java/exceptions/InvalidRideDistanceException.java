package exceptions;

public class InvalidRideDistanceException extends RuntimeException {
    public InvalidRideDistanceException() {
        super("Ride distance must be greater than zero");
    }

    public InvalidRideDistanceException(String message) {
        super(message);
    }

    public InvalidRideDistanceException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidRideDistanceException(Throwable cause) {
        super(cause);
    }
}
