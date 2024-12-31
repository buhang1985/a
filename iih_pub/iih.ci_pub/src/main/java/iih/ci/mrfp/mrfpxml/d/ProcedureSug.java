package iih.ci.mrfp.mrfpxml.d;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"code","statusCode","effectiveTime","assignedEntity","participant1","participant2","entryRelationshipName",
		"entryRelationshipLvl","entryRelationshipInLvl","entryRelationshipInGLvl","entryRelationshipAn"})
public class ProcedureSug {
    private String classCode;
    private String moodCode;
    private Code code;
    private String statusCode;
    private CValue effectiveTime;
    private List<AssignedAuthor> assignedEntity;
    private ParticipantAlg participant1;
    private ParticipantAlg participant2;
    private EntryRelationship entryRelationshipName;
    private EntryRelationship entryRelationshipLvl;
    private EntryRelationship entryRelationshipInLvl;
    private EntryRelationship entryRelationshipInGLvl;
    private EntryRelationshipSug entryRelationshipAn;
    @XmlAttribute( name ="classCode")
    public String getClassCode() { 
         return classCode;
    }
    @XmlAttribute( name ="moodCode")
    public String getMoodCode() { 
         return moodCode;
    }
    @XmlElement( name ="code")
    public Code getCode() { 
         return code;
    }
    @XmlElement( name ="statusCode" , nillable = true)
    public String getStatusCode() { 
         return statusCode;
    }
    @XmlElement( name ="effectiveTime")
    public CValue getEffectiveTime() { 
         return effectiveTime;
    }
    @XmlElementWrapper(name="performer")
    @XmlElement( name ="assignedEntity")
    public List<AssignedAuthor> getAssignedEntity() { 
         return assignedEntity;
    }
    @XmlElement( name ="participant")
    public ParticipantAlg getParticipant1() { 
         return participant1;
    }
    @XmlElement( name ="participant")
    public ParticipantAlg getParticipant2() { 
         return participant2;
    }
    @XmlElement( name ="entryRelationship")
    public EntryRelationship getEntryRelationshipName() { 
         return entryRelationshipName;
    }
    @XmlElement( name ="entryRelationship")
    public EntryRelationship getEntryRelationshipLvl() { 
         return entryRelationshipLvl;
    }
    @XmlElement( name ="entryRelationship")
    public EntryRelationship getEntryRelationshipInLvl() { 
         return entryRelationshipInLvl;
    }
    @XmlElement( name ="entryRelationship")
    public EntryRelationship getEntryRelationshipInGLvl() { 
         return entryRelationshipInGLvl;
    }
    @XmlElement( name ="entryRelationship")
    public EntryRelationshipSug getEntryRelationshipAn() { 
         return entryRelationshipAn;
    }
    public  void setClassCode(String classCode) { 
         this.classCode = classCode;
    }
    public  void setMoodCode(String moodCode) { 
         this.moodCode = moodCode;
    }
    public  void setCode(Code code) { 
         this.code = code;
    }
    public  void setStatusCode(String statusCode) { 
         this.statusCode = statusCode;
    }
    public  void setEffectiveTime(CValue effectiveTime) { 
         this.effectiveTime = effectiveTime;
    }
    public void setAssignedEntity( List <AssignedAuthor> assignedEntity) { 
         this.assignedEntity = assignedEntity;
    }
    public  void setParticipant1(ParticipantAlg participant1) { 
         this.participant1 = participant1;
    }
    public  void setParticipant2(ParticipantAlg participant2) { 
         this.participant2 = participant2;
    }
    public  void setEntryRelationshipName(EntryRelationship entryRelationshipName) { 
         this.entryRelationshipName = entryRelationshipName;
    }
    public  void setEntryRelationshipLvl(EntryRelationship entryRelationshipLvl) { 
         this.entryRelationshipLvl = entryRelationshipLvl;
    }
    public  void setEntryRelationshipInLvl(EntryRelationship entryRelationshipInLvl) { 
         this.entryRelationshipInLvl = entryRelationshipInLvl;
    }
    public  void setEntryRelationshipInGLvl(EntryRelationship entryRelationshipInGLvl) { 
         this.entryRelationshipInGLvl = entryRelationshipInGLvl;
    }
    public  void setEntryRelationshipAn(EntryRelationshipSug entryRelationshipAn) { 
         this.entryRelationshipAn = entryRelationshipAn;
    }
}
