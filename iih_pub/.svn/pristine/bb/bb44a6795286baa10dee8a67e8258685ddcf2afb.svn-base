package iih.ci.mrfp.mrfpxml.d;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"code","CValue","value","assignedEntity"})
public class ObservationSug {
    private String classCode;
    private String moodCode;
    private Code code;
    private Code CValue;
    private CValue value;
    private List<AssignedAuthor> assignedEntity;
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
    public Code getCValue() { 
         return CValue;	
    }
    @XmlElement( name ="value")
    public CValue getValue() { 
         return value;
    }
    @XmlElementWrapper(name="performer")
    @XmlElement( name ="assignedEntity")
    public List<AssignedAuthor> getAssignedEntity() { 
         return assignedEntity;
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
    public  void setCValue(Code cValue) { 
        this.CValue = cValue;
   }
    public  void setValue(CValue value) { 
         this.value = value;
    }
    public void setAssignedEntity( List <AssignedAuthor> assignedEntity) { 
         this.assignedEntity = assignedEntity;
    }
}
