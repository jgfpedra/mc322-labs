package cabbieManager;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.google.common.base.Objects;

import utils.LocalDateTimeAdapter;

/**
 * Classe que representa uma corrida no sistema de gerenciamento de táxis.
 *
 * Esta classe contém informações sobre a corrida, incluindo os detalhes do passageiro,
 * motorista, veículo, localizações de pickup e drop, distância, status da corrida e
 * horários de início e fim.
 *
 * Atributos:
 * - rideId: ID único da corrida.
 * - passengerId: ID do passageiro que solicitou a corrida.
 * - cabbieId: ID do motorista que aceitou a corrida.
 * - vehicleId: ID do veículo utilizado na corrida.
 * - pickupLocation: Localização de saida.
 * - dropLocation: Localização de chegada.
 * - distance: Distância da corrida.
 * - status: Status atual da corrida.
 * - startTime: Horário de início da corrida.
 * - endTime: Horário de fim da corrida.
 */
@XmlRootElement(name = "ride")
public class Ride {
    private String rideId;
    private String passengerId;
    private String cabbieId;
    private String vehicleId;
    private Location pickupLocation;
    private Location dropLocation;
    private float distance;
    private String status;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    public Ride(){
    }
    public Ride(String passengerId) {
        this.passengerId = passengerId;
    }
    /**
     * Requests a ride by a passenger.
     *
     * @param pickupLocation  the location where the passenger wants to be picked up
     * @param dropLocation    the location where the passenger wants to be dropped off
     *
     * The ride status is set to "REQUESTED".
     * The startTime is set to the current time.
     *
     * A message is printed to the console with the information of the ride.
     */
    public void requestRide(String pickupLocation, String dropLocation) {
        this.rideId = UUID.randomUUID().toString();
        this.pickupLocation = this.returnLocation(pickupLocation);
        this.dropLocation= this.returnLocation(dropLocation);
        this.startTime = LocalDateTime.now();
        System.out.println("Corrida chamada por pessoa passageira " + this.passengerId + " de " + pickupLocation + " para " + dropLocation);
        this.updateRideStatus("CHAMADA", null, null);
        this.distance = this.calculateDistance();
    }
    /**
     * Returns a Location given a location name.
     *
     * @param locationName  the name of the location
     *
     * If the location is not found, a default value of AEROPORTO is returned.
     *
     * @return a Location object
     */
    private Location returnLocation(String locationName) {
        return Location.valueOfName(locationName);
    }
    /**
     * Calculates the distance between the pickup and drop locations.
     *
     * The distance is calculated as the Euclidean distance between the two points.
     *
     * @return the calculated distance.
     */
    public float calculateDistance() {
        int x_pickup = pickupLocation.getX();
        int y_pickup = pickupLocation.getY();
        int x_drop = dropLocation.getX();
        int y_drop = dropLocation.getY();
        float distance = (float) Math.sqrt(Math.pow(x_drop - x_pickup, 2) + Math.pow(y_drop - y_pickup, 2));
        distance = Math.round(distance * 100) / 100.0f;
        System.out.println(("Distância calculada: " + distance));
        return distance;
    }
    /**
     * Atualiza o status da corrida.
     *
     * Se o status for "ACEPTED", armazena o ID do motorista e do veiculo que
     * aceitou a corrida.
     *
     * @param status  o novo status da corrida
     * @param cabbieId o ID do motorista que aceitou a corrida, se status for
     *                "ACCEPTED"
     * @param vehicleId o ID do veiculo que aceitou a corrida, se status for
     *                  "ACCEPTED"
     */
    public void updateRideStatus(String status, String cabbieId, String vehicleId) {
        this.status = status;
        if (status.equals("ACEITA")) {
            this.cabbieId = cabbieId;
            this.vehicleId = vehicleId;
            System.out.println(("Corrida aceita por pessoa motorista " + this.cabbieId));
        } else {
            System.out.println("Status da corrida: " + this.status);
        }
    }
    /**
    * Finaliza a corrida.
    *
    * O horário de fim é definido como o horário atual e uma mensagem é impressa.
    */
    public void completeRide() {
        System.out.println("Corrida finalizada");
        this.endTime = LocalDateTime.now();
    }
    /**
     * Obtém a localização de pickup desta corrida.
     *
     * @return a localização de pickup (um objeto Location)
     */
    @XmlElement
    public Location getPickLocation(){
        return this.pickupLocation;
    }
    /**
     * Sets the pickup location of this ride.
     * @param pickupLocation The new pickup location.
     */
    public void setPickupLocation(Location pickupLocation) {
        this.pickupLocation = pickupLocation;
    }
    /**
     * Obtém a localização de drop desta corrida.
     *
     * @return a localização de drop (um objeto Location)
     */
    @XmlElement
    public Location getDropLocation(){
        return this.dropLocation;
    }
    /**
     * Sets the drop location of this ride.
     * @param dropLocation The new drop location.
     */
    public void setDropLocation(Location dropLocation) {
        this.dropLocation = dropLocation;
    }
    /**
     * Gets the ID of this ride.
     *
     * @return the ID of this ride (a UUID)
     */
    @XmlElement
    public String getRideId() {
        return this.rideId;
    }
    /**
     * Define o ID desta corrida.
     *
     * @param rideId O novo ID da corrida.
     */
    public void setRideId(String rideId){
        this.rideId = rideId;
    }
    /**
     * Gets the start time of this ride.
     *
     * @return the start time of this ride (a LocalDateTime)
     */
    @XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
    public LocalDateTime getStartTime() {
        return this.startTime;
    }
    /**
     * Gets the end time of this ride.
     *
     * @return the end time of this ride (a LocalDateTime)
     */
    @XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
    public LocalDateTime getEndTime() {
        return this.endTime;
    }
    /**
     * Gets the distance of this ride.
     *
     * @return the distance of this ride (a float)
     */
    @XmlElement
    public float getRideDistance() {
        return this.distance;
    }
    /**
     * Obtém o ID do passageiro desta corrida.
     *
     * @return o ID do passageiro (uma String)
     */
    @XmlElement
    public String getPassengerId() {
        return passengerId;
    }
    /**
     * Define o ID do passageiro desta corrida.
     *
     * @param passengerId O novo ID do passageiro.
     */
    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }
    /**
     * Obtém o ID do motorista desta corrida.
     *
     * @return o ID do motorista (uma String)
     */
    @XmlElement
    public String getCabbieId() {
        return cabbieId;
    }
    /**
     * Define o ID do motorista desta corrida.
     *
     * @param cabbieId O novo ID do motorista.
     */
    public void setCabbieId(String cabbieId) {
        this.cabbieId = cabbieId;
    }

    /**
     * Obtém o ID do veículo utilizado nesta corrida.
     *
     * @return o ID do veículo (uma String)
     */
    @XmlElement
    public String getVehicleId() {
        return vehicleId;
    }
    /**
     * Define o ID do veículo utilizado nesta corrida.
     *
     * @param vehicleId O novo ID do veículo.
     */
    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    /**
     * Obtém o status atual desta corrida.
     *
     * @return o status da corrida (uma String)
     */
    @XmlElement
    public String getStatus() {
        return status;
    }
    /**
     * Define o status desta corrida.
     *
     * @param status O novo status da corrida.
     */
    public void setStatus(String status) {
        this.status = status;
    }
    /**
     * Obtém a distância total da corrida.
     *
     * @return a distância da corrida (um float)
     */
    @XmlElement
    public float getDistance() {
        return distance;
    }
    /**
     * Define a distância desta corrida.
     *
     * @param distance A nova distância da corrida.
     */
    public void setDistance(float distance) {
        this.distance = distance;
    }
    /**
     * Compara esta corrida com outra.
     *
     * @param o O objeto a ser comparado com esta corrida.
     * @return true se as corridas tiverem o mesmo ID, false caso contrário.
     */
    @Override
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        Ride pas = (Ride) o;
        return Objects.equal(this.rideId, pas.getRideId());
    }
    /**
     * Retorna uma representação em String desta corrida.
     *
     * @return uma string representando a corrida, incluindo o ID.
     */
    @Override
    public String toString() {
        return "Ride: " + this.rideId;
    }
}
