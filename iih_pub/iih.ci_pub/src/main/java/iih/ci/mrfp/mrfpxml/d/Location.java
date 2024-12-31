package iih.ci.mrfp.mrfpxml.d;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Location {
    private String typeCode;
    private HealthCarFacility healthCarFacility;
    @XmlAttribute( name ="typeCode")
    public String getTypeCode() { 
         return typeCode;
    }
    @XmlElement( name ="healthCareFacility")
    public HealthCarFacility getHealthCarFacility() { 
         return healthCarFacility;
    }
    public  void setTypeCode(String typeCode) { 
         this.typeCode = typeCode;
    }
    public  void setHealthCarFacility(HealthCarFacility healthCarFacility) { 
         this.healthCarFacility = healthCarFacility;
    }
}
