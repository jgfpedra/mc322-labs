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
		switch(field){
			case "1":
				this.model = newValue;
			break;
			case "2":
				//TODO: mudar String para int
				this.year = newValue;
			break;
			case "3":
				this.registrationNumber = newValue;
			break;
		}
	}
    // getters and setters 
    // toString
}
