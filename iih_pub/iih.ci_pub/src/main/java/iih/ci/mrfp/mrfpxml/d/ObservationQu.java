package iih.ci.mrfp.mrfpxml.d;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"code","effectiveTime","value","CValue","authorDoc","authorNur"})
public class ObservationQu {
    private String classCode;
    private String moodCode;
    private Code code;
    private CValue effectiveTime;
    private CValue value;
    private Code CValue;
    private Author authorDoc;
    private Author authorNur;
    @XmlAttribute( name ="classCode")
    public String getClassCode() { 
         return classCode;
    }
    @XmlAttribute( name ="moodCode" )
    public String getMoodCode() { 
         return moodCode;
    }
    @XmlElement( name ="code")
    public Code getCode() { 
         return code;
    }
    @XmlElement( name ="effectiveTime")
    public CValue getEffectiveTime() { 
         return effectiveTime;
    }
    @XmlElement( name ="value")
    public CValue getValue() { 
         return value;
    }
    @XmlElement( name ="value")
    public Code getCValue() { 
         return CValue;
    }
    @XmlElement( name ="author")
    public Author getAuthorDoc() { 
         return authorDoc;
    }
    @XmlElement( name ="author")
    public Author getAuthorNur() { 
         return authorNur;
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
    public  void setEffectiveTime(CValue effectiveTime) { 
         this.effectiveTime = effectiveTime;
    }
    public  void setValue(CValue value) { 
         this.value = value;
    }
    public  void setCValue(Code cValue) { 
        this.CValue = cValue;
   }
    public  void setAuthorDoc(Author authorDoc) { 
         this.authorDoc = authorDoc;
    }
    public  void setAuthorNur(Author authorNur) { 
         this.authorNur = authorNur;
    }
}
