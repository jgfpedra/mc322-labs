package classes.taxi;

/**
 * Represents a payment in the taxi system.
 * <p>
 * The {@link Payment} class stores information about a payment, including the payment ID, ride ID, amount,
 * and payment method. It provides methods to define a payment, access and modify payment details, and get
 * a string representation of the payment.
 * </p>
 */
public class Payment {
	private int paymentId;
	private int rideId;
	private float amount;
	private String paymentMethod;

    /**
     * Defines a new payment with the specified details.
     * <p>
     * This method initializes the payment with the provided payment ID, ride ID, amount, and payment method,
     * if the payment method is valid. Valid payment methods are "Credit Card", "Debit Card", and "Cash".
     * </p>
     *
     * @param paymentId The unique identifier for this payment.
     * @param rideId The unique identifier for the ride associated with this payment.
     * @param amount The amount of the payment.
     * @param paymentMethod The method used for the payment. Valid values are:
     *                      <ul>
     *                          <li>"Credit Card"</li>
     *                          <li>"Debit Card"</li>
     *                          <li>"Cash"</li>
     *                      </ul>
     * @return {@code true} if the payment was successfully defined; {@code false} otherwise.
     * @throws IllegalArgumentException If the payment method is not recognized.
     */
	public boolean definePagamento(int paymentId, int rideId, float amount, String paymentMethod){
		if(paymentMethod.equals("Credit Card") || paymentMethod.equals("Debit Card") || paymentMethod.equals("Cash")){
			this.paymentId = paymentId;
			this.rideId = rideId;
			this.amount = amount;
			this.paymentMethod = paymentMethod;
			return true;
		}else{
			throw new IllegalArgumentException("Forma de pagamento nao reconhecida!");
		}
	}
    /**
     * Returns a string representation of this payment.
     * <p>
     * The string representation includes the payment ID, ride ID, amount, and payment method.
     * </p>
     *
     * @return A string representation of the payment.
     */
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", rideId=" + rideId + ", amount=" + amount + ", paymentMethod="
				+ paymentMethod + "]";
	}
}
