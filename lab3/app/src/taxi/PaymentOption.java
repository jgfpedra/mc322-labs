package taxi;

public enum PaymentOption {
    CREDIT_CARD(6, "CREDIT CARD"),
    DEBIT_CARD(6, "DEBIT CARD"),
    PIX(6, "PIX"),
    CASH(6, "CASH"),
    VOUCHER(6, "VOUCHER");

    private float fee;
    private String paymentMethod;

    PaymentOption(float fee, String paymentMethod){
        this.fee = fee;
        this.paymentMethod = paymentMethod;
    }
    public float calculatePaymentFee(float amount){
        return (this.fee / 100) * amount;
    }
    public String getPaymentMethod(){
        return this.paymentMethod;
    }
}
