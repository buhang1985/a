package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import xap.sys.mb.i.ArrayOfString;

public class GetYZOrderTypeResponse
{
    @JsonProperty(value = "GetYZOrderTypeResult")
    private ArrayOfString GetYZOrderTypeResult;

    public void setGetYZOrderTypeResult(ArrayOfString GetYZOrderTypeResult)
    {
        this.GetYZOrderTypeResult = GetYZOrderTypeResult;
    }
    public ArrayOfString getGetYZOrderTypeResult()
    {
        return this.GetYZOrderTypeResult;
    }
}
