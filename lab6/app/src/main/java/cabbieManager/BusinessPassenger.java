package cabbieManager;

public class BusinessPassenger extends Person implements BenefitsControll{
    private String businessEmail;
    @Override
    public float getDiscount() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDiscount'");
    }
    @Override
    public void register() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'register'");
    }
    @Override
    public void update(String field, String newValue) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    public String getBusinessEmail(){
        return businessEmail;
    }
    public void setBusinessEmail(String businessEmail){
        this.businessEmail = businessEmail;
    }
}
