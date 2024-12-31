package iih.ci.mrfp.mrfpxml.d;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"time","signatureCode","assignedEntity"})
public class DoctorNur {
    private Date time;
    private Code signatureCode;
    private DoctorNurEntity assignedEntity;
    @XmlElement( name ="time" , nillable = true)
    public Date getTime() { 
         return time;
    }
    @XmlElement( name ="signatureCode" , nillable = true)
    public Code getSignatureCode() { 
         return signatureCode;
    }
    @XmlElement( name ="assignedEntity")
    public DoctorNurEntity getAssignedEntity() { 
         return assignedEntity;
    }
    public  void setTime(Date time) { 
         this.time = time;
    }
    public  void setSignatureCode(Code signatureCode) { 
         this.signatureCode = signatureCode;
    }
    public  void setAssignedEntity(DoctorNurEntity assignedEntity) { 
         this.assignedEntity = assignedEntity;
    }
}
