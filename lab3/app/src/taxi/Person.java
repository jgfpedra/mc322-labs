package taxi;

/**
 * Represents a person in the taxi system.
 * <p>
 * The {@link Person} class is an abstract class that provides common attributes and methods
 * for different types of people in the system, such as users or cabbies. It includes attributes
 * like name, email, and phone, and provides methods to register, update, and retrieve these attributes.
 * </p>
 */
public abstract class Person{
    protected String name;
    protected String email;
    protected String phone;

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
     * Updates a specific field of the person based on the given field identifier.
     * <p>
     * This method updates the name, email, or phone number of the person based on the provided field identifier.
     * The valid field identifiers are "1" for name, "2" for email, and "3" for phone number. The corresponding
     * field is updated with the new value provided. If an invalid field identifier is passed, no update is performed.
     * </p>
     *
     * @param field The identifier of the field to be updated. This should be one of the following:
     *              <ul>
     *                  <li>"1" - Update the name</li>
     *                  <li>"2" - Update the email</li>
     *                  <li>"3" - Update the phone number</li>
     *              </ul>
     * @param newValue The new value to set for the specified field. This value is used to update the field
     *                 identified by {@code field}.
     */
    public void update(String field, String newValue){
        // 1 - Atualiza nome
        if(field.equals("1")){
            System.out.print("Campo \"nome\"");
            this.name = newValue;
        }
        // 2 - Atualiza email
        else if (field.equals("2")) {
            System.out.print("Campo \"email\"");
            this.email = newValue;
        }
        // 3 - Atualiza telefone
        else if (field.equals("3")) {
            System.out.print("Campo \"telefone\"");
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