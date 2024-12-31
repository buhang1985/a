package iih.ci.mrfp.mrfpxml.d;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"code","text","entryType","entryTotal","entryZH","entryDi","entryCure","entryKF","entryUsecmp","entryUsecmdt",
		"entryDnur","entryCureCn","entryMed","entryMedCn","entryBlood","entryUsecme","entryHC","entryOhr"})
public class SectionBL {
    private Code code;
    private String text;
    private EntryLife entryType;
    private EntryHel entryTotal;
    private EntryHel2 entryZH;
    private EntryHel2 entryDi;
    private EntryHel2 entryCure;
    private EntryLife entryKF;
    private EntryLife entryUsecmp;
    private EntryLife entryUsecmdt;
    private EntryLife entryDnur;
    private EntryHel2 entryCureCn;
    private EntryHel entryMed;
    private EntryHel2 entryMedCn;
    private EntryHel2 entryBlood;
    private EntryLife entryUsecme;
    private EntryHel2 entryHC;
    private EntryLife entryOhr;
    @XmlElement( name ="code")
    public Code getCode() { 
         return code;
    }
    @XmlElement( name ="text")
    public String getText() { 
         return text;
    }
    @XmlElement( name ="entry")
    public EntryLife getEntryType() { 
         return entryType;
    }
    @XmlElement( name ="entry")
    public EntryHel getEntryTotal() { 
         return entryTotal;
    }
    @XmlElement( name ="entry")
    public EntryHel2 getEntryZH() { 
         return entryZH;
    }
    @XmlElement( name ="entry")
    public EntryHel2 getEntryDi() { 
         return entryDi;
    }
    @XmlElement( name ="entry")
    public EntryHel2 getEntryCure() { 
         return entryCure;
    }
    @XmlElement( name ="entry")
    public EntryLife getEntryKF() { 
         return entryKF;
    }
    @XmlElement( name ="entry")
    public EntryLife getEntryUsecmp() { 
         return entryUsecmp;
    }
    @XmlElement( name ="entry")
    public EntryLife getEntryUsecmdt() { 
         return entryUsecmdt;
    }
    @XmlElement( name ="entry")
    public EntryLife getEntryDnur() { 
         return entryDnur;
    }
    @XmlElement( name ="entry")
    public EntryHel2 getEntryCureCn() { 
         return entryCureCn;
    }
    @XmlElement( name ="entry")
    public EntryHel getEntryMed() { 
         return entryMed;
    }
    @XmlElement( name ="entry")
    public EntryHel2 getEntryMedCn() { 
         return entryMedCn;
    }
    @XmlElement( name ="entry")
    public EntryHel2 getEntryBlood() { 
         return entryBlood;
    }
    @XmlElement( name ="entry")
    public EntryLife getEntryUsecme() { 
         return entryUsecme;
    }
    @XmlElement( name ="entry")
    public EntryHel2 getEntryHC() { 
         return entryHC;
    }
    @XmlElement( name ="entry")
    public EntryLife getEntryOhr() { 
         return entryOhr;
    }
    public  void setCode(Code code) { 
         this.code = code;
    }
    public  void setText(String text) { 
         this.text = text;
    }
    public  void setEntryType(EntryLife entryType) { 
         this.entryType = entryType;
    }
    public  void setEntryTotal(EntryHel entryTotal) { 
         this.entryTotal = entryTotal;
    }
    public  void setEntryZH(EntryHel2 entryZH) { 
         this.entryZH = entryZH;
    }
    public  void setEntryDi(EntryHel2 entryDi) { 
         this.entryDi = entryDi;
    }
    public  void setEntryCure(EntryHel2 entryCure) { 
         this.entryCure = entryCure;
    }
    public  void setEntryKF(EntryLife entryKF) { 
         this.entryKF = entryKF;
    }
    public  void setEntryUsecmp(EntryLife entryUsecmp) { 
        this.entryUsecmp = entryUsecmp;
   }
    public  void setEntryUsecmdt(EntryLife entryUsecmdt) { 
        this.entryUsecmdt = entryUsecmdt;
   }
    public  void setEntryDnur(EntryLife entryDnur) { 
        this.entryDnur = entryDnur;
   }
    public  void setEntryCureCn(EntryHel2 entryCureCn) { 
         this.entryCureCn = entryCureCn;
    }
    public  void setEntryMed(EntryHel entryMed) { 
         this.entryMed = entryMed;
    }
    public  void setEntryMedCn(EntryHel2 entryMedCn) { 
         this.entryMedCn = entryMedCn;
    }
    public  void setEntryBlood(EntryHel2 entryBlood) { 
         this.entryBlood = entryBlood;
    }
    public  void setEntryUsecme(EntryLife entryUsecme) { 
        this.entryUsecme = entryUsecme;
   }
    public  void setEntryHC(EntryHel2 entryHC) { 
         this.entryHC = entryHC;
    }
    public  void setEntryOhr(EntryLife entryOhr) { 
         this.entryOhr = entryOhr;
    }
}
