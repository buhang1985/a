package iih.ci.mrfp.mrfpxml.d;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"id","code","effectiveTime","value","cvalue","strValue"})
public class Observation {
    private String classCode;
    private String moodCode;
    private Identification id;
    private CodeLife code;
	private CValue effectiveTime;
    private CValue value;
    private Code cvalue;
	private String strValue;
    @XmlAttribute( name ="classCode")
    public String getClassCode() { 
         return classCode;
    }
    @XmlAttribute( name ="moodCode")
    public String getMoodCode() { 
         return moodCode;
    }
    @XmlElement( name ="id")
    public Identification getId() { 
         return id;
    }
    @XmlElement( name ="code")
    public CodeLife getCode() { 
         return code;
    }
	@XmlElement( name ="effectiveTime")
    public CValue getEffectiveTime() { 
         return effectiveTime;
    }
    @XmlElement( name ="value")//type = PQ
    public CValue getValue() { 
         return value;
    }
    @XmlElement( name ="value")//type = PQ
    public Code getCvalue() { 
         return cvalue;
    }
	@XmlElement( name ="value")//type ="ST"
    public String getStrValue() { 
         return strValue;
    }
    public  void setClassCode(String classCode) { 
         this.classCode = classCode;
    }
    public  void setMoodCode(String moodCode) { 
         this.moodCode = moodCode;
    }
    public  void setId(Identification id) { 
        this.id = id;
   }
    public  void setCode(CodeLife code) { 
         this.code = code;
    }
	 public  void setEffectiveTime(CValue effectiveTime) { 
         this.effectiveTime = effectiveTime;
    }
    public  void setValue(CValue value) { 
         this.value = value;
    }
    public  void setCvalue(Code cvalue) { 
        this.cvalue = cvalue;
   }
	public  void setStrValue(String strValue) { 
         this.strValue = strValue;
    }
}
