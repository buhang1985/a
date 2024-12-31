package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetLeiBie_YiZhuResponse
{
    @JsonProperty(value = "GetLeiBie_YiZhuResult")
    private ArrayOfYZLeiBie GetLeiBie_YiZhuResult;

    public void setGetLeiBie_YiZhuResult(ArrayOfYZLeiBie GetLeiBie_YiZhuResult)
    {
        this.GetLeiBie_YiZhuResult = GetLeiBie_YiZhuResult;
    }
    public ArrayOfYZLeiBie getGetLeiBie_YiZhuResult()
    {
        return this.GetLeiBie_YiZhuResult;
    }
}
