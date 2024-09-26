package cabbieManager;

/**
 * Enum representing various payment options available in the taxi service.
 * <p>
 * Each payment option has an associated fee percentage and a name that describes the payment method.
 * </p>
 */
public enum PaymentOption {
    CREDIT_CARD(6.00f, "Cartão de Crédito"),
    DEBIT_CARD(4.00f, "Cartão de Débito"),
    PIX(1.00f, "PIX"),
    CASH(0.00f, "Dinheiro"),
    VOUCHER(3.00f, "Voucher");

    private final float fee;
    private final String paymentMethod;

    /**
     * Constructs a PaymentOption with the specified fee and payment method name.
     *
     * @param fee The fee percentage associated with this payment option.
     * @param paymentMethod The name of the payment method.
     */
    PaymentOption(float fee, String paymentMethod){
        this.fee = fee;
        this.paymentMethod = paymentMethod;
    }
        /**
     * Calculates the payment fee based on the specified amount.
     *
     * @param amount The amount to calculate the fee for.
     * @return The calculated payment fee as a float.
     */
    public float calculatePaymentFee(float amount){
        return (this.fee / 100) * amount;
    }

    /**
     * Returns the name of the payment method.
     *
     * @return The name of the payment method.
     */
    public String getPaymentName(){
        return this.paymentMethod;
    }
}
