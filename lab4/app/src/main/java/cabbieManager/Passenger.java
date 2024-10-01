package cabbieManager;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.base.Objects;

import utils.PassengerInfoGenerator;

/**
 * Representa um passageiro no sistema de gerenciamento de táxis.
 *
 * Esta classe herda de {@link Person} e contém informações específicas sobre o passageiro,
 * incluindo um identificador único, e dados de contato como email, nome e telefone.
 *
 * A classe permite registrar um passageiro gerando informações aleatórias, atualizar campos específicos,
 * e acessar informações sobre o passageiro através de métodos getter e setter.
 *
 * Os campos que podem ser atualizados incluem:
 * - nome
 * - email
 * - telefone
 * - passengerId
 *
 * Métodos principais:
 * - {@link #register()} : Registra um novo passageiro com informações aleatórias.
 * - {@link #update(String, String)} : Atualiza um campo específico do passageiro.
 * - {@link #getEmail()} : Obtém o email do passageiro.
 * - {@link #getName()} : Obtém o nome do passageiro.
 * - {@link #getPhone()} : Obtém o telefone do passageiro.
 * - {@link #getPassengerId()} : Obtém o ID do passageiro.
 * - {@link #toString()} : Retorna uma representação em string do passageiro.
 * - {@link #equals(Object)} : Compara este passageiro com outro objeto para verificar se são iguais.
 */
@XmlRootElement(name = "passenger")
public class Passenger extends Person{
    private String passengerId;
    private String email;
    private String name;
    private String phone;
    public Passenger() {
    }
    /**
     * Registers a passenger by generating random information.
     * This method assigns a random email, name, phone number, and user ID to the passenger.
     *
     */
    @Override
    public void register() {
        PassengerInfoGenerator pass = new PassengerInfoGenerator();
        this.email = pass.getEmail();
        this.name = pass.getName();
        this.phone = pass.getPhone();
        this.passengerId = pass.getPassengerId();
        System.out.println("Pessoa passageira " + this.passengerId + " (" + this.name + ") criada com sucesso");
    }
    /**
     * Updates a field of the passenger.
     *
     * @param field The field to be updated.
     * @param newValue The new value for the field.
     *
     * The valid fields are:
     * <ul>
     * <li>name</li>
     * <li>email</li>
     * <li>phone</li>
     * <li>passengerId</li>
     * </ul>
     * If the field is not valid, a message is printed and the field is not updated.
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
                this.phone = newValue;
                break;
            case "passengerId":
                this.passengerId = newValue;
                break;
            default:
                System.out.println("Campo inválido");
                validField = false;
        }
        if (validField) {
            System.out.println("Campo " + field + " atualizado com sucesso!");
        }
        return;
    }
    /**
     * Obtém o email do passageiro.
     *
     * @return o email do passageiro.
     */
    @XmlElement
    public String getEmail() {
        return email;
    }
    /**
     * Define o email do passageiro.
     *
     * @param email o novo email do passageiro.
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Obtém o nome do passageiro.
     *
     * @return o nome do passageiro.
     */
    @XmlElement
    public String getName() {
        return name;
    }
    /**
     * Define o nome do passageiro.
     *
     * @param name o novo nome do passageiro.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Obtém o telefone do passageiro.
     *
     * @return o telefone do passageiro.
     */
    @XmlElement
    public String getPhone() {
        return phone;
    }
    /**
     * Define o telefone do passageiro.
     *
     * @param phone o novo telefone do passageiro.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    /**
     * Gets the ID of the passenger.
     *
     * @return the ID of the passenger (a UUID)
     */
    @XmlElement
    public String getPassengerId() {
        return this.passengerId;
    }
    public void setPassengerId(String passengerId){
        this.passengerId = passengerId;
    }
    /**
     * Returns a string representation of the object.
     *
     * The format is: "email name phone passengerId"
     *
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        return "Passenger: " + this.email + this.name + this.phone + this.passengerId;
    }
    /**
     * Compara este passageiro com outro objeto para verificar se são iguais.
     *
     * Dois passageiros são considerados iguais se seus IDs (passengerId) forem iguais.
     *
     * @param o o objeto a ser comparado com este passageiro.
     * @return true se o objeto for igual a este passageiro, caso contrário, false.
     */
    @Override
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        Passenger pas = (Passenger) o;
        return Objects.equal(this.passengerId, pas.getPassengerId());
    }
}
