
package cabbieManager;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.base.Objects;

import utils.CabbieInfoGenerator;

@XmlRootElement(name="cabbie")
public class Cabbie extends Person{
    private String cabbieId;
    private float rate;
    private String licenseNumber;
    private boolean isBusy;
    private String name;

    public Cabbie() {
    }

    
    /**
     * Registers a cabbie by generating random information.
     * This method assigns a random name, email, phone number, cabbie ID, rate and
     * license number to the cabbie.
     * 
     */
    @Override
    public void register() {
        CabbieInfoGenerator cab = new CabbieInfoGenerator();
        this.name = cab.getName();
        this.email = cab.getEmail();
        this.phone = cab.getPhone();
        this.cabbieId = cab.getCabbieId();
        this.rate = cab.getRate();
        this.licenseNumber = cab.getLicenseNumber();
        this.isBusy = false;
        System.out.println("Pessoa motorista " + this.cabbieId + " (" + this.name + ") criada com sucesso");
    }
    /**
     * Updates a specified field of the cabbie with a new value.
     *
     * <p>This method updates the cabbie's attributes based on the provided field name.
     * If the field is not valid, it throws an IllegalArgumentException.</p>
     *
     * @param field the name of the attribute to update (e.g., "name", "email", "phone", "cabbieId", "rate", "licenseNumber", "isBusy")
     * @param newValue the new value to set for the specified field
     * @throws IllegalArgumentException if the specified field is not valid
     */
    @Override
    public void update(String field, String newValue){
        boolean validField = true;
        switch (field) {
            case "name":
                this.name = newValue;
                break;
            case "email":
                this.email = newValue;
                break;
            case "phone":
                this.setPhone(newValue);
                break;
            case "cabbieId":
                this.cabbieId = newValue;
                break;
            case "rate":
                this.rate = Float.parseFloat(newValue);
                break;
            case "licenseNumber":
                this.licenseNumber = newValue;
                break;
            case "isBusy":
                this.isBusy = Boolean.parseBoolean(newValue);
                break;
            default:
                validField = false;
                break;
        }
        if (validField) {
            System.out.println("Campo " + field + " foi atualizado com sucesso!");
        }
        throw new IllegalArgumentException("Field " + field + " is not valid");
    }
    /**
     * Gets the ID of the cabbie.
     *
     * @return the ID of the cabbie (a UUID)
     */
    @XmlElement(name = "cabbieId")
    public String getCabbieId() {
        return this.cabbieId;
    }
    public void setCabbieId(String cabbieId) {
        this.cabbieId = cabbieId;
    }
    @XmlElement(name = "name")
    public String getName() {
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    @XmlElement(name = "isBusy")
    public boolean getIsBusy(){
        return this.isBusy;
    }
    public void setIsBusy(boolean value){
        this.isBusy = value;
    }
    @XmlElement(name = "rate")
    public float getRate() {
        return rate;
    }
    /**
     * Sets the phone number of cabbie after validating that it contains only numeric characters.
     *
     * <p>This method checks each character of the provided phone number and throws an
     * IllegalArgumentException if any non-numeric character is found.</p>
     *
     * @param phone the phone number to set
     * @throws IllegalArgumentException if the phone number contains non-numeric characters
     */
    public void setPhone(String phone) {
        for(int i = 0; i < phone.length(); i++){
            if(!Character.isDigit(phone.charAt(i))){
                throw new IllegalArgumentException("Input contains non-numeric characters: " + phone);
            }
        }
        this.phone = phone;
    }
    public void setRate(float rate) {
        this.rate = rate;
    }
    @XmlElement(name = "licenseNumber")
    public String getLicenseNumber() {
        return licenseNumber;
    }
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }


    /**
     * Returns a string representation of the object.
     * 
     * The format is: "email name phone cabbieId rate licenseNumber"
     * 
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        return "Cabbie:" + this.cabbieId + this.name;
    }

    @Override
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        
        Cabbie pas = (Cabbie) o;
        return Objects.equal(this.cabbieId, pas.getCabbieId());
    }
}
