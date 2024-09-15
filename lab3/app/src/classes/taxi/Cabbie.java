package classes.taxi;

/**
 * Represents a cab driver (cabbie) in the taxi system.
 * <p>
 * The {@link Cabbie} class extends the {@link Person} class to include additional attributes and methods
 * specific to cab drivers. It includes attributes such as the cabbie's unique ID, rating, and license number.
 * </p>
 */
public class Cabbie extends Person{
	private int cabbieId;
	private float rating;
	private String licenseNumber;
    
	/**
     * Constructs a new cabbie with the specified details.
     * <p>
     * This constructor initializes the cabbie's ID, rating, license number, and registers the cabbie with
     * the provided name, email, and phone number.
     * </p>
     *
     * @param cabbieId The unique identifier for this cabbie.
     * @param name The name of the cabbie.
     * @param email The email address of the cabbie.
     * @param phone The phone number of the cabbie.
     * @param rating The rating of the cabbie.
     * @param licenseNumber The license number of the cabbie.
     */
    public Cabbie(int cabbieId, String name, String email, String phone, float rating, String licenseNumber) {
        this.cabbieId = cabbieId;
        this.rating = rating;
        this.licenseNumber = licenseNumber;
        this.register(name, email, phone);
    }
    /**
     * Registers a new cabbie with the provided details.
     * <p>
     * This method overrides the {@link Person#register(String, String, String)} method to register the cabbie
     * with the provided name, email, and phone number.
     * </p>
     *
     * @param name The name of the cabbie.
     * @param email The email address of the cabbie.
     * @param phone The phone number of the cabbie.
     */
    @Override
    public void register(String name, String email, String phone) {
        super.register(name, email, phone);
    }
    /**
     * Updates a specific field of the cabbie with a new value.
     * <p>
     * This method overrides the {@link Person#update(String, String)} method to update the cabbie's name,
     * email, phone number, or rating based on the field parameter. Only valid fields are "1", "2", "3", and "4".
     * </p>
     *
     * @param field The field to update. Valid values are:
     *              <ul>
     *                  <li>"1" - name</li>
     *                  <li>"2" - email</li>
     *                  <li>"3" - phone</li>
     *                  <li>"4" - rating</li>
     *              </ul>
     * @param newValue The new value to set for the specified field. For the rating field, the value should be
     *                 a valid floating-point number.
     */
    @Override
    public void update(String field, String newValue){
        if(field.equals("1") || field.equals("2") || field.equals("3")){
            super.update(field, newValue);
        } else if(field.equals("4")){
            // Atualiza rating
            System.out.print("Campo \"rating\"");
            float newValueFloat = Float.parseFloat(newValue); // String -> FLoat
            this.rating = newValueFloat;
        }
    }
    /**
     * Returns the unique identifier for this cabbie.
     *
     * @return The cabbie ID.
     */
    public int getCabbieId() {
        return cabbieId;
    }
    /**
     * Returns a string representation of this cabbie.
     * <p>
     * The string representation includes the cabbie's name, ID, rating, email, phone number, and license number.
     * </p>
     *
     * @return A string representation of the cabbie.
     */
    @Override
    public String toString() {
        return "Cabbie [name=" + name + ", cabbieId=" + cabbieId + ", email=" + email + ", rating=" + rating
                + ", phone=" + phone + ", licenseNumber=" + licenseNumber + "]";
    }
}
