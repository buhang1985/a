package iih.ci.mrfp.mrfpxml.d;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"code","text","entry"})
public class SectionAlg {
    private Code code;
    private String text;
    private EntryAlg entry;
    @XmlElement( name ="code")
    public Code getCode() { 
         return code;
    }
    @XmlElement( name ="text" , nillable = true)
    public String getText() { 
         return text;
    }
    @XmlElement( name ="entry")
    public EntryAlg getEntry() { 
         return entry;
    }
    public  void setCode(Code code) { 
         this.code = code;
    }
    public  void setText(String text) { 
         this.text = text;
    }
    public  void setEntry(EntryAlg entry) { 
         this.entry = entry;
    }
}
