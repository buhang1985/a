package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetPatientExecutionRecordByDurationResponse
{
    @JsonProperty(value = "GetPatientExecutionRecordByDurationResult")
    private ArrayOfDCDoctorAdviceExecutionRecord GetPatientExecutionRecordByDurationResult;

    public void setGetPatientExecutionRecordByDurationResult(ArrayOfDCDoctorAdviceExecutionRecord GetPatientExecutionRecordByDurationResult)
    {
        this.GetPatientExecutionRecordByDurationResult = GetPatientExecutionRecordByDurationResult;
    }
    public ArrayOfDCDoctorAdviceExecutionRecord getGetPatientExecutionRecordByDurationResult()
    {
        return this.GetPatientExecutionRecordByDurationResult;
    }
}
