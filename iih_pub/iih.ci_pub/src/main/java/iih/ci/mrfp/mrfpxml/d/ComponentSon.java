package iih.ci.mrfp.mrfpxml.d;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class ComponentSon {
	private String classCode;
	private String typeCode;
	private String contextConductionInd;
    private ObservationHel observation;
    @XmlAttribute( name ="classCode")
    public String getClassCode() { 
         return classCode;
    }
    @XmlAttribute( name ="typeCode")
    public String getTypeCode() { 
         return typeCode;
    }
    @XmlAttribute( name ="contextConductionInd")
    public String getContextConductionInd() { 
         return contextConductionInd;
    }
    @XmlElement( name ="observation")
    public ObservationHel getObservation() { 
         return observation;
    }
    public  void setClassCode(String classCode) { 
        this.classCode = classCode;
   }
    public  void setTypeCode(String typeCode) { 
        this.typeCode = typeCode;
   }
    public  void setContextConductionInd(String contextConductionInd) { 
        this.contextConductionInd = contextConductionInd;
   }
    public  void setObservation(ObservationHel observation) { 
         this.observation = observation;
    }
   
}
