package cabbieManager;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Random;

/**
 * Represents a ride in the taxi service.
 * <p>
 * The {@link Ride} class manages the details of a ride, including the status, passenger, cabbie,
 * vehicle information, pickup and drop locations, distance, and timing.
 * </p>
 */
public class Ride {
	private String rideId;
	private String passengerId;
	private String cabbieId;
	private String vehicleId;
	private Location pickupLocation;
	private Location dropLocation;
    private float distance;
	private String status;
	private LocalDateTime startTime;
    private LocalDateTime endTime;

    /**
     * Constructs a new Ride with an initial status of "Livre" (available).
     *
     * @param passengerId The ID of the passenger requesting the ride.
     */
    public Ride(String passengerId){
        this.passengerId = passengerId;
    }
    /**
     * Requests a new ride for the specified passenger.
     * <p>
     * This method initializes the ride, setting its start time and status to "CHAMADA".
     * </p>
     *
     * @param passengerId The ID of the passenger requesting the ride.
     * @return A new Ride object with updated status and start time.
     */
	public Ride requestRide(String passengerId){
		Ride newRide = new Ride(passengerId);
		this.startTime = generateRandomDatetTime();
		this.status = "CHAMADA";
		return newRide;
	}
    /**
     * Updates the ride status to "EM_PROGRESSO".
     */
	public void updateRideStatus() {
		this.status = "EM_PROGRESSO";
	}
	/**
     * Completes the ride and resets all ride-related information.
     * <p>
     * This method sets the ride's identifiers and details to null and prints a completion message.
     * </p>
     */
	public void completeRide() {
		this.rideId = null;
		this.passengerId = null;
		this.cabbieId = null;
		this.vehicleId = null;
		System.out.println("Corrida finalizada");
	}
	/**
     * Calculates the distance of the ride based on pickup and drop locations.
     *
     * @return The calculated distance as a float.
     */
	public float calculateDistance() {
		this.distance = (float) Math.round(Math.sqrt(Math.pow((this.dropLocation.getX() - this.pickupLocation.getX()), 2) + Math.pow((this.dropLocation.getY() - this.pickupLocation.getY()), 2)) * 100.0f) / 100.0f;
        return this.distance;
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
     * Returns the start time of the ride.
     *
     * @return The start time of the ride.
     */
	public LocalDateTime getStartime() {
		return startTime;
	}
    /**
     * Returns the end time of the ride.
     *
     * @return The end time of the ride.
     */
	public LocalDateTime getEndTime() {
		return endTime;
	}
    /**
     * Returns the current status of the ride.
     *
     * @return The ride status.
     */
	public String getStatus() {
		return status;
	}
    /**
     * Sets the pickup location for the ride.
     *
     * @param location The location to set as the pickup location.
     */
	public void setPickupLocation(Location location) {
		this.pickupLocation = location;
	}
    /**
     * Sets the drop location for the ride.
     *
     * @param location The location to set as the drop location.
     */
	public void setDropLocation(Location location) {
		this.dropLocation = location;
	}
    /**
     * Returns a string representation of the ride, including ride details.
     *
     * @return A string representation of the ride.
     */
	@Override
	public String toString() {
		return "Ride [rideId=" + rideId + ", passengerId=" + passengerId + ", cabbieId=" + cabbieId + ", vehicleId=" + vehicleId
				+ ", pickupLocation=" + pickupLocation + ", dropLocation=" + dropLocation + ", status=" + status + "]";
	}
    /**
     * Generates a random LocalDateTime between the years 2000 and 2024.
     *
     * @return A randomly generated LocalDateTime.
     */
	private static LocalDateTime generateRandomDatetTime(){
		Random random = new Random();
		LocalDateTime start = LocalDateTime.of(2000, 1, 1, 0, 0);
        LocalDateTime end = LocalDateTime.of(2024, 12, 31, 23, 59);
		long startSeconds = start.toEpochSecond(ZoneOffset.UTC);
        long endSeconds = end.toEpochSecond(ZoneOffset.UTC);
        long randomSeconds = startSeconds + random.nextLong() % (endSeconds - startSeconds + 1);
		return LocalDateTime.ofEpochSecond(randomSeconds, 0, ZoneOffset.UTC);
	}
}