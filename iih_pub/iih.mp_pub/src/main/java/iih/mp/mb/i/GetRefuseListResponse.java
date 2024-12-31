package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetRefuseListResponse
{
    @JsonProperty(value = "GetRefuseListResult")
    private ArrayOfDCMsg GetRefuseListResult;

    public void setGetRefuseListResult(ArrayOfDCMsg GetRefuseListResult)
    {
        this.GetRefuseListResult = GetRefuseListResult;
    }
    public ArrayOfDCMsg getGetRefuseListResult()
    {
        return this.GetRefuseListResult;
    }
}
