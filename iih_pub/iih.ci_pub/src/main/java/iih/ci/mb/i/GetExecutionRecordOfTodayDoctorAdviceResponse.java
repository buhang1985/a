package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetExecutionRecordOfTodayDoctorAdviceResponse
{
    @JsonProperty(value = "GetExecutionRecordOfTodayDoctorAdviceResult")
    private ArrayOfDCDoctorAdviceExecutionRecord GetExecutionRecordOfTodayDoctorAdviceResult;

    public void setGetExecutionRecordOfTodayDoctorAdviceResult(ArrayOfDCDoctorAdviceExecutionRecord GetExecutionRecordOfTodayDoctorAdviceResult)
    {
        this.GetExecutionRecordOfTodayDoctorAdviceResult = GetExecutionRecordOfTodayDoctorAdviceResult;
    }
    public ArrayOfDCDoctorAdviceExecutionRecord getGetExecutionRecordOfTodayDoctorAdviceResult()
    {
        return this.GetExecutionRecordOfTodayDoctorAdviceResult;
    }
}
