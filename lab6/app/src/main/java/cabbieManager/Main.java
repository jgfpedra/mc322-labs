/*
 * Nome: Gabriel Henrique Pereira Lopes da Silva
 * RA: 200342
 * Nome: Joao Guilherme Ferreira Pedra
 * RA: 248349
 */
package cabbieManager;
import java.time.LocalDateTime;

import databaseManager.Database;

public class Main {
    public static void main(String[] args) throws Exception {
        //Aqui você deve realizar a simulação do funcionamento do sistema.
        //----------------------------------------------------------------
        Database db = new Database();
        // Create Instances
        Cabbie cab = new Cabbie();
        cab.register();
        Passenger p = new Passenger();
        p.register();
        BusinessPassenger bp1 = new BusinessPassenger();
        bp1.register();
        VIPPassenger vp1 = new VIPPassenger();
        vp1.register();
        Vehicle v = new Vehicle(cab.getCabbieId());
        v.registerVehicle();
        // Save Instances into the XML database
        db.insert(cab);
        db.insert(p);
        db.insert(bp1);
        db.insert(vp1);
        db.insert(v);
        // Update Instances
        cab.update("name", "Martina");
        p.update("name", "Estevão");
        v.updateVehicle("registrationNumber", "ABD123");
        // Save Instancesinto the XML database
        db.update(cab);
        db.update(p);
        db.update(v);
        // Create Ride
        // Pick the object of class BusinessPassengers
        Ride ride = new Ride(db.getPassengers().get(1));
        ride.requestRide("Shopping", "Estação de Trem");
        db.insert(ride);
        // Accept Ride
        cab.update("isBusy", "true");
        ride.updateRideStatus("ACEITA", cab, v);
        ride.updateRideStatus("EM_PROGRESSO", null, null);
        db.update(cab);
        db.insert(ride);
        //Payment
        RidePayment payment = new RidePayment(ride, ride.getStartTime(), ride.getRideDistance(), "Cartão de Crédito");
        payment.processPayment();
        db.insert(payment);
        //Finish Ride
        ride.completeRide();
        cab.update("isBusy", "false");
        db.update(ride);
        db.update(cab);
        // Create Ride
        Ride ride_2 = new Ride(db.getPassengers().get(0));
        ride_2.requestRide("Parque", "Biblioteca");
        db.insert(ride_2);
        // Accept Ride
        cab.update("isBusy", "true");
        ride_2.updateRideStatus("ACEITA", cab, v);
        ride_2.updateRideStatus("EM_PROGRESSO", null, null);
        db.update(cab);
        db.update(ride_2);
        //Payment
        RidePayment payment2 = new RidePayment(ride_2, ride_2.getStartTime(), ride_2.getRideDistance(), "Pix");
        payment2.processPayment();
        db.insert(payment2);
        //Finish Ride
        ride.completeRide();
        cab.update("isBusy", "false");
        db.update(ride);
        db.update(cab);
        System.out.println("-----------------------------------");
        System.out.println("Fechando e reabrindo banco de dados\n");
        db = new Database(true);
        System.out.println("Printando dados:");
        System.out.println(db.getCabbies());
        System.out.println(db.getRides());
        System.out.println(db.getPayments());
        System.out.println(db.getVehicles());
        System.out.println(db.getPassengers());
        System.out.println("-----------------------------------\n");
        System.out.println("Realizando nova corrida:");
        // Create Ride
        // Pick the object instance of VIPPassenger
        VIPPassenger vipPassenger = (VIPPassenger) db.getPassengers().get(2);
        vipPassenger.setVipExpiration(LocalDateTime.now().plusDays(1));
        Ride ride_3 = new Ride(vipPassenger);
        ride_3.requestRide("Parque", "Biblioteca");
        db.insert(ride_3);
        // Accept Ride
        cab.update("isBusy", "true");
        ride_3.updateRideStatus("ACEITA", cab, v);
        ride_3.updateRideStatus("EM_PROGRESSO", cab, v);
        db.update(cab);
        db.update(ride_3);
        //Payment
        RidePayment payment3 = new RidePayment(ride_3, ride_3.getStartTime(), ride_3.getRideDistance(), "Pix");
        payment3.processPayment();
        db.insert(payment3);
        //Finish Ride
        ride.completeRide();
        cab.update("isBusy", "false");
        db.update(ride);
        db.update(cab);
    }
}