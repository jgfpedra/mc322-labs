package cabbieManager;

import java.time.LocalDateTime;

public class RidePayment implements Payment{
    private String paymentId;
    private String rideId;
    private LocalDateTime rideStartTime;
    private double rideDistance;
    private float amount;
    private PaymentOption paymentMethod;

    public RidePayment(String rideId, LocalDateTime rideStartTime, float amount, String paymentMethod){
        //TODO: fazer logica
    }
    @Override
    public float calculateValue(){
        return this.amount + (this.paymentMethod.calculatePaymentFee(amount));
    }
    @Override
    public void processPayment() {
        System.out.println("A forma de pagamento escolhida foi: " + paymentMethod.getPaymentMethod());
    }
    public String paymentId(){
        return paymentId;
    }
    public String rideId(){
        return rideId;
    }
    public LocalDateTime rideStartTime(){
        return rideStartTime;
    }
    public double rideDistance(){
        return rideDistance;
    }
    // TODO: toString
}
