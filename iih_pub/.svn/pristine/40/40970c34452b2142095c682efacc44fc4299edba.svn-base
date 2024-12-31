package iih.ci.mrfp.mrfpxml.d;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"id","code","assignedPeerson"})
public class DoctorNurEntity {
    private Identification id;
    private Code code;
    private ProviderOrganization assignedPeerson;
    @XmlElement( name ="id" )
    public Identification getId() { 
         return id;
    }
    @XmlElement( name ="code" )
    public Code getCode() { 
         return code;
    }
    @XmlElement( name ="assignedPerson")
    public ProviderOrganization getAssignedPeerson() { 
         return assignedPeerson;
    }
    public  void setId(Identification id) { 
         this.id = id;
    }
    public  void setCode(Code code) { 
         this.code = code;
    }
    public  void setAssignedPeerson(ProviderOrganization assignedPeerson) { 
         this.assignedPeerson = assignedPeerson;
    }
}
