package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetNursingRecordScheduleOfUserResponse
{
    @JsonProperty(value = "GetNursingRecordScheduleOfUserResult")
    private ArrayOfDCNursingRecordFile GetNursingRecordScheduleOfUserResult;

    public void setGetNursingRecordScheduleOfUserResult(ArrayOfDCNursingRecordFile GetNursingRecordScheduleOfUserResult)
    {
        this.GetNursingRecordScheduleOfUserResult = GetNursingRecordScheduleOfUserResult;
    }
    public ArrayOfDCNursingRecordFile getGetNursingRecordScheduleOfUserResult()
    {
        return this.GetNursingRecordScheduleOfUserResult;
    }
}
