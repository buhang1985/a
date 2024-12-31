package iih.ci.mrfp.mrfpxml.d;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class EntrySug {
	 private ProcedureSug procedure;
	
	    @XmlElement( name ="procedure")
	    public ProcedureSug getProcedure() { 
	         return procedure;
	    }
	    public void setProcedure( ProcedureSug procedure) { 
	         this.procedure = procedure;
	    }
}
