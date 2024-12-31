package iih.ci.mrfp.mrfpxml.d;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"id","name","administrativeGenderCode","birthTime","maritalStatusCode","ethnicGroupCode","birthplace","nationality","age",
		"employerOrganization","household","nativePlace","occupations"})
public class Patient {
    private String classCode;
    private String determinerCode;
    private Identification id;
    private String name;
    private Code administrativeGenderCode;
    private CValue birthTime;
    private Code maritalStatusCode;
    private Code ethnicGroupCode;
    private List<Place> birthplace;
    private Code nationality;
    private CValue age;
    private EmployerOrganization employerOrganization;
    private List<Place> household;
    private List<Place> nativePlace;
    private List<Code> occupations;
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
    @XmlElement( name ="administrativeGenderCode")
    public Code getAdministrativeGenderCode() { 
         return administrativeGenderCode;
    }
    @XmlElement( name ="birthTime")
    public CValue getBirthTime() { 
         return birthTime;
    }
    @XmlElement( name ="maritalStatusCode")
    public Code getMaritalStatusCode() { 
         return maritalStatusCode;
    }
    @XmlElement( name ="ethnicGroupCode")
    public Code getEthnicGroupCode() { 
         return ethnicGroupCode;
    }
    @XmlElementWrapper(name ="birthplace")
    @XmlElement( name ="place")
    public List<Place> getBirthplace() { 
         return birthplace;
    }
    @XmlElement( name ="nationality")
    public Code getNationality() { 
         return nationality;
    }
    @XmlElement( name ="age")
    public CValue getAge() { 
         return age;
    }
    @XmlElement( name ="employerOrganization")
    public EmployerOrganization getEmployerOrganization() { 
         return employerOrganization;
    }
    @XmlElementWrapper(name ="household")
    @XmlElement( name ="place")
    public List<Place> getHousehold() { 
         return household;
    }
    @XmlElementWrapper(name ="nativePlace")
    @XmlElement( name ="place")
    public List<Place> getNativePlace() { 
         return nativePlace;
    }
	
	@XmlElementWrapper(name="occupation")
    @XmlElement( name ="occupationCode")
    public List<Code> getOccupations() { 
         return occupations;
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
    public  void setAdministrativeGenderCode(Code administrativeGenderCode) { 
         this.administrativeGenderCode = administrativeGenderCode;
    }
    public  void setBirthTime(CValue birthTime) { 
         this.birthTime = birthTime;
    }
    public  void setMaritalStatusCode(Code maritalStatusCode) { 
         this.maritalStatusCode = maritalStatusCode;
    }
    public  void setEthnicGroupCode(Code ethnicGroupCode) { 
         this.ethnicGroupCode = ethnicGroupCode;
    }
    public  void setBirthplace(List<Place> birthplace) { 
         this.birthplace = birthplace;
    }
    public  void setNationality(Code nationality) { 
         this.nationality = nationality;
    }
    public  void setAge(CValue age) { 
         this.age = age;
    }
    public  void setEmployerOrganization(EmployerOrganization employerOrganization) { 
         this.employerOrganization = employerOrganization;
    }
    public  void setHousehold(List<Place> household) { 
         this.household = household;
    }
    public  void setNativePlace(List<Place> nativePlace) { 
         this.nativePlace = nativePlace;
    }
    public void setOccupations( List <Code> occupations) { 
         this.occupations = occupations;
    }
}
