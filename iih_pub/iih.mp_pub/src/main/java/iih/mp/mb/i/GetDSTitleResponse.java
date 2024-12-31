package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetDSTitleResponse
{
    @JsonProperty(value = "GetDSTitleResult")
    private String GetDSTitleResult;

    public void setGetDSTitleResult(String GetDSTitleResult)
    {
        this.GetDSTitleResult = GetDSTitleResult;
    }
    public String getGetDSTitleResult()
    {
        return this.GetDSTitleResult;
    }
}
