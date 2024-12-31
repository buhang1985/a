package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetPinCi_YiZhuResponse
{
    @JsonProperty(value = "GetPinCi_YiZhuResult")
    private ArrayOfYZPinCi GetPinCi_YiZhuResult;

    public void setGetPinCi_YiZhuResult(ArrayOfYZPinCi GetPinCi_YiZhuResult)
    {
        this.GetPinCi_YiZhuResult = GetPinCi_YiZhuResult;
    }
    public ArrayOfYZPinCi getGetPinCi_YiZhuResult()
    {
        return this.GetPinCi_YiZhuResult;
    }
}
