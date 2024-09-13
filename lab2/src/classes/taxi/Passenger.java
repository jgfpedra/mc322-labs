package classes.taxi;

public class Passenger extends Person{
    //Adicionar os atributos da classe Passenger
	private int userId;
    //Adicionar os métodos da classe Passenger
    public Passenger(int userId, String name, String email, String phone) {
        this.userId = userId;
        this.register(name, email, phone);
    }
    @Override
    public void register(String name, String email, String phone) {
        super.register(name, email, phone);
    }
    @Override
    public void update(String field, String newValue){
        if(field == "1" || field == "2" || field == "3")
            super.update(field, newValue);
    }
    // getters and setters 
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    // tostring
    @Override
    public String toString() {
        return "Passenger [name=" + name + ", userId=" + userId + ", email=" + email + ", phone=" + phone + "]";
    }
}
