package iih.ci.mrfp.mrfpxml.d;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"code","text","entry"})
public class SectionCP {
    private Code code;
    private String text;
    private EntryHel entry;
    @XmlElement( name ="code")
    public Code getCode() { 
         return code;
    }
    @XmlElement( name ="text")
    public String getText() { 
         return text;
    }
    @XmlElement( name ="entry")
    public EntryHel getEntry() { 
         return entry;
    }
    public  void setCode(Code code) { 
         this.code = code;
    }
    public  void setText(String text) { 
         this.text = text;
    }
    public  void setEntry(EntryHel entry) { 
         this.entry = entry;
    }
}
