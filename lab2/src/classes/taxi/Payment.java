package classes.taxi;
public class Payment {
    //Adicionar os atributos da classe Payment
	private int paymentId;
	private int rideId;
	private float amount;
	private String paymentMethod;
    //Adicionar os métodos da classe Payment

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

    // getters and setters
	public int getPaymentId() {
		return paymentId;
	}
	public int getRideId() {
		return rideId;
	}
	public void setRideId(int rideId) {
		this.rideId = rideId;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	// tostring
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", rideId=" + rideId + ", amount=" + amount + ", paymentMethod="
				+ paymentMethod + "]";
	}
}
