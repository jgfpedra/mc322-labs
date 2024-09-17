package classes.taxi;

import java.time.LocalDateTime;

public class RidePayment implements Payment{
    private String paymentId;
    private String rideId;
    private LocalDateTime rideStartTime;
    private float rideDistance;
    private float amount;
    private PaymentOption paymentMethod;

    @Override
    public float calculateValue(){
        return this.amount + (this.paymentMethod.calculatePaymentFee(amount));
    }
    @Override
    public void processPayment() {
        // TODO Auto-generated method stub
        
    }
}
