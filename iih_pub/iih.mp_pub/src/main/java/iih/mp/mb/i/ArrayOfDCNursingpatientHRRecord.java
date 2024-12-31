package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCNursingpatientHRRecord
{
    @JsonProperty(value = "DCNursingpatientHRRecord")
    private DCNursingpatientHRRecord[] DCNursingpatientHRRecord;

    public void setDCNursingpatientHRRecord(DCNursingpatientHRRecord[] DCNursingpatientHRRecord)
    {
        this.DCNursingpatientHRRecord = DCNursingpatientHRRecord;
    }
    public DCNursingpatientHRRecord[] getDCNursingpatientHRRecord()
    {
        return this.DCNursingpatientHRRecord;
    }
}
