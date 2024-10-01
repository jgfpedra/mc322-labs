package databaseManager;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import cabbieManager.Cabbie;
import cabbieManager.Passenger;
import cabbieManager.Ride;
import cabbieManager.RidePayment;
import cabbieManager.Vehicle;

/**
 * A classe Database gerencia o armazenamento e a recuperação de várias entidades
 * relacionadas a um sistema de gerenciamento de motoristas, incluindo passageiros,
 * motoristas, veículos, corridas e pagamentos de corridas. Ela utiliza JAXB (Java 
 * Architecture for XML Binding) para serializar e desserializar os dados em um arquivo XML.
 *
 * <p>Esta classe fornece métodos para:
 * <ul>
 *   <li>Inserir novos objetos no banco de dados (passageiros, motoristas, veículos, corridas e pagamentos de corridas).</li>
 *   <li>Atualizar objetos existentes no banco de dados.</li>
 *   <li>Carregar o estado do banco de dados a partir de um arquivo XML durante a inicialização.</li>
 *   <li>Salvar o estado atual do banco de dados no arquivo XML após modificações.</li>
 * </ul>
 *
 * <p>As entidades gerenciadas por esta classe são armazenadas em listas separadas, 
 * cada uma anotada para a serialização em XML:
 * <ul>
 *   <li>Lista de objetos Cabbie (motorista)</li>
 *   <li>Lista de objetos Passenger (passageiro)</li>
 *   <li>Lista de objetos Vehicle (veículo)</li>
 *   <li>Lista de objetos Ride (corrida)</li>
 *   <li>Lista de objetos RidePayment (pagamento de corrida)</li>
 * </ul>
 *
 * <p>O banco de dados é salvo em um arquivo chamado "database.xml" localizado no 
 * diretório "app/data/". Ao ser instanciada, a classe pode carregar diretamente 
 * este arquivo XML se especificado.
 *
 * <p>Exemplo de uso:
 * <pre>
 *     Database db = new Database(true); // Carrega o banco de dados existente
 *     Passenger passenger = new Passenger();
 *     db.insert(passenger); // Insere um novo passageiro
 * </pre>
 */
@XmlRootElement(name = "database")
public class Database{
    @XmlElementWrapper(name = "cabbies")
    @XmlElement(name = "cabbie")
    private List<Cabbie> cabbies = new ArrayList<>();
    @XmlElementWrapper(name = "passengers")
    @XmlElement(name = "passenger")
    private List<Passenger> passengers = new ArrayList<>();
    @XmlElementWrapper(name = "vehicles")
    @XmlElement(name = "vehicle")
    private List<Vehicle> vehicles = new ArrayList<>();
    @XmlElementWrapper(name = "rides")
    @XmlElement(name = "ride")
    private List<Ride> rides = new ArrayList<>();
    @XmlElementWrapper(name = "ridePayments")
    @XmlElement(name = "ridePayment")
    private List<RidePayment> paymentMethods = new ArrayList<>();
    private final File file = new File("app/data/database.xml");
    public Database(){
    }
    /**
     * Construtor que permite carregar o banco de dados ao ser instanciado.
     *
     * @param load se verdadeiro, o banco de dados é carregado a partir do arquivo XML.
     */
    public Database(boolean load){
        if(load){
            this.load();
        }
    }
    /**
     * Obtém a lista de passageiros registrados no banco de dados.
     *
     * @return a lista de passageiros.
     */
    public List<Passenger> getPassengers(){
        return this.passengers;
    }
    /**
     * Obtém a lista de motoristas registrados no banco de dados.
     *
     * @return a lista de motoristas.
     */
    public List<Cabbie> getCabbies(){
        return this.cabbies;
    }
    /**
     * Obtém a lista de veículos registrados no banco de dados.
     *
     * @return a lista de veículos.
     */
    public List<Vehicle> getVehicles(){
        return this.vehicles;
    }
    /**
     * Obtém a lista de corridas registradas no banco de dados.
     *
     * @return a lista de corridas.
     */
    public List<Ride> getRides(){
        return this.rides;
    }
    /**
     * Obtém a lista de pagamentos de corridas registrados no banco de dados.
     *
     * @return a lista de pagamentos de corridas.
     */
    public List<RidePayment> getRidePayments(){
        return this.paymentMethods;
    }
    /**
     * Insere um novo objeto no banco de dados, seja ele um passageiro, motorista, veículo,
     * corrida ou pagamento de corrida.
     *
     * @param object o objeto a ser inserido.
     */
    public void insert(Object object){
        if(object instanceof Passenger){
            this.passengers.add((Passenger) object);
        }else if(object instanceof Cabbie){
            this.cabbies.add((Cabbie) object);
        }else if(object instanceof Vehicle){
            this.vehicles.add((Vehicle) object);
        }else if(object instanceof Ride){
            this.rides.add((Ride) object);
        }else if(object instanceof RidePayment){
            this.paymentMethods.add((RidePayment) object);
        }
        this.save();
    }

    /**
     * Atualiza um objeto na lista correspondente, se ele já existir.
     *
     * @param newItem o novo item que deve substituir o existente.
     * @param data a lista onde a atualização deve ocorrer.
     * @param <T> o tipo do objeto.
     */
    private <T> void update(T newItem, List<T> data){
        for(int i=0;i<data.size();i++){
            Object item = data.get(i);
            if(item.equals(newItem)){
                data.set(i, newItem);
            }
        }
    }
    /**
     * Atualiza um objeto existente no banco de dados, seja ele um passageiro, motorista, veículo,
     * corrida ou pagamento de corrida.
     *
     * @param object o objeto a ser atualizado.
     */
    public void update(Object object){
        if(object instanceof Passenger){
            this.update((Passenger)object, this.passengers);
        }else if(object instanceof Cabbie){
            this.update((Cabbie)object, this.cabbies);
        }else if(object instanceof Vehicle){
            this.update((Vehicle)object, this.vehicles);
        }else if(object instanceof Ride){
            this.update((Ride)object, this.rides);
        }else if(object instanceof RidePayment){
            this.update((RidePayment)object, this.paymentMethods);
        }
        this.save();
    }
    /**
     * Salva o estado atual do banco de dados em um arquivo XML.
     */
    private void save(){
        try{
            JAXBContext context = JAXBContext.newInstance(Database.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(this, new FileWriter(file));
        }catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Carrega o estado do banco de dados a partir de um arquivo XML.
     */
    private void load() {
        try {
            JAXBContext context = JAXBContext.newInstance(Database.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Database loadedDatabase = (Database) unmarshaller.unmarshal(new FileReader(file));
            this.cabbies = loadedDatabase.cabbies;
            this.passengers = loadedDatabase.passengers;
            this.vehicles = loadedDatabase.vehicles;
            this.rides = loadedDatabase.rides;
            this.paymentMethods = loadedDatabase.paymentMethods;
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }
}