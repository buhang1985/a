package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetGeneralOrderResponse
{
    @JsonProperty(value = "GetGeneralOrderResult")
    private ArrayOfDCSplitDoctorAdvice GetGeneralOrderResult;

    public void setGetGeneralOrderResult(ArrayOfDCSplitDoctorAdvice GetGeneralOrderResult)
    {
        this.GetGeneralOrderResult = GetGeneralOrderResult;
    }
    public ArrayOfDCSplitDoctorAdvice getGetGeneralOrderResult()
    {
        return this.GetGeneralOrderResult;
    }
}
