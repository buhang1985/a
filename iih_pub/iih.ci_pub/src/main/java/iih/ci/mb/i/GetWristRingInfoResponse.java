package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetWristRingInfoResponse
{
    @JsonProperty(value = "GetWristRingInfoResult")
    private String GetWristRingInfoResult;

    public void setGetWristRingInfoResult(String GetWristRingInfoResult)
    {
        this.GetWristRingInfoResult = GetWristRingInfoResult;
    }
    public String getGetWristRingInfoResult()
    {
        return this.GetWristRingInfoResult;
    }
}
