package iih.ci.mrfp.mrfpxml.d;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"code","text","entryPaDe","observation"})
public class SectionQu {
    private Code code;
    private String text;
    private EntryLife entryPaDe;
    private List<ObservationQu> observation;
    @XmlElement( name ="code")
    public Code getCode() { 
         return code;
    }
    @XmlElement( name ="text")
    public String getText() { 
         return text;
    }
    @XmlElement( name ="entry")
    public EntryLife getEntryPaDe() { 
         return entryPaDe;
    }
    @XmlElementWrapper(name="entry")
    @XmlElement( name ="observation")
    public List<ObservationQu> getObservation() { 
         return observation;
    }
    public  void setCode(Code code) { 
         this.code = code;
    }
    public  void setText(String text) { 
         this.text = text;
    }
    public  void setEntryPaDe(EntryLife entryPaDe) { 
         this.entryPaDe = entryPaDe;
    }
    public void setObservation( List <ObservationQu> observation) { 
         this.observation = observation;
    }
}
