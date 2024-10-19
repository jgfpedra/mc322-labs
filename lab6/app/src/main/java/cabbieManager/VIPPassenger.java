package cabbieManager;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import utils.LocalDateTimeAdapter;

@XmlRootElement(name = "vipPassenger")
public class VIPPassenger extends Passenger implements BenefitsControll{
    private LocalDateTime vipExpiration;
    @Override
    @XmlElement(name = "discount")
    public float getDiscount() {
        return 0.45f;
    }
    @XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
    @XmlElement(name = "vipExpiration")
    public LocalDateTime getVipExpiration(){
        return vipExpiration;
    }
    public void setVipExpiration(LocalDateTime vipExpiration){
        this.vipExpiration = vipExpiration;
    }
}