package iih.ci.mrfp.mrfpxml.d;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class EntryRelationshipAlg {
    private String typeCode;
    private ObservationAlg observation;
    @XmlAttribute( name ="typeCode")
    public String getTypeCode() { 
         return typeCode;
    }
    @XmlElement( name ="observation")
    public ObservationAlg getObservation() { 
         return observation;
    }
    public  void setTypeCode(String typeCode) { 
         this.typeCode = typeCode;
    }
    public  void setObservation(ObservationAlg observation) { 
         this.observation = observation;
    }
}
