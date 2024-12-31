package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetZhiXingRen_YiZhuResponse
{
    @JsonProperty(value = "GetZhiXingRen_YiZhuResult")
    private ArrayOfYZZhiXingRen GetZhiXingRen_YiZhuResult;

    public void setGetZhiXingRen_YiZhuResult(ArrayOfYZZhiXingRen GetZhiXingRen_YiZhuResult)
    {
        this.GetZhiXingRen_YiZhuResult = GetZhiXingRen_YiZhuResult;
    }
    public ArrayOfYZZhiXingRen getGetZhiXingRen_YiZhuResult()
    {
        return this.GetZhiXingRen_YiZhuResult;
    }
}
