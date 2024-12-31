package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetLongDoctorAdviceOfPatientResponse
{
    @JsonProperty(value = "GetLongDoctorAdviceOfPatientResult")
    private ArrayOfDCSplitDoctorAdvice GetLongDoctorAdviceOfPatientResult;

    public void setGetLongDoctorAdviceOfPatientResult(ArrayOfDCSplitDoctorAdvice GetLongDoctorAdviceOfPatientResult)
    {
        this.GetLongDoctorAdviceOfPatientResult = GetLongDoctorAdviceOfPatientResult;
    }
    public ArrayOfDCSplitDoctorAdvice getGetLongDoctorAdviceOfPatientResult()
    {
        return this.GetLongDoctorAdviceOfPatientResult;
    }
}
