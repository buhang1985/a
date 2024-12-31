package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class TSLoginResponse
{
    @JsonProperty(value = "TSLoginResult")
    private TSUser TSLoginResult;

    public void setTSLoginResult(TSUser TSLoginResult)
    {
        this.TSLoginResult = TSLoginResult;
    }
    public TSUser getTSLoginResult()
    {
        return this.TSLoginResult;
    }
}
