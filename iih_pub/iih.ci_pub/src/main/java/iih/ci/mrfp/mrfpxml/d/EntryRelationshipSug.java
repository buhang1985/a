package iih.ci.mrfp.mrfpxml.d;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class EntryRelationshipSug {
    private String typeCode;
    private ObservationSug observation;
    @XmlAttribute( name ="typeCode")
    public String getTypeCode() { 
         return typeCode;
    }
    @XmlElement( name ="observation")
    public ObservationSug getObservation() { 
         return observation;
    }
    public  void setTypeCode(String typeCode) { 
         this.typeCode = typeCode;
    }
    public  void setObservation(ObservationSug observation) { 
         this.observation = observation;
    }
}
