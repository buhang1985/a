package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetBloodConditionOfPatientNoResponse
{
    @JsonProperty(value = "GetBloodConditionOfPatientNoResult")
    private ArrayOfDCPatientBloodCondition GetBloodConditionOfPatientNoResult;

    public void setGetBloodConditionOfPatientNoResult(ArrayOfDCPatientBloodCondition GetBloodConditionOfPatientNoResult)
    {
        this.GetBloodConditionOfPatientNoResult = GetBloodConditionOfPatientNoResult;
    }
    public ArrayOfDCPatientBloodCondition getGetBloodConditionOfPatientNoResult()
    {
        return this.GetBloodConditionOfPatientNoResult;
    }
}
