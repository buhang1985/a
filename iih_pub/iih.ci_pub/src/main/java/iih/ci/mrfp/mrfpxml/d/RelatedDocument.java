package iih.ci.mrfp.mrfpxml.d;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class RelatedDocument {
    private String typeCode;
    private ParentDocument parentDocument;
    @XmlAttribute( name ="typeCode")
    public String getTypeCode() { 
         return typeCode;
    }
    @XmlElement( name ="parentDocument")
    public ParentDocument getParentDocument() { 
         return parentDocument;
    }
    public  void setTypeCode(String typeCode) { 
         this.typeCode = typeCode;
    }
    public  void setParentDocument(ParentDocument parentDocument) { 
         this.parentDocument = parentDocument;
    }
}
