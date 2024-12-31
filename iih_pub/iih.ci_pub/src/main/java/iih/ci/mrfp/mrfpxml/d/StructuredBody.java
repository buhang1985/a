package iih.ci.mrfp.mrfpxml.d;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"sectionLife","sectionDi","sectionHel","sectionChDep","sectionOutHos",
		"sectionAlg","sectionTest","sectionSug","sectionIHH","sectionQu","sectionIHC","sectionCP","sectionBL"})
public class StructuredBody {
    private List<SectionLife> sectionLife;
    private List<SectionDi> sectionDi;
    private List<SectionHel> sectionHel;
    private List<SectionChDep> sectionChDep;
    private List<SectionOutHos> sectionOutHos;
    private List<SectionAlg> sectionAlg;
    private List<SectionDi> sectionTest;
    private List<SectionSug> sectionSug;
    private List<SectionIHH> sectionIHH;
    private List<SectionIHH> sectionIHC;
    private List<SectionQu> sectionQu;
    private List<SectionCP> sectionCP;
    private List<SectionBL> sectionBL;
    @XmlElementWrapper(name="component")
    @XmlElement( name ="section")
    public List<SectionLife> getSectionLife() { 
         return sectionLife;
    }
    @XmlElementWrapper(name="component")
    @XmlElement( name ="section")
    public List<SectionDi> getSectionDi() { 
         return sectionDi;
    }
    @XmlElementWrapper(name="component")
    @XmlElement( name ="section")
    public List<SectionHel> getSectionHel() { 
         return sectionHel;
    }
    @XmlElementWrapper(name="component")
    @XmlElement( name ="section")
    public List<SectionChDep> getSectionChDep() { 
         return sectionChDep;
    }
    @XmlElementWrapper(name="component")
    @XmlElement( name ="section")
    public List<SectionOutHos> getSectionOutHos() { 
         return sectionOutHos;
    }
    @XmlElementWrapper(name="component")
    @XmlElement( name ="section")
    public List<SectionAlg> getSectionAlg() { 
         return sectionAlg;
    }
    @XmlElementWrapper(name="component")
    @XmlElement( name ="section")
    public List<SectionDi> getSectionTest() { 
         return sectionTest;
    }
    @XmlElementWrapper(name="component")
    @XmlElement( name ="section")
    public List<SectionSug> getSectionSug() { 
         return sectionSug;
    }
    @XmlElementWrapper(name="component")
    @XmlElement( name ="section")
    public List<SectionIHH> getSectionIHH() { 
         return sectionIHH;
    }
    @XmlElementWrapper(name="component")
    @XmlElement( name ="section")
    public List<SectionIHH> getSectionIHC() { 
         return sectionIHC;
    }
    @XmlElementWrapper(name="component")
    @XmlElement( name ="section")
    public List<SectionQu> getSectionQu() { 
         return sectionQu;
    }
    @XmlElementWrapper(name="component")
    @XmlElement( name ="section")
    public List<SectionCP> getSectionCP() { 
         return sectionCP;
    }
    @XmlElementWrapper(name="component")
    @XmlElement( name ="section")
    public List<SectionBL> getSectionBL() { 
         return sectionBL;
    }
    public void setSectionLife( List <SectionLife> sectionLife) { 
         this.sectionLife = sectionLife;
    }
    public void setSectionDi( List <SectionDi> sectionDi) { 
         this.sectionDi = sectionDi;
    }
    public void setSectionHel( List <SectionHel> sectionHel) { 
         this.sectionHel = sectionHel;
    }
    public void setSectionChDep( List <SectionChDep> sectionChDep) { 
         this.sectionChDep = sectionChDep;
    }
    public void setSectionOutHos( List <SectionOutHos> sectionOutHos) { 
         this.sectionOutHos = sectionOutHos;
    }
    public void setSectionAlg( List <SectionAlg> sectionAlg) { 
         this.sectionAlg = sectionAlg;
    }
    public void setSectionTest( List <SectionDi> sectionTest) { 
         this.sectionTest = sectionTest;
    }
    public void setSectionSug( List <SectionSug> sectionSug) { 
         this.sectionSug = sectionSug;
    }
    public void setSectionIHH( List <SectionIHH> sectionIHH) { 
         this.sectionIHH = sectionIHH;
    }
    public void setSectionIHC( List <SectionIHH> sectionIHC) { 
         this.sectionIHC = sectionIHC;
    }
    public void setSectionQu( List <SectionQu> sectionQu) { 
         this.sectionQu = sectionQu;
    }
    public void setSectionCP( List <SectionCP> sectionCP) { 
         this.sectionCP = sectionCP;
    }
    public void setSectionBL( List <SectionBL> sectionBL) { 
         this.sectionBL = sectionBL;
    }
}
