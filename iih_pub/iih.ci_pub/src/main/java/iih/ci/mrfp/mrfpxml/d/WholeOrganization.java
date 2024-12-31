
package iih.ci.mrfp.mrfpxml.d;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"id","name","asOrganizationPartOf"})
public class WholeOrganization {
    private String classCode;
	private String determinerCode;
    private Identification id;
    private String name;
    private AsOrganizationPartOf asOrganizationPartOf;
    @XmlAttribute( name ="classCode")
    public String getClassCode() { 
         return classCode;
    }
	@XmlAttribute( name ="determinerCode")
    public String getDeterminerCode() { 
         return determinerCode;
    }
    @XmlElement( name ="id")
    public Identification getId() { 
         return id;
    }
    @XmlElement( name ="name")
    public String getName() { 
         return name;
    }
    @XmlElement( name ="asOrganizationPartOf")
    public AsOrganizationPartOf getAsOrganizationPartOf() { 
         return asOrganizationPartOf;
    }
    public  void setClassCode(String classCode) { 
         this.classCode = classCode;
    }
	 public  void setDeterminerCode(String determinerCode) { 
         this.determinerCode = determinerCode;
    }
    public  void setId(Identification id) { 
         this.id = id;
    }
    public  void setName(String name) { 
         this.name = name;
    }
    public  void setAsOrganizationPartOf(AsOrganizationPartOf asOrganizationPartOf) { 
         this.asOrganizationPartOf = asOrganizationPartOf;
    }
}
