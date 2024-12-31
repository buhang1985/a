package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetNursingRecordFileByFileID_NewResponse
{
    @JsonProperty(value = "GetNursingRecordFileByFileID_NewResult")
    private NDCNursingRecordFile GetNursingRecordFileByFileID_NewResult;

    public void setGetNursingRecordFileByFileID_NewResult(NDCNursingRecordFile GetNursingRecordFileByFileID_NewResult)
    {
        this.GetNursingRecordFileByFileID_NewResult = GetNursingRecordFileByFileID_NewResult;
    }
    public NDCNursingRecordFile getGetNursingRecordFileByFileID_NewResult()
    {
        return this.GetNursingRecordFileByFileID_NewResult;
    }
}
