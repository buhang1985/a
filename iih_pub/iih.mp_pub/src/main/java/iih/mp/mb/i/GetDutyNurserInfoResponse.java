package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetDutyNurserInfoResponse
{
    @JsonProperty(value = "GetDutyNurserInfoResult")
    private ArrayOfDCDutyNurser GetDutyNurserInfoResult;

    public void setGetDutyNurserInfoResult(ArrayOfDCDutyNurser GetDutyNurserInfoResult)
    {
        this.GetDutyNurserInfoResult = GetDutyNurserInfoResult;
    }
    public ArrayOfDCDutyNurser getGetDutyNurserInfoResult()
    {
        return this.GetDutyNurserInfoResult;
    }
}
