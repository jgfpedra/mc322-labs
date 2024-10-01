package cabbieManager;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.base.Objects;

import utils.VehicleInfoGenerator;

/**
 * Represents a vehicle in the cab management system.
 * This class provides functionality for registering a vehicle,
 * updating its attributes, and retrieving its information.
 */
@XmlRootElement(name = "vehicle")
public class Vehicle {
    private String vehicleId;
    private String registrationNumber;
    private String model;
    private int year;
    private String cabbieId;
    public Vehicle(){
        
    }
    public Vehicle(String cabbieId) {
        this.cabbieId = cabbieId;
    }
    /**
     * Registers a vehicle by generating random information.
     * This method assigns a random ID, registration number, model and year to the vehicle.
     */
    public void registerVehicle() {
        VehicleInfoGenerator veh = new VehicleInfoGenerator();
        this.vehicleId = veh.getVehicleId();
        this.registrationNumber = veh.getRegistrationNumber();
        this.model = veh.getModel();
        this.year = veh.getYear();
        System.out.println("Veículo " + this.vehicleId + " (" + this.model + " " + this.year + ") criado com sucesso");
    }
    /**
     * Updates a field of the Vehicle.
     *
     * @param field The field to be updated.
     * @param newValue The new value for the field.
     *
     * The valid fields are:
     * <ul>
     * <li>vehicleId</li>
     * <li>registrationNumber</li>
     * <li>model</li>
     * <li>year</li>
     * </ul>
     *
     * If the field is not valid, a message is printed and the field is not updated.
     */
    public void updateVehicle(String field, String newValue) {
        boolean validField = true;
        switch (field) {
            case "vehicleId":
                this.vehicleId = newValue;
                break;
            case "registrationNumber":
                this.registrationNumber = newValue;
                break;
            case "model":
                this.model = newValue;
                break;
            case "year":
                this.year = Integer.parseInt(newValue);
                break;
            default:
                validField = false;
                System.out.println("Campo inválido, tente novametne");
                break;
        }
        if (validField) {
            System.out.println("Campo " + field + " alterado com sucesso");
        }
        return;
    }
    /**
     * Gets the ID of the Vehicle.
     *
     * @return the ID of the vehicle (a UUID)
     */
    @XmlElement
    public String getVehicleId() {
        return this.vehicleId;
    }
    /**
     * Sets the ID of the vehicle.
     *
     * @param vehicleId the new ID of the vehicle
     */
    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }
    /**
     * Gets the registration number of the vehicle.
     *
     * @return the registration number of the vehicle
     */
    @XmlElement
    public String getRegistrationNumber() {
        return registrationNumber;
    }
    /**
     * Sets the registration number of the vehicle.
     *
     * @param registrationNumber the new registration number of the vehicle
     */
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
    /**
     * Gets the model of the vehicle.
     *
     * @return the model of the vehicle
     */
    @XmlElement
    public String getModel() {
        return model;
    }
    /**
     * Sets the model of the vehicle.
     *
     * @param model the new model of the vehicle
     */
    public void setModel(String model) {
        this.model = model;
    }
    /**
     * Gets the manufacturing year of the vehicle.
     *
     * @return the year of the vehicle
     */
    @XmlElement
    public int getYear() {
        return year;
    }
    /**
     * Sets the manufacturing year of the vehicle.
     *
     * @param year the new year of the vehicle
     */
    public void setYear(int year) {
        this.year = year;
    }
    /**
     * Gets the ID of the cabbie associated with this vehicle.
     *
     * @return the ID of the cabbie
     */
    @XmlElement
    public String getCabbieId() {
        return cabbieId;
    }
    /**
     * Sets the ID of the cabbie associated with this vehicle.
     *
     * @param cabbieId the new ID of the cabbie
     */
    public void setCabbieId(String cabbieId) {
        this.cabbieId = cabbieId;
    }
    /**
     * Returns a string representation of the Vehicle.
     *
     * @return a string containing the ID, registration number, model, year and
     *         cabbie ID of the vehicle, separated by commas.
     */
    public String toString() {
        return this.vehicleId + " " + this.model + " " + this.year;
    }
    /**
     * Compares this Vehicle to another object for equality.
     *
     * @param o the object to compare to
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        Vehicle pas = (Vehicle) o;
        return Objects.equal(this.vehicleId, pas.getVehicleId());
    }
}
