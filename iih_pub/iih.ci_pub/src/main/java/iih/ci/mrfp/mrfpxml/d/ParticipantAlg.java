package iih.ci.mrfp.mrfpxml.d;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class ParticipantAlg {
    private String typeCode;
    private ParticipantRole participantRole;
    @XmlAttribute( name ="typeCode")
    public String getTypeCode() { 
         return typeCode;
    }
    @XmlElement( name ="participantRole")
    public ParticipantRole getParticipantRole() { 
         return participantRole;
    }
    public  void setTypeCode(String typeCode) { 
         this.typeCode = typeCode;
    }
    public  void setParticipantRole(ParticipantRole participantRole) { 
         this.participantRole = participantRole;
    }
}
