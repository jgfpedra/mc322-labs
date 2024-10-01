package cabbieManager;

import databaseManager.Database;

public class Main {
    public static void main(String[] args) throws Exception {
        Database db = new Database(false);
        // Create Instances
        Cabbie cab = new Cabbie();
        cab.register();
        Passenger p = new Passenger();
        p.register();
        Vehicle v = new Vehicle(cab.getCabbieId());
        v.registerVehicle();
        // Save Instances into the XML database
        db.insert(cab);
        db.insert(p);
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
        Ride ride = new Ride(db.getPassengers().get(0).getPassengerId());
        ride.requestRide("Shopping", "Estação de Trem");
        db.insert(ride);
        // Accept Ride
        cab.update("isBusy", "true");
        ride.updateRideStatus("ACEITA", cab.getCabbieId(), v.getVehicleId());
        ride.updateRideStatus("EM_PROGRESSO", null, null);
        db.update(cab);
        db.insert(ride);
        //Payment
        RidePayment payment = new RidePayment(ride.getRideId(), ride.getStartTime(), ride.getRideDistance(), "Cartão de Crédito");
        payment.processPayment();
        db.insert(payment);
        //Finish Ride
        ride.completeRide();
        cab.update("isBusy", "false");
        db.update(ride);
        db.update(cab);
        // Create Ride
        Ride ride_2 = new Ride(db.getPassengers().get(0).getPassengerId());
        ride_2.requestRide("Parque", "Biblioteca");
        db.insert(ride_2);
        // Accept Ride
        cab.update("isBusy", "true");
        ride_2.updateRideStatus("ACEITA", cab.getCabbieId(), v.getVehicleId());
        ride_2.updateRideStatus("EM_PROGRESSO", null, null);
        db.update(cab);
        db.update(ride_2);
        //Payment
        RidePayment payment2 = new RidePayment(ride_2.getRideId(), ride_2.getStartTime(), ride_2.getRideDistance(), "Pix");
        payment2.processPayment();
        db.insert(payment2);
        //Finish Ride
        ride.completeRide();
        cab.update("isBusy", "false");
        db.update(ride);
        db.update(cab);
        System.out.println("-----------------------------------");
        System.out.println("Fechando e reabrindo banco de dados\n");
        System.out.println("-----------------------------------");
        System.out.println("Printando dados do banco de dados");
        db = new Database(true);
        System.out.println(db.getCabbies());
        System.out.println(db.getPassengers());
        System.out.println(db.getVehicles());
        System.out.println(db.getRides());
        System.out.println(db.getRidePayments());
        System.out.println("-----------------------------------\n");
        System.out.println("Realizando nova corrida:");
        // Create Ride
        // Create Instances
        Ride ride_3 = new Ride(db.getPassengers().get(0).getPassengerId());
        ride_3.requestRide("Parque", "Biblioteca");
        db.insert(ride_3);
        // Accept Ride
        db.getCabbies().get(0).update("isBusy", "true");
        ride.updateRideStatus("ACEITA", db.getCabbies().get(0).getCabbieId(), db.getVehicles().get(0).getVehicleId());
        ride.updateRideStatus("EM_PROGRESSO", null, null);
        db.update(db.getCabbies().get(0));
        db.insert(ride_3);
        //Payment
        RidePayment payment_3 = new RidePayment(ride_3.getRideId(), ride_3.getStartTime(), ride_3.getRideDistance(), "Pix");
        payment_3.processPayment();
        db.insert(payment_3);
        //Finish Ride
        ride_3.completeRide();
        cab.update("isBusy", "false");
        db.update(ride_3);
        db.update(db.getCabbies().get(0));
    }
}
