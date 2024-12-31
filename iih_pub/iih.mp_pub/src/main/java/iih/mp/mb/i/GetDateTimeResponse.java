package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetDateTimeResponse
{
    @JsonProperty(value = "GetDateTimeResult")
    private String GetDateTimeResult;

    public void setGetDateTimeResult(String GetDateTimeResult)
    {
        this.GetDateTimeResult = GetDateTimeResult;
    }
    public String getGetDateTimeResult()
    {
        return this.GetDateTimeResult;
    }
}
