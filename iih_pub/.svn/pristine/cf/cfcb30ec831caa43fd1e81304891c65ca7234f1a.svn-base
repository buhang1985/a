package iih.ci.mrfp.mrfpxml.d;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"code","statusCode","component"})
public class OrganizerDi {
    private String classCode;
    private String moodCode;
    private Code code;
    private String statusCode;    
    private List<ComponentSon> component;
    @XmlAttribute( name ="classCode")
    public String getClassCode() { 
         return classCode;
    }
    @XmlAttribute( name ="moodCode")
    public String getMoodCode() { 
         return moodCode;
    }
    @XmlElement( name ="code" )
    public Code getCode() { 
         return code;
    }
    @XmlElement( name ="statusCode" , nillable = true)
    public String getStatusCode() { 
         return statusCode;
    }
   
	@XmlElement( name ="component")
    public List<ComponentSon> getComponent() { 
         return component;
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
    public  void setStatusCode(String statusCode) { 
         this.statusCode = statusCode;
    }   
    public void setComponent( List <ComponentSon> component) { 
         this.component = component;
    }
}
