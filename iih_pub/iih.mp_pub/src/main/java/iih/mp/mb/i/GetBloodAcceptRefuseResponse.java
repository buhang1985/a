package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetBloodAcceptRefuseResponse
{
    @JsonProperty(value = "GetBloodAcceptRefuseResult")
    private ArrayOfDCBloodAcceptRefuseType GetBloodAcceptRefuseResult;

    public void setGetBloodAcceptRefuseResult(ArrayOfDCBloodAcceptRefuseType GetBloodAcceptRefuseResult)
    {
        this.GetBloodAcceptRefuseResult = GetBloodAcceptRefuseResult;
    }
    public ArrayOfDCBloodAcceptRefuseType getGetBloodAcceptRefuseResult()
    {
        return this.GetBloodAcceptRefuseResult;
    }
}
