package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetPrepaymentDetailOfPatientHRResponse
{
    @JsonProperty(value = "GetPrepaymentDetailOfPatientHRResult")
    private ArrayOfDCPrepaymentDetail GetPrepaymentDetailOfPatientHRResult;

    public void setGetPrepaymentDetailOfPatientHRResult(ArrayOfDCPrepaymentDetail GetPrepaymentDetailOfPatientHRResult)
    {
        this.GetPrepaymentDetailOfPatientHRResult = GetPrepaymentDetailOfPatientHRResult;
    }
    public ArrayOfDCPrepaymentDetail getGetPrepaymentDetailOfPatientHRResult()
    {
        return this.GetPrepaymentDetailOfPatientHRResult;
    }
}
