package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetOneDayListOfPatientHRResponse
{
    @JsonProperty(value = "GetOneDayListOfPatientHRResult")
    private ArrayOfDCCostDetail GetOneDayListOfPatientHRResult;

    public void setGetOneDayListOfPatientHRResult(ArrayOfDCCostDetail GetOneDayListOfPatientHRResult)
    {
        this.GetOneDayListOfPatientHRResult = GetOneDayListOfPatientHRResult;
    }
    public ArrayOfDCCostDetail getGetOneDayListOfPatientHRResult()
    {
        return this.GetOneDayListOfPatientHRResult;
    }
}
