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

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // tostring
    @Override
    public String toString() {
        return "Person [name=" + name + ", email=" + email + ", phone=" + phone + "]";
    }

    // TODO: talvez colocar toString
    
}