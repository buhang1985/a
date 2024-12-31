package iih.ci.mrfp.mrfpxml.d;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"code","author"})
public class ObserVationChDep {
	private String classCode;
	private String moodCode;
    private String code;
    private AuthorChDep author;
    @XmlAttribute( name ="classCode")
    public String getClassCode() { 
         return classCode;
    }
    @XmlAttribute( name ="moodCode")
    public String getMoodCode() { 
         return moodCode;
    }
    @XmlElement( name ="code" , nillable = true)
    public String getCode() { 
         return code;
    }
    @XmlElement( name ="author")
    public AuthorChDep getAuthor() { 
         return author;
    }
    public  void setClassCode(String classCode) { 
        this.classCode = classCode;
   }
   public  void setMoodCode(String moodCode) { 
        this.moodCode = moodCode;
   }
    public  void setCode(String code) { 
         this.code = code;
    }
    public  void setAuthor(AuthorChDep author) { 
         this.author = author;
    }
}
