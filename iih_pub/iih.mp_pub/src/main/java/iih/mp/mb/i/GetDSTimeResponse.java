package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetDSTimeResponse
{
    @JsonProperty(value = "GetDSTimeResult")
    private String GetDSTimeResult;

    public void setGetDSTimeResult(String GetDSTimeResult)
    {
        this.GetDSTimeResult = GetDSTimeResult;
    }
    public String getGetDSTimeResult()
    {
        return this.GetDSTimeResult;
    }
}
