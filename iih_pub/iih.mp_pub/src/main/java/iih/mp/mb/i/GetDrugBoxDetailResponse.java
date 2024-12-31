package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetDrugBoxDetailResponse
{
    @JsonProperty(value = "GetDrugBoxDetailResult")
    private ArrayOfDCDrugBoxDetail GetDrugBoxDetailResult;

    public void setGetDrugBoxDetailResult(ArrayOfDCDrugBoxDetail GetDrugBoxDetailResult)
    {
        this.GetDrugBoxDetailResult = GetDrugBoxDetailResult;
    }
    public ArrayOfDCDrugBoxDetail getGetDrugBoxDetailResult()
    {
        return this.GetDrugBoxDetailResult;
    }
}
