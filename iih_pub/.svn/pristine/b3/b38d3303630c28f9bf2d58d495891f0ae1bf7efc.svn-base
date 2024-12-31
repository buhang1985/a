package iih.ci.mrfp.mrfpxml.d;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"name","telecom","addr"})
public class EmployerOrganization {
    private String name;
    private CValue telecom;
    private Address addr;
    @XmlElement( name ="name")
    public String getName() { 
         return name;
    }
    @XmlElement( name ="telecom")
    public CValue getTelecom() { 
         return telecom;
    }
    @XmlElement( name ="addr")
    public Address getAddr() { 
         return addr;
    }
    public  void setName(String name) { 
         this.name = name;
    }
    public  void setTelecom(CValue telecom) { 
         this.telecom = telecom;
    }
    public  void setAddr(Address addr) { 
         this.addr = addr;
    }
}
