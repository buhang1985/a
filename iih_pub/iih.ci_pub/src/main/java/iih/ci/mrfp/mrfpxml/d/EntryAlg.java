package iih.ci.mrfp.mrfpxml.d;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class EntryAlg {
    private String typeCode;
    private ActAlg act;
    @XmlAttribute( name ="typeCode")
    public String getTypeCode() { 
         return typeCode;
    }
    @XmlElement( name ="act")
    public ActAlg getAct() { 
         return act;
    }
    public  void setTypeCode(String typeCode) { 
         this.typeCode = typeCode;
    }
    public  void setAct(ActAlg act) { 
         this.act = act;
    }
}
