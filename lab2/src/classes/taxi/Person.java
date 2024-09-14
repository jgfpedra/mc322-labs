package classes.taxi;

/**
 * Represents a person in the taxi system.
 * <p>
 * The {@link Person} class is an abstract class that provides common attributes and methods
 * for different types of people in the system, such as users or cabbies. It includes attributes
 * like name, email, and phone, and provides methods to register, update, and retrieve these attributes.
 * </p>
 */
public abstract class Person{
    public String name;
    public String email;
    public String phone;

    /**
     * Registers a new person with the provided details.
     * <p>
     * This method initializes the person's name, email, and phone number.
     * </p>
     *
     * @param name The name of the person.
     * @param email The email address of the person.
     * @param phone The phone number of the person.
     */
    public void register(String name, String email, String phone){
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
    /**
     * Updates a specific field of the person with a new value.
     * <p>
     * This method updates the person's name, email, or phone number based on the field parameter.
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
    public void update(String field, String newValue){
        // 1 - Atualiza nome
        if(field == "1"){
            this.name = newValue;
        }
        // 2 - Atualiza email
        else if (field == "2") {
            this.email = newValue;
        }
        // 3 - Atualiza telefone
        else if (field == "3") {
            this.phone = newValue;
        }
    }
    /**
     * Returns the name of the person.
     *
     * @return The name of the person.
     */
    public String getName() {
        return name;
    }
    /**
     * Returns a string representation of this person.
     * <p>
     * The string representation includes the name, email, and phone number of the person.
     * </p>
     *
     * @return A string representation of the person.
     */
    @Override
    public String toString() {
        return "Person [name=" + name + ", email=" + email + ", phone=" + phone + "]";
    }
}