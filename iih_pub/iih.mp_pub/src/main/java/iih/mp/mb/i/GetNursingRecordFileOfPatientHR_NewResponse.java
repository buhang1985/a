package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetNursingRecordFileOfPatientHR_NewResponse
{
    @JsonProperty(value = "GetNursingRecordFileOfPatientHR_NewResult")
    private ArrayOfNDCNursingRecordFile GetNursingRecordFileOfPatientHR_NewResult;

    public void setGetNursingRecordFileOfPatientHR_NewResult(ArrayOfNDCNursingRecordFile GetNursingRecordFileOfPatientHR_NewResult)
    {
        this.GetNursingRecordFileOfPatientHR_NewResult = GetNursingRecordFileOfPatientHR_NewResult;
    }
    public ArrayOfNDCNursingRecordFile getGetNursingRecordFileOfPatientHR_NewResult()
    {
        return this.GetNursingRecordFileOfPatientHR_NewResult;
    }
}
