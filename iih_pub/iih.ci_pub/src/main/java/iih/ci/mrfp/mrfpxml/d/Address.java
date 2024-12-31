package iih.ci.mrfp.mrfpxml.d;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"hoseNumber","streetName","township","county","city","state","postalCode"})
public class Address {
    private String use;
    private String hoseNumber;
    private String streetName;
    private String township;
    private String county;
    private String city;
    private String state;
    private String postalCode;
    @XmlAttribute( name ="use")
    public String getUse() { 
         return use;
    }
    @XmlElement( name ="houseNumber")
    public String getHoseNumber() { 
         return hoseNumber;
    }
    @XmlElement( name ="streetName")
    public String getStreetName() { 
         return streetName;
    }
    @XmlElement( name ="streetNameBase")
    public String getTownship() { 
         return township;
    }
    @XmlElement( name ="county")
    public String getCounty() { 
         return county;
    }
    @XmlElement( name ="city")
    public String getCity() { 
         return city;
    }
    @XmlElement( name ="state")
    public String getState() { 
         return state;
    }
    @XmlElement( name ="postalCode")
    public String getPostalCode() { 
         return postalCode;
    }
    public  void setUse(String use) { 
         this.use = use;
    }
    public  void setHoseNumber(String hoseNumber) { 
         this.hoseNumber = hoseNumber;
    }
    public  void setStreetName(String streetName) { 
         this.streetName = streetName;
    }
    public  void setTownship(String township) { 
         this.township = township;
    }
    public  void setCounty(String county) { 
         this.county = county;
    }
    public  void setCity(String city) { 
         this.city = city;
    }
    public  void setState(String state) { 
         this.state = state;
    }
    public  void setPostalCode(String postalCode) { 
         this.postalCode = postalCode;
    }
}
