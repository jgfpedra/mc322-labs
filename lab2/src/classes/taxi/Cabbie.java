package classes.taxi;

public class Cabbie extends Person{
    //Adicionar os atributos da classe Cabbie
	private int cabbieId;
	private float rating;
	private String licenseNumber;
	
    //Adicionar os métodos da classe Cabbie
    public Cabbie(int cabbieId, String name, String email, String phone, float rating, String licenseNumber) {
        this.cabbieId = cabbieId;
        this.rating = rating;
        this.licenseNumber = licenseNumber;
        this.register(name, email, phone);
    }
    @Override
    public void register(String name, String email, String phone) {
        super.register(name, email, phone);
    }
    @Override
    public void update(String field, String newValue){
        if(field == "1" || field == "2" || field == "3"){
            super.update(field, newValue);
        } else if(field == "4"){
            // rating
            // TODO: verificar mudanca para float
            this.rating = newValue;
        }
    }
    // getters and setters 
    // toString
}
