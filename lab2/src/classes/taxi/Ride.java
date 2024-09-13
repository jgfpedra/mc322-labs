package classes.taxi;
import java.util.Random;
public class Ride {
    //Adicionar os atributos da classe Ride
	private int rideId;
	private int userId;
	private int cabbieId;
	private int vehicleId;
	private String pickupLocation;
	private String dropLocation;
	private String status;
	private float fare;
    //Adicionar os métodos da classe Ride
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
	public void updateRideStatus() {
		this.status = "Livre";
	}
	public void completeRide() {
		this.rideId = -1;
		this.userId = -1;
		this.cabbieId = -1;
		this.vehicleId = -1;
		updateRideStatus();
	}
	//TODO: calcular taxa de corrida
	private float calculateFare() {
		Random gerador = new Random();
		float randomValue = random.nextFloat(); // Gera número aleatório entre 0.0 e 1.0
        float truncatedValue = (float) (Math.floor(randomValue * 100) / 100.0); // Deixa esse número entre 0 e 100 com 2 casas decimais
		return truncatedValue;
	}
    // getters and setters
	public int getRideId() {
		return rideId;
	}
	public void setRideId(int rideId) {
		this.rideId = rideId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCabbieId() {
		return cabbieId;
	}
	public void setCabbieId(int cabbieId) {
		this.cabbieId = cabbieId;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getPickupLocation() {
		return pickupLocation;
	}
	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}
	public String getDropLocation() {
		return dropLocation;
	}
	public void setDropLocation(String dropLocation) {
		this.dropLocation = dropLocation;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public float getFare() {
		return fare;
	}
	public void setFare(float fare) {
		this.fare = fare;
	}

	// toString
	@Override
	public String toString() {
		return "Ride [rideId=" + rideId + ", userId=" + userId + ", cabbieId=" + cabbieId + ", vehicleId=" + vehicleId
				+ ", pickupLocation=" + pickupLocation + ", dropLocation=" + dropLocation + ", status=" + status
				+ ", fare=" + fare + "]";
	}
}