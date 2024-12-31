package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetExecDoctorAdviceOfPatientHRResponse
{
    @JsonProperty(value = "GetExecDoctorAdviceOfPatientHRResult")
    private ArrayOfDCExecDoctorAdvice GetExecDoctorAdviceOfPatientHRResult;

    public void setGetExecDoctorAdviceOfPatientHRResult(ArrayOfDCExecDoctorAdvice GetExecDoctorAdviceOfPatientHRResult)
    {
        this.GetExecDoctorAdviceOfPatientHRResult = GetExecDoctorAdviceOfPatientHRResult;
    }
    public ArrayOfDCExecDoctorAdvice getGetExecDoctorAdviceOfPatientHRResult()
    {
        return this.GetExecDoctorAdviceOfPatientHRResult;
    }
}
