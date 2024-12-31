package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetDCDoctorAdviceExecutionRecordOfIDResponse
{
    @JsonProperty(value = "GetDCDoctorAdviceExecutionRecordOfIDResult")
    private DCDoctorAdviceExecutionRecord GetDCDoctorAdviceExecutionRecordOfIDResult;

    public void setGetDCDoctorAdviceExecutionRecordOfIDResult(DCDoctorAdviceExecutionRecord GetDCDoctorAdviceExecutionRecordOfIDResult)
    {
        this.GetDCDoctorAdviceExecutionRecordOfIDResult = GetDCDoctorAdviceExecutionRecordOfIDResult;
    }
    public DCDoctorAdviceExecutionRecord getGetDCDoctorAdviceExecutionRecordOfIDResult()
    {
        return this.GetDCDoctorAdviceExecutionRecordOfIDResult;
    }
}
