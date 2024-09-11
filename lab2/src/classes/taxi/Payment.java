package classes.taxi;
public class Payment {
    //Adicionar os atributos da classe Payment
	private int paymentId;
	private int rideId;
	private float amount;
	private String paymentMethod;
    //Adicionar os métodos da classe Payment

	public Payment(int paymentId, int rideId, float amount, String paymentMethod){
		if(paymentMethod == "Credit Card" || paymentMethod == "Debit Card" || paymentMethod == "Cash"){
			this.paymentId = paymentId;
			this.rideId = rideId;
			this.amount = amount;
			this.paymentMethod = paymentMethod;
		}else{
			//TODO: fazer erro
		}
	}
    // getters and setters 
    // toString
}
