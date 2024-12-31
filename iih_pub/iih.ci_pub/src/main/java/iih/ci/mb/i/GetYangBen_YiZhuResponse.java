package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetYangBen_YiZhuResponse
{
    @JsonProperty(value = "GetYangBen_YiZhuResult")
    private ArrayOfYZYangBen GetYangBen_YiZhuResult;

    public void setGetYangBen_YiZhuResult(ArrayOfYZYangBen GetYangBen_YiZhuResult)
    {
        this.GetYangBen_YiZhuResult = GetYangBen_YiZhuResult;
    }
    public ArrayOfYZYangBen getGetYangBen_YiZhuResult()
    {
        return this.GetYangBen_YiZhuResult;
    }
}
