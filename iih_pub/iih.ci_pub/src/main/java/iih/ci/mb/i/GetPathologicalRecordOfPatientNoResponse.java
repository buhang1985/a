package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetPathologicalRecordOfPatientNoResponse
{
    @JsonProperty(value = "GetPathologicalRecordOfPatientNoResult")
    private String GetPathologicalRecordOfPatientNoResult;

    public void setGetPathologicalRecordOfPatientNoResult(String GetPathologicalRecordOfPatientNoResult)
    {
        this.GetPathologicalRecordOfPatientNoResult = GetPathologicalRecordOfPatientNoResult;
    }
    public String getGetPathologicalRecordOfPatientNoResult()
    {
        return this.GetPathologicalRecordOfPatientNoResult;
    }
}
