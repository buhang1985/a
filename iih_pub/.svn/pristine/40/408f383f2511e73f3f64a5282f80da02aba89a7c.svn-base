package iih.ci.mrfp.mrfpxml.d;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"id","code","playingEntity"})
public class ParticipantRole {
    
	private String classCode;
	private Identification id;
    private Code code;
    private PlayingEntity playingEntity;
    @XmlAttribute( name ="classCode")
    public String getClassCode() { 
         return classCode;
    }
    @XmlElement( name ="id")
    public Identification getId() { 
         return id;
    }
    @XmlElement( name ="code")
    public Code getCode() { 
         return code;
    }
    @XmlElement( name ="playingEntity")
    public PlayingEntity getPlayingEntity() { 
         return playingEntity;
    }
    public  void setClassCode(String classCode) { 
         this.classCode = classCode;
    }
    public  void setId(Identification id) { 
        this.id = id;
   }
    public  void setCode(Code code) { 
        this.code = code;
   }
    public  void setPlayingEntity(PlayingEntity playingEntity) { 
         this.playingEntity = playingEntity;
    }
}
