package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetSysSetCheckValueResponse
{
    @JsonProperty(value = "GetSysSetCheckValueResult")
    private String GetSysSetCheckValueResult;

    public void setGetSysSetCheckValueResult(String GetSysSetCheckValueResult)
    {
        this.GetSysSetCheckValueResult = GetSysSetCheckValueResult;
    }
    public String getGetSysSetCheckValueResult()
    {
        return this.GetSysSetCheckValueResult;
    }
}
