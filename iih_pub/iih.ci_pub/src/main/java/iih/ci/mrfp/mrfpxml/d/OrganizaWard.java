package iih.ci.mrfp.mrfpxml.d;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class OrganizaWard {
    private String classCode;
    private WholeOrganization wholeOrganization;
    @XmlAttribute( name ="classCode")
    public String getClassCode() { 
         return classCode;
    }
    @XmlElement( name ="wholeOrganization")
    public WholeOrganization getWholeOrganization() { 
         return wholeOrganization;
    }
    public  void setClassCode(String classCode) { 
         this.classCode = classCode;
    }
    public  void setWholeOrganization(WholeOrganization wholeOrganization) { 
         this.wholeOrganization = wholeOrganization;
    }
}
