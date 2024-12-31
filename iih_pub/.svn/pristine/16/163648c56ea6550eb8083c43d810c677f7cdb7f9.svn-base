package iih.ci.mrfp.mrfpxml.d;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
@XmlType(propOrder = {"time","assignedAuthor"})
public class Author {
    private String typeCode;
    private String contextControlCode;
    private Date time;
    private AssignedAuthor assignedAuthor;
    @XmlAttribute( name ="typeCode")
    public String getTypeCode() { 
         return typeCode;
    }
    @XmlAttribute( name ="contextControlCode")
    public String getContextControlCode() { 
         return contextControlCode;
    }
    @XmlElement( name ="time" , nillable = true)
    public Date getTime() { 
         return time;
    }
    @XmlElement( name ="assignedAuthor")
    public AssignedAuthor getAssignedAuthor() { 
         return assignedAuthor;
    }
    public  void setTypeCode(String typeCode) { 
         this.typeCode = typeCode;
    }
    public  void setContextControlCode(String contextControlCode) { 
         this.contextControlCode = contextControlCode;
    }
    public  void setTime(Date time) { 
         this.time = time;
    }
    public  void setAssignedAuthor(AssignedAuthor assignedAuthor) { 
         this.assignedAuthor = assignedAuthor;
    }
}
