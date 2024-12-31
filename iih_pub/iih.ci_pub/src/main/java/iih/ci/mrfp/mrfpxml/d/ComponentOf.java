package iih.ci.mrfp.mrfpxml.d;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class ComponentOf {
    private String typeCode;
    private EncompassingEncounter encompassingEncounter;
    @XmlAttribute( name ="typeCode")
    public String getTypeCode() { 
         return typeCode;
    }
    @XmlElement( name ="encompassingEncounter")
    public EncompassingEncounter getEncompassingEncounter() { 
         return encompassingEncounter;
    }
    public  void setTypeCode(String typeCode) { 
         this.typeCode = typeCode;
    }
    public  void setEncompassingEncounter(EncompassingEncounter encompassingEncounter) { 
         this.encompassingEncounter = encompassingEncounter;
    }
}
