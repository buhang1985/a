package iih.ci.mrfp.mrfpxml.d;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"time","assignedAuthor"})
public class AuthorChDep {
    private Date time;
    private AssignedAuthorChDep assignedAuthor;
    @XmlElement( name ="time" , nillable = true)
    public Date getTime() { 
         return time;
    }
    @XmlElement( name ="assignedAuthor")
    public AssignedAuthorChDep getAssignedAuthor() { 
         return assignedAuthor;
    }
    public  void setTime(Date time) { 
         this.time = time;
    }
    public  void setAssignedAuthor(AssignedAuthorChDep assignedAuthor) { 
         this.assignedAuthor = assignedAuthor;
    }
}
