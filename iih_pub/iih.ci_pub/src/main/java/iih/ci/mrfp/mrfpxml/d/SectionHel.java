package iih.ci.mrfp.mrfpxml.d;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"code","text","entryCuType","entryDip","entryStatus","entry1","entry2","entry3","entry4"})
public class SectionHel {
    private Code code;
    private String text;
    EntryLife entryCuType;
    EntryLife entryDip;
    EntryLife entryStatus;
    private EntryLife entry1;
    private EntryHel entry2;
    private EntryHel2 entry3;
    private EntryHel2 entry4;
    @XmlElement( name ="code")
    public Code getCode() { 
         return code;
    }
    @XmlElement( name ="text" , nillable = true)
    public String getText() { 
         return text;
    }
    @XmlElement( name ="entry")
    public EntryLife getEntryCuType() { 
         return entryCuType;
    }
    @XmlElement( name ="entry")
    public EntryLife getEntryDip() { 
         return entryDip;
    }
    @XmlElement( name ="entry")
    public EntryLife getEntryStatus() { 
         return entryStatus;
    }
    @XmlElement( name ="entry")
    public EntryLife getEntry1() { 
         return entry1;
    }
    @XmlElement( name ="entry")
    public EntryHel getEntry2() { 
         return entry2;
    }
    @XmlElement( name ="entry")
    public EntryHel2 getEntry3() { 
         return entry3;
    }
    @XmlElement( name ="entry")
    public EntryHel2 getEntry4() { 
         return entry4;
    }
    public  void setCode(Code code) { 
         this.code = code;
    }
    public  void setText(String text) { 
         this.text = text;
    }
    public  void setEntryCuType(EntryLife entryCuType) { 
        this.entryCuType = entryCuType;
   }
    public  void setEntryDip(EntryLife entryDip) { 
        this.entryDip = entryDip;
   }
    public  void setEntryStatus(EntryLife entryStatus) { 
        this.entryStatus = entryStatus;
   }
    public  void setEntry1(EntryLife entry1) { 
         this.entry1 = entry1;
    }
    public  void setEntry2(EntryHel entry2) { 
         this.entry2 = entry2;
    }
    public  void setEntry3(EntryHel2 entry3) { 
         this.entry3 = entry3;
    }
    public  void setEntry4(EntryHel2 entry4) { 
         this.entry4 = entry4;
    }
}
