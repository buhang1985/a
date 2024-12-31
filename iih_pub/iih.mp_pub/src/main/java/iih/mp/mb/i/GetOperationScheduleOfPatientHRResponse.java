package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetOperationScheduleOfPatientHRResponse
{
    @JsonProperty(value = "GetOperationScheduleOfPatientHRResult")
    private ArrayOfDCPatientOperationSchedule GetOperationScheduleOfPatientHRResult;

    public void setGetOperationScheduleOfPatientHRResult(ArrayOfDCPatientOperationSchedule GetOperationScheduleOfPatientHRResult)
    {
        this.GetOperationScheduleOfPatientHRResult = GetOperationScheduleOfPatientHRResult;
    }
    public ArrayOfDCPatientOperationSchedule getGetOperationScheduleOfPatientHRResult()
    {
        return this.GetOperationScheduleOfPatientHRResult;
    }
}
