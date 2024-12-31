package iih.mp.mb.i;


import org.codehaus.jackson.annotate.JsonProperty;

public class GetYjjAndFeeOfPatientHRResponse
{
    @JsonProperty(value = "GetYjjAndFeeOfPatientHRResult")
    private DCPatientHospitalRecord GetYjjAndFeeOfPatientHRResult;

    public void setGetYjjAndFeeOfPatientHRResult(DCPatientHospitalRecord GetYjjAndFeeOfPatientHRResult)
    {
        this.GetYjjAndFeeOfPatientHRResult = GetYjjAndFeeOfPatientHRResult;
    }
    public DCPatientHospitalRecord getGetYjjAndFeeOfPatientHRResult()
    {
        return this.GetYjjAndFeeOfPatientHRResult;
    }
}
