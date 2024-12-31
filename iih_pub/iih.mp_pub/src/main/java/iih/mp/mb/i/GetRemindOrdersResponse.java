package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetRemindOrdersResponse
{
    @JsonProperty(value = "GetRemindOrdersResult")
    private ArrayOfDCSplitDoctorAdvice GetRemindOrdersResult;

    public void setGetRemindOrdersResult(ArrayOfDCSplitDoctorAdvice GetRemindOrdersResult)
    {
        this.GetRemindOrdersResult = GetRemindOrdersResult;
    }
    public ArrayOfDCSplitDoctorAdvice getGetRemindOrdersResult()
    {
        return this.GetRemindOrdersResult;
    }
}
