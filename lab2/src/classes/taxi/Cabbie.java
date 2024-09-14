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
            // Atualiza rating
            float newValueFloat = Float.parseFloat(newValue); // String -> FLoat
            this.rating = newValueFloat;
        }
    }

    // Getters and Setters
    public int getCabbieId() {
        return cabbieId;
    }
    public float getRating() {
        return rating;
    }
    public void setRating(float rating) {
        this.rating = rating;
    }
    public String getLicenseNumber() {
        return licenseNumber;
    }

    // toString
    @Override
    public String toString() {
        return "Cabbie [name=" + name + ", cabbieId=" + cabbieId + ", email=" + email + ", rating=" + rating
                + ", phone=" + phone + ", licenseNumber=" + licenseNumber + "]";
    }
}
