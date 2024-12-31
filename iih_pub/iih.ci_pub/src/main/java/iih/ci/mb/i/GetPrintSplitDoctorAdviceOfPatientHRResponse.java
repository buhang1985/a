package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetPrintSplitDoctorAdviceOfPatientHRResponse
{
    @JsonProperty(value = "GetPrintSplitDoctorAdviceOfPatientHRResult")
    private ArrayOfDCSplitDoctorAdvice GetPrintSplitDoctorAdviceOfPatientHRResult;

    public void setGetPrintSplitDoctorAdviceOfPatientHRResult(ArrayOfDCSplitDoctorAdvice GetPrintSplitDoctorAdviceOfPatientHRResult)
    {
        this.GetPrintSplitDoctorAdviceOfPatientHRResult = GetPrintSplitDoctorAdviceOfPatientHRResult;
    }
    public ArrayOfDCSplitDoctorAdvice getGetPrintSplitDoctorAdviceOfPatientHRResult()
    {
        return this.GetPrintSplitDoctorAdviceOfPatientHRResult;
    }
}
