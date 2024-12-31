package iih.ci.mrfp.mrfpxml.d;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"root","extension"})
public class Identification {
    private String root;
    private String extension;
    @XmlAttribute( name ="root" )
    public String getRoot() { 
         return root;
    }
    @XmlAttribute( name ="extension")
    public String getExtension() { 
         return extension;
    }
    public  void setRoot(String root) { 
         this.root = root;
    }
    public  void setExtension(String extension) { 
         this.extension = extension;
    }
}
