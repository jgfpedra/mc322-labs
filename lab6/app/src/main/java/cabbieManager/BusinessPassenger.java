package cabbieManager;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "businessPassenger")
public class BusinessPassenger extends Passenger implements BenefitsControll{
    private String businessEmail;
    @Override
    @XmlElement(name = "discount")
    public float getDiscount() {
        return 0.35f;
    }
    @XmlElement(name = "businessEmail")
    public String getBusinessEmail(){
        return businessEmail;
    }
    public void setBusinessEmail(String businessEmail){
        this.businessEmail = businessEmail;
    }
}
