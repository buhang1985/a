package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetPathologicalRecordOfPatientNoNewResponse
{
    @JsonProperty(value = "GetPathologicalRecordOfPatientNoNewResult")
    private ArrayOfDCPatientPathologicalRecord GetPathologicalRecordOfPatientNoNewResult;

    public void setGetPathologicalRecordOfPatientNoNewResult(ArrayOfDCPatientPathologicalRecord GetPathologicalRecordOfPatientNoNewResult)
    {
        this.GetPathologicalRecordOfPatientNoNewResult = GetPathologicalRecordOfPatientNoNewResult;
    }
    public ArrayOfDCPatientPathologicalRecord getGetPathologicalRecordOfPatientNoNewResult()
    {
        return this.GetPathologicalRecordOfPatientNoNewResult;
    }
}
