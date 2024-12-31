package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetOralAccountRecordOfPatientHRResponse
{
    @JsonProperty(value = "GetOralAccountRecordOfPatientHRResult")
    private ArrayOfDCOralAccountRecord GetOralAccountRecordOfPatientHRResult;

    public void setGetOralAccountRecordOfPatientHRResult(ArrayOfDCOralAccountRecord GetOralAccountRecordOfPatientHRResult)
    {
        this.GetOralAccountRecordOfPatientHRResult = GetOralAccountRecordOfPatientHRResult;
    }
    public ArrayOfDCOralAccountRecord getGetOralAccountRecordOfPatientHRResult()
    {
        return this.GetOralAccountRecordOfPatientHRResult;
    }
}
