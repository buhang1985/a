package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCPatientNote
{
    @JsonProperty(value = "DCPatientNote")
    private DCPatientNote[] DCPatientNote;

    public void setDCPatientNote(DCPatientNote[] DCPatientNote)
    {
        this.DCPatientNote = DCPatientNote;
    }
    public DCPatientNote[] getDCPatientNote()
    {
        return this.DCPatientNote;
    }
}
