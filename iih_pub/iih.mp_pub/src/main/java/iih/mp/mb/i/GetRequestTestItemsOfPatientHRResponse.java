package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetRequestTestItemsOfPatientHRResponse
{
    @JsonProperty(value = "GetRequestTestItemsOfPatientHRResult")
    private ArrayOfDCPatientRequestTestItem GetRequestTestItemsOfPatientHRResult;

    public void setGetRequestTestItemsOfPatientHRResult(ArrayOfDCPatientRequestTestItem GetRequestTestItemsOfPatientHRResult)
    {
        this.GetRequestTestItemsOfPatientHRResult = GetRequestTestItemsOfPatientHRResult;
    }
    public ArrayOfDCPatientRequestTestItem getGetRequestTestItemsOfPatientHRResult()
    {
        return this.GetRequestTestItemsOfPatientHRResult;
    }
}
