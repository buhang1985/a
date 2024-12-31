package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class CallEngineTreeResponse
{
    @JsonProperty(value = "CallEngineTreeResult")
    private String CallEngineTreeResult;

    public void setCallEngineTreeResult(String CallEngineTreeResult)
    {
        this.CallEngineTreeResult = CallEngineTreeResult;
    }
    public String getCallEngineTreeResult()
    {
        return this.CallEngineTreeResult;
    }
}
