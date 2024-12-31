package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetBeiZhu_YiZhuResponse
{
    @JsonProperty(value = "GetBeiZhu_YiZhuResult")
    private ArrayOfYZRemarks GetBeiZhu_YiZhuResult;

    public void setGetBeiZhu_YiZhuResult(ArrayOfYZRemarks GetBeiZhu_YiZhuResult)
    {
        this.GetBeiZhu_YiZhuResult = GetBeiZhu_YiZhuResult;
    }
    public ArrayOfYZRemarks getGetBeiZhu_YiZhuResult()
    {
        return this.GetBeiZhu_YiZhuResult;
    }
}
