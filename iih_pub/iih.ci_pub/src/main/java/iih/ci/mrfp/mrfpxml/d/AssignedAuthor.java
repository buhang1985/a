package iih.ci.mrfp.mrfpxml.d;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"id","code","assignedPerson","asOrganiza","representedOrganization"})
public class AssignedAuthor {
    private String classCode;
    private Identification id;
    private Code code;
    private ProviderOrganization assignedPerson;
    private OrganizaWard asOrganiza;
    private WholeOrganization representedOrganization;
    
    @XmlAttribute( name ="classCode")
    public String getClassCode() { 
         return classCode;
    }
    @XmlElement( name ="id")
    public Identification getId() { 
         return id;
    }
    @XmlElement( name ="code")
    public Code getCode() { 
         return code;
    }
    @XmlElement( name ="assignedPerson")
    public ProviderOrganization getAssignedPerson() { 
         return assignedPerson;
    }
    @XmlElement( name ="asOrgnizationPartOf")
    public OrganizaWard getAsOrganiza() { 
         return asOrganiza;
    }
    @XmlElement( name ="representedOrganization")
    public WholeOrganization getRepresentedOrganization() { 
         return representedOrganization;
    }
    public  void setClassCode(String classCode) { 
         this.classCode = classCode;
    }
    public  void setId(Identification id) { 
         this.id = id;
    }
    public  void setCode(Code code) { 
        this.code = code;
   }
    public  void setAssignedPerson(ProviderOrganization assignedPerson) { 
         this.assignedPerson = assignedPerson;
    }
    public  void setAsOrganiza(OrganizaWard asOrganiza) { 
        this.asOrganiza = asOrganiza;
   }
    public  void setRepresentedOrganization(WholeOrganization representedOrganization) { 
        this.representedOrganization = representedOrganization;
   }
    
}
