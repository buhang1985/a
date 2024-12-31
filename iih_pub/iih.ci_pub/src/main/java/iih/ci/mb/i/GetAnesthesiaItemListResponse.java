package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetAnesthesiaItemListResponse
{
    @JsonProperty(value = "GetAnesthesiaItemListResult")
    private ArrayOfDCAnesthesiaItemList GetAnesthesiaItemListResult;

    public void setGetAnesthesiaItemListResult(ArrayOfDCAnesthesiaItemList GetAnesthesiaItemListResult)
    {
        this.GetAnesthesiaItemListResult = GetAnesthesiaItemListResult;
    }
    public ArrayOfDCAnesthesiaItemList getGetAnesthesiaItemListResult()
    {
        return this.GetAnesthesiaItemListResult;
    }
}
