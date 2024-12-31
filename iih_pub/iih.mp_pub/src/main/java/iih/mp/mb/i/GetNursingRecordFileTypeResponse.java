package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetNursingRecordFileTypeResponse
{
    @JsonProperty(value = "GetNursingRecordFileTypeResult")
    private ArrayOfDCNursingRecordFileType GetNursingRecordFileTypeResult;

    public void setGetNursingRecordFileTypeResult(ArrayOfDCNursingRecordFileType GetNursingRecordFileTypeResult)
    {
        this.GetNursingRecordFileTypeResult = GetNursingRecordFileTypeResult;
    }
    public ArrayOfDCNursingRecordFileType getGetNursingRecordFileTypeResult()
    {
        return this.GetNursingRecordFileTypeResult;
    }
}
