package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetEMRReportContentResponse
{
    @JsonProperty(value = "GetEMRReportContentResult")
    private String GetEMRReportContentResult;

    public void setGetEMRReportContentResult(String GetEMRReportContentResult)
    {
        this.GetEMRReportContentResult = GetEMRReportContentResult;
    }
    public String getGetEMRReportContentResult()
    {
        return this.GetEMRReportContentResult;
    }
}
