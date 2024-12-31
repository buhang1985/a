package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class sendWebSocketMSGResponse
{
    @JsonProperty(value = "sendWebSocketMSGResult")
    private Boolean sendWebSocketMSGResult;

    public void setSendWebSocketMSGResult(Boolean sendWebSocketMSGResult)
    {
        this.sendWebSocketMSGResult = sendWebSocketMSGResult;
    }
    public Boolean getSendWebSocketMSGResult()
    {
        return this.sendWebSocketMSGResult;
    }
}
