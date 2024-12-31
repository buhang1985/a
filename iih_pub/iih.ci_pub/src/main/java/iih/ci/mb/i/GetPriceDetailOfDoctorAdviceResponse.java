package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetPriceDetailOfDoctorAdviceResponse
{
    @JsonProperty(value = "GetPriceDetailOfDoctorAdviceResult")
    private ArrayOfDCDoctorAdvicePriceDetail GetPriceDetailOfDoctorAdviceResult;

    public void setGetPriceDetailOfDoctorAdviceResult(ArrayOfDCDoctorAdvicePriceDetail GetPriceDetailOfDoctorAdviceResult)
    {
        this.GetPriceDetailOfDoctorAdviceResult = GetPriceDetailOfDoctorAdviceResult;
    }
    public ArrayOfDCDoctorAdvicePriceDetail getGetPriceDetailOfDoctorAdviceResult()
    {
        return this.GetPriceDetailOfDoctorAdviceResult;
    }
}
