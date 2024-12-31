package iih.ci.mrfp.mrfpxml.d;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"code","addr","telecom","associatedPerson"})
public class AssociatedEntity {
    private String classCode;
    private Code code;
    private Address addr;
    private CValue telecom;
    private ProviderOrganization associatedPerson;
    @XmlAttribute( name ="classCode")
    public String getClassCode() { 
         return classCode;
    }
    @XmlElement( name ="code")
    public Code getCode() { 
         return code;
    }
    @XmlElement( name ="addr")
    public Address getAddr() { 
         return addr;
    }
    @XmlElement( name ="telecom")
    public CValue getTelecom() { 
         return telecom;
    }
    @XmlElement( name ="associatedPerson")
    public ProviderOrganization getAssociatedPerson() { 
         return associatedPerson;
    }
    public  void setClassCode(String classCode) { 
         this.classCode = classCode;
    }
    public  void setCode(Code code) { 
         this.code = code;
    }
    public  void setAddr(Address addr) { 
         this.addr = addr;
    }
    public  void setTelecom(CValue telecom) { 
         this.telecom = telecom;
    }
    public  void setAssociatedPerson(ProviderOrganization associatedPerson) { 
         this.associatedPerson = associatedPerson;
    }
}
