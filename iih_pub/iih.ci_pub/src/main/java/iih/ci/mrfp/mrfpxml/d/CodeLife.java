package iih.ci.mrfp.mrfpxml.d;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class CodeLife extends Code {
    private Qualifier qualifier;
    @XmlElement( name ="qualifier")
    public Qualifier getQualifier() { 
         return qualifier;
    }
    public  void setQualifier(Qualifier qualifier) { 
         this.qualifier = qualifier;
    }
}
