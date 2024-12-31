package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetDoctorsRemindListResponse
{
    @JsonProperty(value = "GetDoctorsRemindListResult")
    private ArrayOfDCDoctorsRemind GetDoctorsRemindListResult;

    public void setGetDoctorsRemindListResult(ArrayOfDCDoctorsRemind GetDoctorsRemindListResult)
    {
        this.GetDoctorsRemindListResult = GetDoctorsRemindListResult;
    }
    public ArrayOfDCDoctorsRemind getGetDoctorsRemindListResult()
    {
        return this.GetDoctorsRemindListResult;
    }
}
