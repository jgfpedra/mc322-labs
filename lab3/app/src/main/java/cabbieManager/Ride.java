package cabbieManager;
import java.time.LocalDateTime;

//TODO: resolver problemas do LocalDateTime
public class Ride {
	private String rideId;
	private String passengerId;
	private String cabbieId;
	private String vehicleId;
	private Location pickupLocation;
	private Location dropLocation;
     private float distance;
	private String status;
	private LocalDateTime startime;
     private LocalDateTime endTime;
     /**
     * Constructs a new Ride with an initial status of "Livre" (available).
     */
     public Ride(String rideId){
          this.rideId = rideId;
     }
	public void updateRideStatus() {
	}
	public void completeRide() {
		this.rideId = null;
		this.passengerId = null;
		this.cabbieId = null;
		this.vehicleId = null;
          this.status = "Livre";
	}
	public float calculateDistance() {
          return (float) Math.sqrt(Math.pow((this.dropLocation.getX() - this.pickupLocation.getX()), 2)+ Math.pow((this.dropLocation.getY() - this.pickupLocation.getY()), 2));
	}
	public Location getPickupLocation() {
		return pickupLocation;
	}
	public Location getDropLocation() {
		return dropLocation;
	}
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
	public void setPickupLocation(Location location) {
		this.pickupLocation = location;
	}
	public void setDropLocation(Location location) {
		this.dropLocation = location;
	}
	@Override
	public String toString() {
		return "Ride [rideId=" + rideId + ", passengerId=" + passengerId + ", cabbieId=" + cabbieId + ", vehicleId=" + vehicleId
				+ ", pickupLocation=" + pickupLocation + ", dropLocation=" + dropLocation + ", status=" + status + "]";
	}
}