package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetDoctorAdviceOfPatientHRForExecuteResponse
{
    @JsonProperty(value = "GetDoctorAdviceOfPatientHRForExecuteResult")
    private ArrayOfDCDoctorAdvice GetDoctorAdviceOfPatientHRForExecuteResult;

    public void setGetDoctorAdviceOfPatientHRForExecuteResult(ArrayOfDCDoctorAdvice GetDoctorAdviceOfPatientHRForExecuteResult)
    {
        this.GetDoctorAdviceOfPatientHRForExecuteResult = GetDoctorAdviceOfPatientHRForExecuteResult;
    }
    public ArrayOfDCDoctorAdvice getGetDoctorAdviceOfPatientHRForExecuteResult()
    {
        return this.GetDoctorAdviceOfPatientHRForExecuteResult;
    }
}
