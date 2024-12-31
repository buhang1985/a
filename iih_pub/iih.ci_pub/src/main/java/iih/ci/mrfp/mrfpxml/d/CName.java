package iih.ci.mrfp.mrfpxml.d;

import javax.xml.bind.annotation.XmlAttribute;

public class CName {
    private String displayName;
    @XmlAttribute( name ="displayName")
    public String getDisplayName() { 
         return displayName;
    }
    public  void setDisplayName(String displayName) { 
         this.displayName = displayName;
    }
}
