package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class UpdateConsulApplyListResponse
{
    @JsonProperty(value = "UpdateConsulApplyListResult")
    private Integer UpdateConsulApplyListResult;

    public void setUpdateConsulApplyListResult(Integer UpdateConsulApplyListResult)
    {
        this.UpdateConsulApplyListResult = UpdateConsulApplyListResult;
    }
    public Integer getUpdateConsulApplyListResult()
    {
        return this.UpdateConsulApplyListResult;
    }
}
