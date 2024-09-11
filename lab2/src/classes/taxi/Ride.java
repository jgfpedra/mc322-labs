package classes.taxi;

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
		return 0;
	}
    // getters and setters
	public float getFare(){
		return this.fare;
	}
    // toString
}