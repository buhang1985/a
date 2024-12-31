package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetCheckTagOfPatientHRResponse
{
    @JsonProperty(value = "GetCheckTagOfPatientHRResult")
    private ArrayOfDCExecDoctorAdvice GetCheckTagOfPatientHRResult;

    public void setGetCheckTagOfPatientHRResult(ArrayOfDCExecDoctorAdvice GetCheckTagOfPatientHRResult)
    {
        this.GetCheckTagOfPatientHRResult = GetCheckTagOfPatientHRResult;
    }
    public ArrayOfDCExecDoctorAdvice getGetCheckTagOfPatientHRResult()
    {
        return this.GetCheckTagOfPatientHRResult;
    }
}
