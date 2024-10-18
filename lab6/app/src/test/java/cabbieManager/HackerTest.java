package cabbieManager;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import databaseManager.Database;
import exceptions.InvalidRideDistanceException;
import exceptions.UnsupportedObjectTypeException;

public class HackerTest {
    Ride testRide = new Ride();
    @Test
    public void testUpdateCabbie_throwsIllegalArgumentException() {
        Cabbie cabbieTest = new Cabbie();
        cabbieTest.register();
        // Test that the exception is thrown with a non-numeric input
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cabbieTest.update("phone", "999999999a"); // Invalid phone number with non-numeric characters
        });
        // Verify that the exception message is correct
        assertEquals("Input contains non-numeric characters: 999999999a", exception.getMessage());
    }
    @Test
    public void testRideRequest_thorwsIllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            testRide.requestRide("Aeroporto", "Museu"); // Invalid phone number with non-numeric characters
        });
        assertEquals("Invalid location name: Museu", exception.getMessage());
    }
    @Test
    public void testRidPayment_throwsNullPointforStartTime() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            @SuppressWarnings("unused")
            RidePayment rpTest = new RidePayment(testRide.getRideId(), null, 5.0f, "Dinheiro"); // Invalid phone number with non-numeric characters
        });
        assertEquals("Start time of the ride to be paid cannot be null", exception.getMessage());
    }
    @Test
    public void testDatabase_InsertIllegalTypeObject() {
        Location loc = Location.AEROPORTO;
        Database db = new Database();
        Exception exception = assertThrows(UnsupportedObjectTypeException.class, () -> {
            db.insert(loc);
        });
        assertEquals("Trying to insert unsupported object type for database insertion", exception.getMessage());
    }
    @Test
    public void testRidePayment_throwsInalidRideDistanceEqualsZero() {
        Exception exception = assertThrows(InvalidRideDistanceException.class, () -> {
            @SuppressWarnings("unused")
            RidePayment rp = new RidePayment(testRide.getRideId(), LocalDateTime.of(2022, 1, 1, 10, 0), 0.0f, "Dinheiro");
        });
        assertEquals("Ride distance must be greater than zero", exception.getMessage());
    }
}
