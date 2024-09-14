package classes.taxi;
import java.util.Random;

/**
 * Represents a ride in the taxi system.
 * <p>
 * The {@link Ride} class stores information about a specific ride, including details such as the ride ID,
 * user ID, cabbie ID, vehicle ID, pickup and drop locations, ride status, and fare. The class provides
 * methods to request a ride, update the ride status, complete the ride, and calculate the fare.
 * </p>
 */
public class Ride {
	private int rideId;
	private int userId;
	private int cabbieId;
	private int vehicleId;
	private String pickupLocation;
	private String dropLocation;
	private String status;
	private float fare;

    /**
     * Requests a new ride and initializes its details.
     * <p>
     * This method sets the ride ID, user ID, cabbie ID, vehicle ID, pickup and drop locations, and
     * sets the initial status of the ride to "Occupied". It also calculates the fare for the ride.
     * </p>
     *
     * @param rideId The unique identifier for this ride.
     * @param userId The unique identifier for the user requesting the ride.
     * @param cabbieId The unique identifier for the cabbie assigned to the ride.
     * @param vehicleId The unique identifier for the vehicle assigned to the ride.
     * @param pickupLocation The location where the ride is to be picked up.
     * @param dropLocation The location where the ride is to be dropped off.
     */
	public void requestRide(int rideId, int userId, int cabbieId, int vehicleId, String pickupLocation, String dropLocation) {	
		this.rideId = rideId;
		this.userId = userId;
		this.cabbieId = cabbieId;
		this.vehicleId = vehicleId;
		this.pickupLocation = pickupLocation;
		this.dropLocation = dropLocation;
		this.status = "Ocupado";
		this.fare = this.calculateFare();
	}
	/**
     * Updates the status of the ride to "Available".
     * <p>
     * This method changes the status of the ride to indicate that it is available for a new request.
     * </p>
     */
	public void updateRideStatus() {
		this.status = "Livre";
	}
	/**
     * Completes the ride and resets its details.
     * <p>
     * This method sets all identifiers to -1 to indicate that the ride is no longer valid and updates
     * the status to "Available".
     * </p>
     */
	public void completeRide() {
		this.rideId = -1;
		this.userId = -1;
		this.cabbieId = -1;
		this.vehicleId = -1;
		updateRideStatus();
	}
	/**
     * Calculates a random fare for the ride.
     * <p>
     * This method generates a random fare between 0.00 and 1.00, inclusive, with two decimal places.
     * </p>
     *
     * @return The calculated fare for the ride.
     */
	private float calculateFare() {
		Random gerador = new Random();
		float randomValue = gerador.nextFloat(); // Gera número aleatório entre 0.0 e 1.0
        float truncatedValue = (float) (Math.floor(randomValue * 100) / 100.0); // Deixa esse número entre 0 e 100 com 2 casas decimais
		return truncatedValue;
	}
     /**
     * Returns the pickup location for the ride.
     *
     * @return The pickup location.
     */
	public String getPickupLocation() {
		return pickupLocation;
	}
     /**
     * Returns the drop location for the ride.
     *
     * @return The drop location.
     */
	public String getDropLocation() {
		return dropLocation;
	}
	/**
     * Returns the current status of the ride.
     *
     * @return The status of the ride.
     */
	public String getStatus() {
		return status;
	}
	/**
     * Returns the fare for the ride.
     *
     * @return The fare amount.
     */
	public float getFare() {
		return fare;
	}
     /**
     * Returns a string representation of this ride.
     * <p>
     * The string representation includes the ride ID, user ID, cabbie ID, vehicle ID, pickup and drop
     * locations, ride status, and fare.
     * </p>
     *
     * @return A string representation of the ride.
     */
	@Override
	public String toString() {
		return "Ride [rideId=" + rideId + ", userId=" + userId + ", cabbieId=" + cabbieId + ", vehicleId=" + vehicleId
				+ ", pickupLocation=" + pickupLocation + ", dropLocation=" + dropLocation + ", status=" + status
				+ ", fare=" + fare + "]";
	}
}