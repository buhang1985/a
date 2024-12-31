package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCOralAccountRecord
{
    @JsonProperty(value = "DCOralAccountRecord")
    private DCOralAccountRecord[] DCOralAccountRecord;

    public void setDCOralAccountRecord(DCOralAccountRecord[] DCOralAccountRecord)
    {
        this.DCOralAccountRecord = DCOralAccountRecord;
    }
    public DCOralAccountRecord[] getDCOralAccountRecord()
    {
        return this.DCOralAccountRecord;
    }
}
