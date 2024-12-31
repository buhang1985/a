package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetMsgResponse
{
    @JsonProperty(value = "GetMsgResult")
    private ArrayOfDCMsgResult GetMsgResult;

    public void setGetMsgResult(ArrayOfDCMsgResult GetMsgResult)
    {
        this.GetMsgResult = GetMsgResult;
    }
    public ArrayOfDCMsgResult getGetMsgResult()
    {
        return this.GetMsgResult;
    }
}
