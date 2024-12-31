package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class UpdateVitalSignOfPatientHRRequest
{
    @JsonProperty(value = "nursingRecord")
    private DCNursingRecord nursingRecord;

    public void setNursingRecord(DCNursingRecord nursingRecord)
    {
        this.nursingRecord = nursingRecord;
    }
    public DCNursingRecord getNursingRecord()
    {
        return this.nursingRecord;
    }
}
