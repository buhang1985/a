package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCPatientPathologicalRecord
{
    @JsonProperty(value = "DCPatientPathologicalRecord")
    private DCPatientPathologicalRecord[] DCPatientPathologicalRecord;

    public void setDCPatientPathologicalRecord(DCPatientPathologicalRecord[] DCPatientPathologicalRecord)
    {
        this.DCPatientPathologicalRecord = DCPatientPathologicalRecord;
    }
    public DCPatientPathologicalRecord[] getDCPatientPathologicalRecord()
    {
        return this.DCPatientPathologicalRecord;
    }
}
