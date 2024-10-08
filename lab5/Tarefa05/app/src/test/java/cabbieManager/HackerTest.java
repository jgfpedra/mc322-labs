package cabbieManager;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.Test;

import databaseManager.Database;
import exceptions.InvalidRideDistanceException;
import exceptions.UnsupportedObjectTypeException;

public class HackerTest {

    //IMPLEMENTE ABAIXO OS TESTES UNITÁRIOS ADICIONAIS PARA OS 3 TRATAMENTOS DE ERRO IDENTIFICADOS
    /**
     * Tests the {@link RidePayment} constructor to ensure that an
     * {@link IllegalArgumentException} is thrown when an invalid
     * payment option is provided.
     * <p>
     * Specifically, this test verifies that attempting to create
     * a {@link RidePayment} instance with "Cheque" as the payment
     * option results in an exception with the message
     * "Payment method not accepted".
     * </p>
     *
     * @throws IllegalArgumentException if the payment option is invalid.
     */
    @Test
    public void testRidePaymantOption_throwsIllegalArgumentException_InvalidPaymentOption() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            RidePayment payTest = new RidePayment("rideId", LocalDateTime.of(2022, 1, 1, 10, 0), 5.0f, "Cheque");
        });
        assertEquals("Payment method not accepted", exception.getMessage());
    }
    /**
     * Tests the {@link Ride#requestRide(String, String)} method to ensure that
     * an {@link IllegalArgumentException} is thrown when the pickup and
     * drop locations are the same.
     * <p>
     * This test verifies that invoking the requestRide method with
     * "Aeroporto" as both the pickup and drop location results in
     * an exception with the message
     * "Pickup location and drop location cannot be the same".
     * </p>
     *
     * @throws IllegalArgumentException if the pickup and drop locations are identical.
     */
    @Test
    public void testRideRequest_throwsIllegalArgumentException_InvalidDropLocation() {
        Ride rideTest = new Ride();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            rideTest.requestRide("Aeroporto", "Aeroporto");
        });
        assertEquals("Pickup location and drop location cannot be the same", exception.getMessage());
    }
    /**
     * Tests the behavior of updating various objects (Cabbie, Passenger, Vehicle)
     * when illegal object types are provided.
     * <p>
     * This test verifies that attempting to update a Cabbie, Passenger,
     * or Vehicle with invalid fields results in an
     * {@link IllegalArgumentException} being thrown.
     * Each case checks that the correct exception message is returned.
     * </p>
     *
     * @throws IllegalArgumentException if any of the updates are attempted
     * with invalid parameters.
     */
    @Test
    public void testeClasses_throwsIllegalArgumentException_InvalidUpdateArgument() {
        Cabbie cabbieTest = new Cabbie();
        Passenger passengerTest = new Passenger();
        Vehicle vehicleTest = new Vehicle();
        cabbieTest.register();
        passengerTest.register();
        vehicleTest.registerVehicle();
        Exception cabbieException = assertThrows(IllegalArgumentException.class, () -> {
            cabbieTest.update("RG", "33333333333");
        });
        assertEquals("Field RG is not valid", cabbieException.getMessage()); // Replace "..." with the expected message
        // Assert that updating passenger throws an exception
        Exception passengerException = assertThrows(IllegalArgumentException.class, () -> {
            passengerTest.update("CPF", "33333333333");
        });
        assertEquals("Field CPF is not valid", passengerException.getMessage()); // Replace "..." with the expected message
        // Assert that updating vehicle throws an exception
        Exception vehicleException = assertThrows(IllegalArgumentException.class, () -> {
            vehicleTest.updateVehicle("ID_Passageiro", UUID.randomUUID().toString());
        });
        assertEquals("Field ID_Passageiro is not valid", vehicleException.getMessage()); // Replace "..." with the expected message
    }
    //-----------------------------------------------------------------------------------------------------
    // CONJUNTO DE TESTES JÁ FEITO PARA A TAREFA (NÃO PODE SER ALTERADO)
    /**
     * Tests if the method update throws an IllegalArgumentException when the phone number is not valid.
     *
     * The method update should throw an IllegalArgumentException when the phone number is not valid.
     *
     * This test case tests this by calling the method update with an invalid phone number and asserting that an IllegalArgumentException is thrown.
     * The expected error message is "Input contains non-numeric characters: 999999999a"
     */
    @Test
    public void testUpdateCabbie_throwsIllegalArgumentException_InvalidPhoneArgument() {
        Cabbie cabbieTest = new Cabbie();
        cabbieTest.register();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cabbieTest.update("phone", "999999999a");
        });
        assertEquals("Input contains non-numeric characters: 999999999a", exception.getMessage());
    }
    /**
     * Tests if the method requestRide throws an IllegalArgumentException when the drop location is not one of the valid locations.
     *
     * The method requestRide should throw an IllegalArgumentException when the drop location is not one of the valid locations.
     *
     * This test case tests this by calling the method requestRide with an invalid drop location and asserting that an IllegalArgumentException is thrown.
     * The expected error message is "Invalid location name: Museu".
     */
    @Test
    public void testRide_thorwsIllegalArgumentException_InvalidDropLocation() {
        Ride testRide = new Ride();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            testRide.requestRide("Aeroporto", "Museu"); // Invalid phone number with non-numeric characters
        });
        assertEquals("Invalid location name: Museu", exception.getMessage());
    }
    /**
     * Tests if the constructor RidePayment throws a NullPointerException when the start time of the ride to be paid is null.
     *
     * The constructor RidePayment should throw a NullPointerException when the start time of the ride to be paid is null.
     * This test case tests this by calling the constructor with a null start time and asserting that a NullPointerException is thrown.
     * The expected error message is "Start time of the ride to be paid cannot be null".
     */
    @Test
    public void testRidPayment_throwsNullPointforStartTime() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            RidePayment rpTest = new RidePayment("rideId", null, 5.0f, "Dinheiro"); // Invalid phone number with non-numeric characters
        });
        assertEquals("Start time of the ride to be paid cannot be null", exception.getMessage());
    }
    /**
     * Tests if the method insert from the class Database throws an UnsupportedObjectTypeException when trying to insert an object of an unsupported type.
     *
     * The method insert should throw an UnsupportedObjectTypeException when trying to insert an object of an unsupported type.
     * This test case tests this by calling the method insert with an object of an unsupported type and asserting that an UnsupportedObjectTypeException is thrown.
     * The expected error message is "Trying to insert unsupported object type for database insertion".
     */
    @Test
    public void testDatabase_InsertIllegalTypeObject() {
        Location loc = Location.AEROPORTO;
        Database db = new Database();
        Exception exception = assertThrows(UnsupportedObjectTypeException.class, () -> {
            db.insert(loc);
        });
        assertEquals("Trying to insert unsupported object type for database insertion", exception.getMessage());
    }
    /**
     * Tests if the constructor RidePayment throws an InvalidRideDistanceException when the ride distance is equal to zero.
     *
     * The constructor RidePayment should throw an InvalidRideDistanceException when the ride distance is equal to zero.
     * This test case tests this by calling the constructor with a ride distance of zero and asserting that an InvalidRideDistanceException is thrown.
     * The expected error message is "Ride distance must be greater than zero".
     */
    @Test
    public void testRidePayment_throwsInvalidRideDistanceEqualsZero() {
        Exception exception = assertThrows(InvalidRideDistanceException.class, () -> {
            RidePayment rp = new RidePayment("rideId", LocalDateTime.of(2022, 1, 1, 10, 0), 0.0f, "Dinheiro");
        });
        assertEquals("Ride distance must be greater than zero", exception.getMessage());
    }
}
