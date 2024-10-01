
package cabbieManager;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.base.Objects;

import utils.CabbieInfoGenerator;

/**
 * Representa um motorista de táxi (cabbie) no sistema de gerenciamento de táxis.
 *
 * Esta classe herda de {@link Person} e contém informações específicas sobre o motorista,
 * incluindo um identificador único, taxa de corrida, número da licença e estado de disponibilidade.
 *
 * A classe permite registrar um motorista gerando informações aleatórias, atualizar campos específicos,
 * e acessar informações sobre o motorista através de métodos getter e setter.
 *
 * Os campos que podem ser atualizados incluem:
 * - nome
 * - email
 * - telefone
 * - cabbieId
 * - taxa
 * - número da licença
 * - estado de disponibilidade (isBusy)
 *
 * Métodos principais:
 * - {@link #register()} : Registra um novo motorista com informações aleatórias.
 * - {@link #update(String, String)} : Atualiza um campo específico do motorista.
 * - {@link #getCabbieId()} : Obtém o ID do motorista.
 * - {@link #toString()} : Retorna uma representação em string do motorista.
 *
 * @see Person
 */
@XmlRootElement(name = "cabbies")
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
     * Updates a field of the cabbie.
     *
     * @param field The field to be updated.
     * @param newValue The new value for the field.
     *
     * The valid fields are:
     * <ul>
     * <li>name</li>
     * <li>email</li>
     * <li>phone</li>
     * <li>cabbieId</li>
     * <li>rate</li>
     * <li>licenseNumber</li>
     * </ul>
     *
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
                System.out.println("Campo inválido");
                break;
        }
        if (validField) {
            System.out.println("Campo " + field + " foi atualizado com sucesso!");
        }
        return;
    }
    /**
     * Gets the ID of the cabbie.
     *
     * @return the ID of the cabbie (a UUID)
     */
    @XmlElement
    public String getCabbieId() {
        return this.cabbieId;
    }
    /**
     * Define o ID do motorista.
     *
     * @param cabbieId o novo ID do motorista.
     */
    public void setCabbieId(String cabbieId) {
        this.cabbieId = cabbieId;
    }
    /**
     * Obtém o nome do motorista.
     *
     * @return o nome do motorista.
     */
    @XmlElement
    public String getName() {
        return this.name;
    }
    /**
     * Define o nome do motorista.
     *
     * @param name o novo nome do motorista.
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * Obtém o estado de disponibilidade do motorista.
     *
     * @return true se o motorista estiver ocupado, caso contrário, false.
     */
    @XmlElement
    public boolean getIsBusy(){
        return this.isBusy;
    }
    /**
     * Define o estado de disponibilidade do motorista.
     *
     * @param value o novo estado de disponibilidade do motorista.
     */
    public void setIsBusy(boolean value){
        this.isBusy = value;
    }
    /**
     * Obtém a taxa de corrida do motorista.
     *
     * @return a taxa do motorista.
     */
    @XmlElement
    public float getRate() {
        return rate;
    }
    /**
     * Define a taxa de corrida do motorista.
     *
     * @param rate a nova taxa do motorista.
     */
    public void setRate(float rate) {
        this.rate = rate;
    }
    /**
     * Obtém o número da licença do motorista.
     *
     * @return o número da licença do motorista.
     */
    @XmlElement
    public String getLicenseNumber() {
        return licenseNumber;
    }
    /**
     * Define o número da licença do motorista.
     *
     * @param licenseNumber o novo número da licença do motorista.
     */
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
    /**
     * Compara este motorista (cabbie) com outro objeto para verificar se são iguais.
     *
     * Dois motoristas são considerados iguais se seus IDs (cabbieId) forem iguais.
     *
     * @param o o objeto a ser comparado com este motorista.
     * @return true se o objeto for igual a este motorista, caso contrário, false.
     */
    @Override
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        Cabbie pas = (Cabbie) o;
        return Objects.equal(this.cabbieId, pas.getCabbieId());
    }
}
