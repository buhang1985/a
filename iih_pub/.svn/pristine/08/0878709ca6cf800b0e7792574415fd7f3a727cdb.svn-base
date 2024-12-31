package iih.ci.mrfp.mrfpxml.d;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"code","author","entryRelationship"})
public class ActAlg {
    private String classCode;
    private String moodCode;
    private Code code;
    private Author author;
    private EntryRelationshipAlg entryRelationship;
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
    @XmlElement( name ="author")
    public Author getAuthor() { 
         return author;
    }
    @XmlElement( name ="entryRelationship")
    public EntryRelationshipAlg getEntryRelationship() { 
         return entryRelationship;
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
    public  void setAuthor(Author author) { 
        this.author = author;
   }
    public  void setEntryRelationship(EntryRelationshipAlg entryRelationship) { 
        this.entryRelationship = entryRelationship;
   }
}
