package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCPackRecord
{
    @JsonProperty(value = "DCPackRecord")
    private DCPackRecord[] DCPackRecord;

    public void setDCPackRecord(DCPackRecord[] DCPackRecord)
    {
        this.DCPackRecord = DCPackRecord;
    }
    public DCPackRecord[] getDCPackRecord()
    {
        return this.DCPackRecord;
    }
}
