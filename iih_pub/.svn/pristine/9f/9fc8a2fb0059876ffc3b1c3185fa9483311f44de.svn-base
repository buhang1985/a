package iih.ci.mrfp.mrfpxml.d;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"code","text","entrySugs"})
public class SectionSug {
    private Code code;
    private String text;
    private List<EntrySug> entrySugs;
    @XmlElement( name ="code")
    public Code getCode() { 
         return code;
    }
    @XmlElement( name ="text" , nillable = true)
    public String getText() { 
         return text;
    }
    @XmlElement(name="entry")
    public List<EntrySug> getEntrySugs() { 
         return entrySugs;
    }
    public  void setCode(Code code) { 
         this.code = code;
    }
    public  void setText(String text) { 
         this.text = text;
    }
    public void setEntrySugs( List<EntrySug> entrySugs) { 
         this.entrySugs = entrySugs;
    }
}
