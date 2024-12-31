package iih.ci.mrfp.mrfpxml.d;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"code","text","entry_OutHos","entry_NameOutHos","entryMainDi_Name","entryMainDi_Sd","entryMainDi_inp","entrys"})
public class SectionOutHos {
    private Code code;
    private String text;
    private EntryHel entry_OutHos;
    private EntryLife entry_NameOutHos;
    private EntryLife entryMainDi_Name;//主诊断名称
    private EntryLife entryMainDi_Sd;//主诊断编码
    private EntryLife entryMainDi_inp;//主诊断病情
    private List<EntryHel> entrys;
    @XmlElement( name ="code" )
    public Code getCode() { 
         return code;
    }
    @XmlElement( name ="text" , nillable = true)
    public String getText() { 
         return text;
    }
    @XmlElement( name ="entry")
    public EntryHel getEntry_OutHos() { 
         return entry_OutHos;
    }
    @XmlElement( name ="entry")
    public EntryLife getEntry_NameOutHos() { 
         return entry_NameOutHos;
    }
    @XmlElement( name ="entry")
    public EntryLife getEntryMainDi_Name() { 
         return entryMainDi_Name;
    }
    @XmlElement( name ="entry")
    public EntryLife getEntryMainDi_Sd() { 
         return entryMainDi_Sd;
    }
    @XmlElement( name ="entry")
    public EntryLife getEntryMainDi_inp() { 
         return entryMainDi_inp;
    }
    @XmlElement( name ="entry")
    public List<EntryHel> getEntrys() { 
         return entrys;
    }
    public  void setCode(Code code) { 
         this.code = code;
    }
    public  void setText(String text) { 
         this.text = text;
    }
    public  void setEntry_OutHos(EntryHel entry_OutHos) { 
        this.entry_OutHos = entry_OutHos;
   }
    public  void setEntry_NameOutHos(EntryLife entry_NameOutHos) { 
        this.entry_NameOutHos = entry_NameOutHos;
   }
    public  void setEntryMainDi_Name(EntryLife entryMainDi_Name) { 
         this.entryMainDi_Name = entryMainDi_Name;
    }
    public  void setEntryMainDi_Sd(EntryLife entryMainDi_Sd) { 
        this.entryMainDi_Sd = entryMainDi_Sd;
   }
    public  void setEntryMainDi_inp(EntryLife entryMainDi_inp) { 
        this.entryMainDi_inp = entryMainDi_inp;
   }
    public  void setEntrys(List<EntryHel> entrys) { 
        this.entrys = entrys;
   }
}
