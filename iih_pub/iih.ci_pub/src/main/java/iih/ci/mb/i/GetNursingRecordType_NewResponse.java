package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetNursingRecordType_NewResponse
{
    @JsonProperty(value = "GetNursingRecordType_NewResult")
    private ArrayOfNDCNursingRecordType GetNursingRecordType_NewResult;

    public void setGetNursingRecordType_NewResult(ArrayOfNDCNursingRecordType GetNursingRecordType_NewResult)
    {
        this.GetNursingRecordType_NewResult = GetNursingRecordType_NewResult;
    }
    public ArrayOfNDCNursingRecordType getGetNursingRecordType_NewResult()
    {
        return this.GetNursingRecordType_NewResult;
    }
}
