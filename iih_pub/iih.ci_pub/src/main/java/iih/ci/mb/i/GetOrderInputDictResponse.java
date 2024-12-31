package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetOrderInputDictResponse
{
    @JsonProperty(value = "GetOrderInputDictResult")
    private ArrayOfYZOrderInputPublicDict GetOrderInputDictResult;

    public void setGetOrderInputDictResult(ArrayOfYZOrderInputPublicDict GetOrderInputDictResult)
    {
        this.GetOrderInputDictResult = GetOrderInputDictResult;
    }
    public ArrayOfYZOrderInputPublicDict getGetOrderInputDictResult()
    {
        return this.GetOrderInputDictResult;
    }
}
