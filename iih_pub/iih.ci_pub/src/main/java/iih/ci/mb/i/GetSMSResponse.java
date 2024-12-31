package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetSMSResponse
{
    @JsonProperty(value = "GetSMSResult")
    private Integer GetSMSResult;

    public void setGetSMSResult(Integer GetSMSResult)
    {
        this.GetSMSResult = GetSMSResult;
    }
    public Integer getGetSMSResult()
    {
        return this.GetSMSResult;
    }
}
