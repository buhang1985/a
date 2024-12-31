package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetYiZhuLeiXing_YiZhuResponse
{
    @JsonProperty(value = "GetYiZhuLeiXing_YiZhuResult")
    private ArrayOfYZLeiXing GetYiZhuLeiXing_YiZhuResult;

    public void setGetYiZhuLeiXing_YiZhuResult(ArrayOfYZLeiXing GetYiZhuLeiXing_YiZhuResult)
    {
        this.GetYiZhuLeiXing_YiZhuResult = GetYiZhuLeiXing_YiZhuResult;
    }
    public ArrayOfYZLeiXing getGetYiZhuLeiXing_YiZhuResult()
    {
        return this.GetYiZhuLeiXing_YiZhuResult;
    }
}
