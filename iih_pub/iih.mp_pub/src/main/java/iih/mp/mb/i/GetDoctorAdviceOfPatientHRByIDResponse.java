package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetDoctorAdviceOfPatientHRByIDResponse
{
    @JsonProperty(value = "GetDoctorAdviceOfPatientHRByIDResult")
    private ArrayOfDCDoctorAdvice GetDoctorAdviceOfPatientHRByIDResult;

    public void setGetDoctorAdviceOfPatientHRByIDResult(ArrayOfDCDoctorAdvice GetDoctorAdviceOfPatientHRByIDResult)
    {
        this.GetDoctorAdviceOfPatientHRByIDResult = GetDoctorAdviceOfPatientHRByIDResult;
    }
    public ArrayOfDCDoctorAdvice getGetDoctorAdviceOfPatientHRByIDResult()
    {
        return this.GetDoctorAdviceOfPatientHRByIDResult;
    }
}
