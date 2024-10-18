package cabbieManager;

public enum PaymentOption {

    CREDIT_CARD("Cartão de Crédito", 1.06f),
    CASH("Dinheiro", 1.0f),
    DEBIT_CARD("Cartão de Débito", 1.04f),
    VOUCHER("Voucher", 1.03f),
    PIX("Pix", 1.01f);
    private final String name;
    private final float fee;
    PaymentOption(String name, float fee) {
        this.name = name;
        this.fee = fee;
    }
    /**
     * Returns the {@link PaymentOption} corresponding to the specified name.
     *
     * @param name the name of the payment option to retrieve
     * @return the {@link PaymentOption} associated with the given name
     * @throws IllegalArgumentException if no {@link PaymentOption} with the specified name exists
     */
    public static PaymentOption valueOfName(String name) {
        for (PaymentOption paymentOption : PaymentOption.values()) {
            if (paymentOption.name.equals(name)) {
                return paymentOption;
            }
        }
        throw new IllegalArgumentException("Payment method not accepted");
    }
    /**
     * Calculates the payment fee for a given value.
     *
     * @param value The value to calculate the fee for.
     * @return The calculated payment fee.
     */
    float calculatePaymentFee(float value) {
        return value * fee;
    }
}