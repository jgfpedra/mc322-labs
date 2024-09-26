package cabbieManager;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Represents the payment details for a specific ride in the taxi service.
 * <p>
 * The {@link RidePayment} class implements the {@link Payment} interface and handles the calculation
 * of the ride fare based on distance, time of day, and chosen payment method.
 * </p>
 */
public class RidePayment implements Payment{
    private String paymentId;
    private String rideId;
    private LocalDateTime rideStartTime;
    private float rideDistance;
    private float amount;
    private PaymentOption paymentMethod;

    /**
     * Constructs a new RidePayment with the specified ride details.
     *
     * @param rideId The ID of the ride associated with this payment.
     * @param rideStartTime The start time of the ride.
     * @param rideDistance The distance of the ride.
     * @param paymentMethod The chosen payment method as a string.
     */
    public RidePayment(String rideId, LocalDateTime rideStartTime, float rideDistance, String paymentMethod){
        this.rideId = rideId;
        this.rideStartTime = rideStartTime;
        this.rideDistance = rideDistance;
        this.paymentMethod = parsePaymentMethod(paymentMethod);
    }
    /**
     * Calculates the total value of the ride payment based on distance and time of day.
     *
     * @return The calculated payment amount as a float.
     */
    @Override
    public float calculateValue() {
        float rideDistanceRounded = Math.round(rideDistance * 100.0f) / 100.0f;
        if (isBetweenNightOurs(this.rideStartTime)) {
            // Noturno
            if (rideDistanceRounded <= 5.00f) {
                this.amount = 6.00f + (2.50f * rideDistanceRounded);
            } else if (rideDistanceRounded <= 10.00f) {
                this.amount = 5.00f + (3.00f * rideDistanceRounded);
            } else if (rideDistanceRounded <= 15.00f) {
                this.amount = 4.50f + (3.50f * rideDistanceRounded);
            } else if (rideDistanceRounded <= 20.00f) {
                this.amount = 4.00f + (4.50f * rideDistanceRounded);
            } else {
                this.amount = 3.50f + (4.00f * rideDistanceRounded);
            }
        } else {
            // Diurno
            if (rideDistanceRounded <= 5.00f) {
                this.amount = 5.00f + (2.00f * rideDistanceRounded);
            } else if (rideDistanceRounded <= 10.00f) {
                this.amount = 4.00f + (2.50f * rideDistanceRounded);
            } else if (rideDistanceRounded <= 15.00f) {
                this.amount = 3.50f + (3.00f * rideDistanceRounded);
            } else if (rideDistanceRounded <= 20.00f) {
                this.amount = 3.00f + (4.00f * rideDistanceRounded);
            } else {
                this.amount = 2.50f + (3.50f * rideDistanceRounded);
            }
        }

        // Calculate total amount including payment fee, ensuring correct rounding
        float totalAmount = this.amount + this.paymentMethod.calculatePaymentFee(amount);
        return Math.round(totalAmount * 100.0f) / 100.0f; // Round final result to 2 decimal places
    }
    /**
     * Processes the payment, displaying payment method and amount.
     */
    @Override
    public void processPayment() {
        float valueRounded = Math.round(this.calculateValue() * 100.0f) / 100.0f;
        System.out.println("A forma de pagamento escolhida foi: " + this.paymentMethod.getPaymentName());
        System.out.println("Valor da corrida definido: " + valueRounded);
    }
    /**
     * Returns the payment ID.
     *
     * @return The payment ID.
     */
    public String getPaymentId(){
        return paymentId;
    }
    /**
     * Returns the ride ID associated with this payment.
     *
     * @return The ride ID.
     */
    public String getRideId(){
        return rideId;
    }
    /**
     * Returns the payment method used for this payment.
     *
     * @return The payment method.
     */
    public PaymentOption getPaymentMethod(){
        return paymentMethod;
    }
    /**
     * Checks if the ride time is during night hours (18:00 to 06:00).
     *
     * @param time The time to check.
     * @return True if the time is during night hours, false otherwise.
     */
    private static boolean isBetweenNightOurs(LocalDateTime time){
        LocalTime start = LocalTime.of(18, 0); // 18:00
        LocalTime end = LocalTime.of(6, 0);    // 06:00

        LocalTime rideTime = time.toLocalTime();
        return (rideTime.isAfter(start) || rideTime.equals(start)) || rideTime.isBefore(end);
    }
    /**
     * Parses a string to determine the corresponding PaymentOption.
     *
     * @param paymentMethod The payment method as a string.
     * @return The corresponding PaymentOption.
     * @throws IllegalArgumentException If the payment method is invalid.
     */
    private PaymentOption parsePaymentMethod(String paymentMethod) {
        switch (paymentMethod) {
            case "Cartão de Crédito":
                return PaymentOption.CREDIT_CARD;
            case "Cartão de Débito":
                return PaymentOption.DEBIT_CARD;
            case "PIX":
                return PaymentOption.PIX;
            case "Dinheiro":
                return PaymentOption.CASH;
            case "Voucher":
                return PaymentOption.VOUCHER;
            default:
                throw new IllegalArgumentException("Método de pagamento inválido: " + paymentMethod);
        }
    }
}
