package iih.ci.mrfp.mrfpxml.d;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"code","effectiveTime","location"})
public class EncompassingEncounter {
    private String classCode;
    private String moodCode;
    private Code code;
    private EffectiveTime effectiveTime;
    private Location location;
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
    @XmlElement( name ="effectiveTime")
    public EffectiveTime getEffectiveTime() { 
         return effectiveTime;
    }
    @XmlElement( name ="location")
    public Location getLocation() { 
         return location;
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
    public  void setEffectiveTime(EffectiveTime effectiveTime) { 
         this.effectiveTime = effectiveTime;
    }
    public  void setLocation(Location location) { 
         this.location = location;
    }
}
