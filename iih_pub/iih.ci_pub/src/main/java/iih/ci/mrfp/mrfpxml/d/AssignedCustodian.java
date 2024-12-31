package iih.ci.mrfp.mrfpxml.d;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class AssignedCustodian {
    private String classCode;
    private ProviderOrganization representedCustodianOrganization;
    @XmlAttribute( name ="classCode")
    public String getClassCode() { 
         return classCode;
    }
    @XmlElement( name ="representedCustodianOrganization")
    public ProviderOrganization getRepresentedCustodianOrganization() { 
         return representedCustodianOrganization;
    }
    public  void setClassCode(String classCode) { 
         this.classCode = classCode;
    }
    public  void setRepresentedCustodianOrganization(ProviderOrganization representedCustodianOrganization) { 
         this.representedCustodianOrganization = representedCustodianOrganization;
    }
}
