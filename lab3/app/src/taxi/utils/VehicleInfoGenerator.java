package taxi.utils;
import java.util.Random;
import java.util.UUID;

public class VehicleInfoGenerator implements InfoGenerator{
    private String[] models = {"Toyota", "Honda", "Ford", "Chevrolet", "Nissan", "Hyundai", "Volkswagen", "Subaru", "Mazda", "Kia"};
    private String[] registrationNumbers = {"ABC123", "DEF456", "GHI789", "JKL012", "MNO345", "PQR678", "STU901", "VWX234", "YZA567", "BCD890"};
    private String vehicleId;
    private String registrationNumber;
    private String model;
    private int year;
    public VehicleInfoGenerator() {
        this.generateRandomInfo();
    }
    public void generateRandomInfo() {
        Random ran = new Random();
        int idx = ran.nextInt(10);
        this.model = models[idx];
        this.registrationNumber = registrationNumbers[idx];
        this.vehicleId = UUID.randomUUID().toString();
        this.year = ran.nextInt(34) + 1990;
        return;
    }
    public String getVehicleId() {
        return this.vehicleId;
    }
    public String getRegistrationNumber() {
        return this.registrationNumber;
    }
    public String getModel() {
        return this.model;
    }
    public int getYear() {
        return this.year;
    }
}

