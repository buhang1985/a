package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class SubmitTaskRequest
{
    @JsonProperty(value = "taskDetail")
    private DCNurseTask taskDetail;
    @JsonProperty(value = "isCancel")
    private Integer isCancel;

    public void setTaskDetail(DCNurseTask taskDetail)
    {
        this.taskDetail = taskDetail;
    }
    public DCNurseTask getTaskDetail()
    {
        return this.taskDetail;
    }
    public void setIsCancel(Integer isCancel)
    {
        this.isCancel = isCancel;
    }
    public Integer getIsCancel()
    {
        return this.isCancel;
    }
}
