package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class CreateChangeDutyInfoResponse
{
    @JsonProperty(value = "CreateChangeDutyInfoResult")
    private Boolean CreateChangeDutyInfoResult;

    public void setCreateChangeDutyInfoResult(Boolean CreateChangeDutyInfoResult)
    {
        this.CreateChangeDutyInfoResult = CreateChangeDutyInfoResult;
    }
    public Boolean getCreateChangeDutyInfoResult()
    {
        return this.CreateChangeDutyInfoResult;
    }
}
