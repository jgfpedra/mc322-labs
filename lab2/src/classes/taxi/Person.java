package classes.taxi;
public abstract class Person{
    //Adicionar os atributos da classe Person
    public String name;
    public String email;
    public String phone;


    // Métodos a serem implementados da classe Person
    public void register(String name, String email, String phone){
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public void update(String field, String newValue){
        if(field == "1"){
            this.name = newValue;
        }
        else if (field == "2") {
            this.email = newValue;
        }
        else if (field == "3") {
            this.phone = newValue;
        }
    }
}