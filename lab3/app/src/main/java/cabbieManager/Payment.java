package cabbieManager;

/**
 * Interface representing a payment system for the taxi service.
 * <p>
 * Classes implementing this interface must provide concrete implementations
 * for calculating payment values and processing payments.
 * </p>
 */
public interface Payment {
    /**
     * Calculates the total value of the payment.
     *
     * @return The calculated payment amount as a float.
     */
    public float calculateValue();
    /**
     * Processes the payment.
     * <p>
     * This method should include the logic for executing the payment process,
     * such as interacting with a payment gateway or updating transaction records.
     * </p>
     */
    public void processPayment();
}