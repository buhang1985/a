package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetNursingRecordTypeResponse
{
    @JsonProperty(value = "GetNursingRecordTypeResult")
    private ArrayOfDCNursingRecordType GetNursingRecordTypeResult;

    public void setGetNursingRecordTypeResult(ArrayOfDCNursingRecordType GetNursingRecordTypeResult)
    {
        this.GetNursingRecordTypeResult = GetNursingRecordTypeResult;
    }
    public ArrayOfDCNursingRecordType getGetNursingRecordTypeResult()
    {
        return this.GetNursingRecordTypeResult;
    }
}
