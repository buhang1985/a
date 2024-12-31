package iih.ci.mrfp.mrfpxml.d;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"code","text","observation"})
public class SectionChDep {
    private Code code;
    private String text;
    private List<ObserVationChDep> observation;
    @XmlElement( name ="code" )
    public Code getCode() { 
         return code;
    }
    @XmlElement( name ="text" , nillable = true)
    public String getText() { 
         return text;
    }
    @XmlElementWrapper(name="entry")
    @XmlElement( name ="observation")
    public List<ObserVationChDep> getObservation() { 
         return observation;
    }
    public  void setCode(Code code) { 
         this.code = code;
    }
    public  void setText(String text) { 
         this.text = text;
    }
    public void setObservation( List <ObserVationChDep> observation) { 
         this.observation = observation;
    }
}
