package cabbieManager;
import java.time.LocalDateTime;

//TODO: resolver problemas do LocalDateTime
public class Ride {
	private int rideId;
	private int passengerId;
	private int cabbieId;
	private int vehicleId;
	private Location pickupLocation;
	private Location dropLocation;
     private double distance;
	private String status;
	private LocalDateTime startime;
     private LocalDateTime endTime;
     /**
     * Constructs a new Ride with an initial status of "Livre" (available).
     */
     public Ride(){
          this.status = "Livre";
     }
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
	public void requestRide(int rideId, int passengerId, int cabbieId, int vehicleId, Location pickupLocation, Location dropLocation, LocalDateTime startime, LocalDateTime endTime) {
		this.rideId = rideId;
		this.passengerId = passengerId;
		this.cabbieId = cabbieId;
		this.vehicleId = vehicleId;
		this.pickupLocation = pickupLocation;
		this.dropLocation = dropLocation;
		this.status = "Ocupado";
          this.startime = startime;
          this.endTime = endTime;
	}
	/**
     * Updates the status of the ride to "Available".
     * <p>
     * This method changes the status of the ride to indicate that it is available for a new request.
     * </p>
     */
	public void updateRideStatus() {
		this.status = "Ocupado";
          this.distance = calculateDistance();
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
		this.passengerId = -1;
		this.cabbieId = -1;
		this.vehicleId = -1;
          this.status = "Livre";
	}
	/**
     * Calculates a random fare for the ride.
     * <p>
     * This method generates a random fare between 0.00 and 1.00, inclusive, with two decimal places.
     * </p>
     *
     * @return The calculated fare for the ride.
     */
	private double calculateDistance() {
          // TODO: calcular a distancia
          return Math.sqrt(Math.pow((this.dropLocation.getX() - this.pickupLocation.getX()), 2)+ Math.pow((this.dropLocation.getY() - this.pickupLocation.getY()), 2));
	}
     /**
     * Returns the pickup location for the ride.
     *
     * @return The pickup location.
     */
	public Location getPickupLocation() {
		return pickupLocation;
	}
     /**
     * Returns the drop location for the ride.
     *
     * @return The drop location.
     */
	public Location getDropLocation() {
		return dropLocation;
	}
	/**
     * Returns the current status of the ride.
     *
     * @return The status of the ride.
     */
	public LocalDateTime getStartime() {
		return startime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public String getStatus() {
		return status;
	}
     public double getDistance(){
          return distance;
     }
	/**
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
		return "Ride [rideId=" + rideId + ", passengerId=" + passengerId + ", cabbieId=" + cabbieId + ", vehicleId=" + vehicleId
				+ ", pickupLocation=" + pickupLocation + ", dropLocation=" + dropLocation + ", status=" + status + "]";
	}
}