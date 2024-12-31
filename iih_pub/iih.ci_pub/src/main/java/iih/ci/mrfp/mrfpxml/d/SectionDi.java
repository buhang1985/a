package iih.ci.mrfp.mrfpxml.d;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"code","text","entry","organizerBl"})
public class SectionDi {
    private Code code;
    private String text;
    private List<EntryLife> entry;
    private List<OrganizerDi> organizerBl;
    @XmlElement( name ="code")
    public Code getCode() { 
         return code;
    }
    @XmlElement( name ="text" , nillable = true)
    public String getText() { 
         return text;
    }
   
    @XmlElement( name ="entry")
    public List<EntryLife> getEntry() { 
         return entry;
    }
    @XmlElementWrapper(name="entry")
    @XmlElement( name ="organizer")
    public List<OrganizerDi> getOrganizerBl() { 
         return organizerBl;
    }
    public  void setCode(Code code) { 
         this.code = code;
    }
    public  void setText(String text) { 
         this.text = text;
    }
    public void setEntry( List <EntryLife> entry) { 
         this.entry = entry;
    }
    public void setOrganizerBl( List <OrganizerDi> organizerBl) { 
         this.organizerBl = organizerBl;
    }
}
