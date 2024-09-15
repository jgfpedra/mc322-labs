package classes.taxi;

import java.util.LocalDateTime;

//TODO: resolver problemas do LocalDateTime
public class RidePayment implements Payment{
    private String paymentId;
    private String rideId;
    private LocalDateTime rideStartTime;
    private float rideDistance;
    private float amount;
    private PaymentOption paymentMethod;

    @Override
    public float calculateValue() {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public void processPayment() {
        // TODO Auto-generated method stub
        
    }
}
