package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetBuWei_YiZhuResponse
{
    @JsonProperty(value = "GetBuWei_YiZhuResult")
    private ArrayOfYZPosition GetBuWei_YiZhuResult;

    public void setGetBuWei_YiZhuResult(ArrayOfYZPosition GetBuWei_YiZhuResult)
    {
        this.GetBuWei_YiZhuResult = GetBuWei_YiZhuResult;
    }
    public ArrayOfYZPosition getGetBuWei_YiZhuResult()
    {
        return this.GetBuWei_YiZhuResult;
    }
}
