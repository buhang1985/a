package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class SaveScheduleResponse
{
    @JsonProperty(value = "SaveScheduleResult")
    private Boolean SaveScheduleResult;

    public void setSaveScheduleResult(Boolean SaveScheduleResult)
    {
        this.SaveScheduleResult = SaveScheduleResult;
    }
    public Boolean getSaveScheduleResult()
    {
        return this.SaveScheduleResult;
    }
}
