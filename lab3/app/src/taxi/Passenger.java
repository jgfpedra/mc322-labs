package taxi;

/**
 * Represents a passenger in the taxi system.
 * <p>
 * The {@link Passenger} class extends the {@link Person} class to include additional attributes and methods
 * specific to passengers. It includes a unique user ID and overrides methods to register and update passenger
 * details.
 * </p>
 */
public class Passenger extends Person{
	private String passengerId;
    /**
     * Constructs a new passenger with the specified details.
     * <p>
     * This constructor initializes the passenger's user ID and registers the passenger with the provided name,
     * email, and phone number.
     * </p>
     *
     * @param userId The unique identifier for this passenger.
     * @param name The name of the passenger.
     * @param email The email address of the passenger.
     * @param phone The phone number of the passenger.
     */
    public Passenger(String passengerId, String name, String email, String phone) {
        this.passengerId = passengerId;
        this.register(name, email, phone);
    }
    /**
     * Registers a new passenger with the provided details.
     * <p>
     * This method overrides the {@link Person#register(String, String, String)} method to register the passenger
     * with the provided name, email, and phone number.
     * </p>
     *
     * @param name The name of the passenger.
     * @param email The email address of the passenger.
     * @param phone The phone number of the passenger.
     */
    @Override
    public void register(String name, String email, String phone) {
        super.name = name;
        super.email = email;
        super.phone = phone;
    }
    /**
     * Updates a specific field of the passenger based on the given field identifier.
     * <p>
     * This method overrides the {@code update} method from the {@code Person} class. It first checks if
     * the {@code field} parameter is one of the valid identifiers ("1", "2", or "3"). If the identifier is valid,
     * it calls the superclass's {@code update} method to perform the actual update.
     * </p>
     *
     * @param field The identifier of the field to be updated. Valid values are:
     *              <ul>
     *                  <li>"1" - Update the name</li>
     *                  <li>"2" - Update the email</li>
     *                  <li>"3" - Update the phone number</li>
     *              </ul>
     * @param newValue The new value to set for the specified field.
     */
    @Override
    public void update(String field, String newValue){
        System.out.println(field);
        if(field.equals("1") || field.equals("2") || field.equals("3")){
            super.update(field, newValue);
        }
    }
    /**
     * Returns the unique identifier for this passenger.
     *
     * @return The user ID of the passenger.
     */
    public String getUserId() {
        return passengerId;
    }
    /**
     * Returns a string representation of this passenger.
     * <p>
     * The string representation includes the passenger's name, user ID, email, and phone number.
     * </p>
     *
     * @return A string representation of the passenger.
     */
    @Override
    public String toString() {
        return "Passenger [name=" + name + ", passengerId=" + passengerId + ", email=" + email + ", phone=" + phone + "]";
    }
}
