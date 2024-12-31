package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetCurrentDoctorAdviceOfPatientResponse
{
    @JsonProperty(value = "GetCurrentDoctorAdviceOfPatientResult")
    private ArrayOfDCSplitDoctorAdvice GetCurrentDoctorAdviceOfPatientResult;

    public void setGetCurrentDoctorAdviceOfPatientResult(ArrayOfDCSplitDoctorAdvice GetCurrentDoctorAdviceOfPatientResult)
    {
        this.GetCurrentDoctorAdviceOfPatientResult = GetCurrentDoctorAdviceOfPatientResult;
    }
    public ArrayOfDCSplitDoctorAdvice getGetCurrentDoctorAdviceOfPatientResult()
    {
        return this.GetCurrentDoctorAdviceOfPatientResult;
    }
}
