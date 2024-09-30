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
    public Database(boolean load){
        if(load){
            this.load();
        }
    }
    public List<Passenger> getPassengers(){
        return this.passengers;
    }
    public List<Cabbie> getCabbies(){
        return this.cabbies;
    }
    public List<Vehicle> getVehicles(){
        return this.vehicles;
    }
    public List<Ride> getRides(){
        return this.rides;
    }
    public List<RidePayment> getRidePayments(){
        return this.paymentMethods;
    }
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
    private <T> void update(T newItem, List<T> data){
        for(int i=0;i<data.size();i++){
            Object item = data.get(i);
            if(item.equals(newItem)){
                data.set(i, newItem);
            }
        }
    }
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
    // Salvar na primeira execucao
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
    // Load depois de sair
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