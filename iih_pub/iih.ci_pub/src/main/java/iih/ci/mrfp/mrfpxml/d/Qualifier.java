package iih.ci.mrfp.mrfpxml.d;

import javax.xml.bind.annotation.XmlElement;

public class Qualifier {
    private CName name;
    @XmlElement( name ="name")
    public CName getName() { 
         return name;
    }
    public  void setName(CName name) { 
         this.name = name;
    }
}
