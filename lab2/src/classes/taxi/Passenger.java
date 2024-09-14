package classes.taxi;

/**
 * Represents a passenger in the taxi system.
 * <p>
 * The {@link Passenger} class extends the {@link Person} class to include additional attributes and methods
 * specific to passengers. It includes a unique user ID and overrides methods to register and update passenger
 * details.
 * </p>
 */
public class Passenger extends Person{
	private int userId;
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
    public Passenger(int userId, String name, String email, String phone) {
        this.userId = userId;
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
        super.register(name, email, phone);
    }
    /**
     * Updates a specific field of the passenger with a new value.
     * <p>
     * This method overrides the {@link Person#update(String, String)} method to update the passenger's name,
     * email, or phone number based on the field parameter. Only valid fields are "1", "2", and "3".
     * </p>
     *
     * @param field The field to update. Valid values are:
     *              <ul>
     *                  <li>"1" - name</li>
     *                  <li>"2" - email</li>
     *                  <li>"3" - phone</li>
     *              </ul>
     * @param newValue The new value to set for the specified field.
     */
    @Override
    public void update(String field, String newValue){
        if(field == "1" || field == "2" || field == "3")
            super.update(field, newValue);
    }
    /**
     * Returns the unique identifier for this passenger.
     *
     * @return The user ID of the passenger.
     */
    public int getUserId() {
        return userId;
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
        return "Passenger [name=" + name + ", userId=" + userId + ", email=" + email + ", phone=" + phone + "]";
    }
}
