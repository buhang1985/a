package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetVitalSignOfPatientHRAtTimePoint_NewResponse
{
    @JsonProperty(value = "GetVitalSignOfPatientHRAtTimePoint_NewResult")
    private NDCNursingRecordItem GetVitalSignOfPatientHRAtTimePoint_NewResult;

    public void setGetVitalSignOfPatientHRAtTimePoint_NewResult(NDCNursingRecordItem GetVitalSignOfPatientHRAtTimePoint_NewResult)
    {
        this.GetVitalSignOfPatientHRAtTimePoint_NewResult = GetVitalSignOfPatientHRAtTimePoint_NewResult;
    }
    public NDCNursingRecordItem getGetVitalSignOfPatientHRAtTimePoint_NewResult()
    {
        return this.GetVitalSignOfPatientHRAtTimePoint_NewResult;
    }
}
