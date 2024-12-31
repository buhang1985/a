package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetSpecialDoctorOrderResponse
{
    @JsonProperty(value = "GetSpecialDoctorOrderResult")
    private ArrayOfDCUnExpectedItem GetSpecialDoctorOrderResult;

    public void setGetSpecialDoctorOrderResult(ArrayOfDCUnExpectedItem GetSpecialDoctorOrderResult)
    {
        this.GetSpecialDoctorOrderResult = GetSpecialDoctorOrderResult;
    }
    public ArrayOfDCUnExpectedItem getGetSpecialDoctorOrderResult()
    {
        return this.GetSpecialDoctorOrderResult;
    }
}
