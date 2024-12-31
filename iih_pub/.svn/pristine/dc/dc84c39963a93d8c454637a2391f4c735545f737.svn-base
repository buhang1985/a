package iih.ci.mrfp.mrfpxml.d;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"code","text","entryDays","entryDep"})
public class SectionIHH {
    private Code code;
    private String text;
    private EntryLife entryDays;
    private EntryAlg entryDep;
    @XmlElement( name ="code")
    public Code getCode() { 
         return code;
    }
    @XmlElement( name ="text" , nillable = true)
    public String getText() { 
         return text;
    }
    @XmlElement( name ="entry")
    public EntryLife getEntryDays() { 
         return entryDays;
    }
    @XmlElement( name ="entry")
    public EntryAlg getEntryDep() { 
         return entryDep;
    }
    public  void setCode(Code code) { 
         this.code = code;
    }
    public  void setText(String text) { 
         this.text = text;
    }
    public  void setEntryDays(EntryLife entryDays) { 
         this.entryDays = entryDays;
    }
    public  void setEntryDep(EntryAlg entryDep) { 
         this.entryDep = entryDep;
    }
}
