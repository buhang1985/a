package iih.ci.mrfp.mrfpxml.d;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"code","value","participant"})
public class ObservationAlg {
    private String classCode;
    private String moodCode;
    private Code code;
    private CValue value;
    private ParticipantAlg participant;
    @XmlAttribute( name ="classCode")
    public String getClassCode() { 
         return classCode;
    }
    @XmlAttribute( name ="moodCode")
    public String getMoodCode() { 
         return moodCode;
    }
    @XmlElement( name ="code")
    public Code getCode() { 
         return code;
    }
    @XmlElement( name ="value")
    public CValue getValue() { 
         return value;
    }
    @XmlElement( name ="participant")
    public ParticipantAlg getParticipant() { 
         return participant;
    }
    public  void setClassCode(String classCode) { 
         this.classCode = classCode;
    }
    public  void setMoodCode(String moodCode) { 
         this.moodCode = moodCode;
    }
    public  void setCode(Code code) { 
         this.code = code;
    }
    public  void setValue(CValue value) { 
         this.value = value;
    }
    public  void setParticipant(ParticipantAlg participant) { 
         this.participant = participant;
    }
}
