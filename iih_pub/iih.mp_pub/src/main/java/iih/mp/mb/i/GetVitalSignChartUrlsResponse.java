package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import xap.sys.mb.i.ArrayOfString;

public class GetVitalSignChartUrlsResponse
{
    @JsonProperty(value = "GetVitalSignChartUrlsResult")
    private ArrayOfString GetVitalSignChartUrlsResult;

    public void setGetVitalSignChartUrlsResult(ArrayOfString GetVitalSignChartUrlsResult)
    {
        this.GetVitalSignChartUrlsResult = GetVitalSignChartUrlsResult;
    }
    public ArrayOfString getGetVitalSignChartUrlsResult()
    {
        return this.GetVitalSignChartUrlsResult;
    }
}
