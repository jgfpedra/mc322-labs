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
	private float calculateFare() {
		Random gerador = new Random();
		float randomValue = gerador.nextFloat(); // Gera número aleatório entre 0.0 e 1.0
        float truncatedValue = (float) (Math.floor(randomValue * 100) / 100.0); // Deixa esse número entre 0 e 100 com 2 casas decimais
		return truncatedValue;
	}
    // Getters and setters
	public int getRideId() {
		return rideId;
	}
	public int getUserId() {
		return userId;
	}
	public int getCabbieId() {
		return cabbieId;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public String getPickupLocation() {
		return pickupLocation;
	}
	public String getDropLocation() {
		return dropLocation;
	}
	public String getStatus() {
		return status;
	}
	public float getFare() {
		return fare;
	}
	// toString
	@Override
	public String toString() {
		return "Ride [rideId=" + rideId + ", userId=" + userId + ", cabbieId=" + cabbieId + ", vehicleId=" + vehicleId
				+ ", pickupLocation=" + pickupLocation + ", dropLocation=" + dropLocation + ", status=" + status
				+ ", fare=" + fare + "]";
	}
}