package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetDSDetailResponse
{
    @JsonProperty(value = "GetDSDetailResult")
    private String GetDSDetailResult;

    public void setGetDSDetailResult(String GetDSDetailResult)
    {
        this.GetDSDetailResult = GetDSDetailResult;
    }
    public String getGetDSDetailResult()
    {
        return this.GetDSDetailResult;
    }
}
