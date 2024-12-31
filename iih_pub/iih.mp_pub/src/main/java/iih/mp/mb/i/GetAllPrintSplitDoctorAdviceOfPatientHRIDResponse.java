package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetAllPrintSplitDoctorAdviceOfPatientHRIDResponse
{
    @JsonProperty(value = "GetAllPrintSplitDoctorAdviceOfPatientHRIDResult")
    private ArrayOfDCSplitDoctorAdvice GetAllPrintSplitDoctorAdviceOfPatientHRIDResult;

    public void setGetAllPrintSplitDoctorAdviceOfPatientHRIDResult(ArrayOfDCSplitDoctorAdvice GetAllPrintSplitDoctorAdviceOfPatientHRIDResult)
    {
        this.GetAllPrintSplitDoctorAdviceOfPatientHRIDResult = GetAllPrintSplitDoctorAdviceOfPatientHRIDResult;
    }
    public ArrayOfDCSplitDoctorAdvice getGetAllPrintSplitDoctorAdviceOfPatientHRIDResult()
    {
        return this.GetAllPrintSplitDoctorAdviceOfPatientHRIDResult;
    }
}
