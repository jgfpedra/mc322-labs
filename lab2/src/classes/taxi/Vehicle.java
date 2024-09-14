package classes.taxi;

import classes.taxi.utils.VehicleInfoGenerator;

public class Vehicle {
    //Adicionar os atributos da classe Vehicle
	private int vehicleId;
	private String registrationNumber;
	private String model;
	private int year;
	private int cabbieId;
    //Adicionar os métodos da classe Vehicle
	public Vehicle(int cabbieId){
		VehicleInfoGenerator vehicleRand = new VehicleInfoGenerator();
		this.vehicleId = vehicleRand.getVehicleId();
		this.registrationNumber = vehicleRand.getRegistrationNumber();
		this.model = vehicleRand.getModel();
		this.year = vehicleRand.getYear();
		this.cabbieId = cabbieId;
	}

	public void update(String field, String newValue){
		int newValueInt;
		switch(field){
			case "1":
				this.model = newValue;
			break;
			case "2":
				newValueInt = Integer.parseInt(newValue); // String -> Int
				this.year = newValueInt;
			break;
			case "3":
				this.registrationNumber = newValue;
			break;
			case "4":
				newValueInt = Integer.parseInt(newValue);
				this.cabbieId = newValueInt;
			break;
		}
	}

	// Getters and Setters
	public int getVehicleId() {
		return vehicleId;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public String getModel() {
		return model;
	}

	public int getYear() {
		return year;
	}
	public int getCabbieId() {
		return cabbieId;
	}

	// toString
	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", registrationNumber=" + registrationNumber + ", model=" + model
				+ ", year=" + year + ", cabbieId=" + cabbieId + "]";
	}
}
