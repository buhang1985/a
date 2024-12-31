package iih.ci.mrfp.mrfpxml.d;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

public class ServiceProviderOrganization {
    private String classCode;
    private String determinerCode;
    private OrganizaWard asOrganizationPartOf;
    @XmlAttribute( name ="classCode")
    public String getClassCode() { 
         return classCode;
    }
    @XmlAttribute( name ="determinerCode")
    public String getDeterminerCode() { 
         return determinerCode;
    }
    @XmlElement( name ="asOrganizationPartOf")
    public OrganizaWard getAsOrganization() { 
         return asOrganizationPartOf;
    }
    public  void setClassCode(String classCode) { 
         this.classCode = classCode;
    }
    public  void setDeterminerCode(String determinerCode) { 
         this.determinerCode = determinerCode;
    }
    public  void setAsOrganization(OrganizaWard asOrganization) { 
         this.asOrganizationPartOf = asOrganization;
    }
}
