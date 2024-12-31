package iih.ci.mrfp.mrfpxml.d;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Custodian {
    private String typeCode;
    private AssignedCustodian assignedCustodian;
    @XmlAttribute( name ="typeCode")
    public String getTypeCode() { 
         return typeCode;
    }
    @XmlElement( name ="assignedCustodian")
    public AssignedCustodian getAssignedCustodian() { 
         return assignedCustodian;
    }
    public  void setTypeCode(String typeCode) { 
         this.typeCode = typeCode;
    }
    public  void setAssignedCustodian(AssignedCustodian assignedCustodian) { 
         this.assignedCustodian = assignedCustodian;
    }
}
