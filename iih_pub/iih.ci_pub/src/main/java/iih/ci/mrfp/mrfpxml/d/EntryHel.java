package iih.ci.mrfp.mrfpxml.d;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class EntryHel {
    private String typeCode;
    private ObservationHel observation;
    @XmlAttribute( name ="typeCode")
    public String getTypeCode() { 
         return typeCode;
    }
    @XmlElement( name ="observation")
    public ObservationHel getObservation() { 
         return observation;
    }
    public  void setTypeCode(String typeCode) { 
         this.typeCode = typeCode;
    }
    public  void setObservation(ObservationHel observation) { 
         this.observation = observation;
    }
}
