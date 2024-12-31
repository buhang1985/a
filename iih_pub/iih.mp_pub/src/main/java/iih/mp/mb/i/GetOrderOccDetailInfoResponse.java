package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetOrderOccDetailInfoResponse
{
    @JsonProperty(value = "GetOrderOccDetailInfoResult")
    private ArrayOfDCOrderOccDetailInfo GetOrderOccDetailInfoResult;

    public void setGetOrderOccDetailInfoResult(ArrayOfDCOrderOccDetailInfo GetOrderOccDetailInfoResult)
    {
        this.GetOrderOccDetailInfoResult = GetOrderOccDetailInfoResult;
    }
    public ArrayOfDCOrderOccDetailInfo getGetOrderOccDetailInfoResult()
    {
        return this.GetOrderOccDetailInfoResult;
    }
}
