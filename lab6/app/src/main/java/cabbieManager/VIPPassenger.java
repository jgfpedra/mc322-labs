package cabbieManager;

import java.time.LocalDateTime;

public class VIPPassenger extends Person implements BenefitsControll{
    private LocalDateTime vipExpiration;
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
    public LocalDateTime getVipExpiration(){
        return LocalDateTime.now();
    }
    public void setVipExpiration(LocalDateTime vipExpiration){
        this.vipExpiration = vipExpiration;
    }
}