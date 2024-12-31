package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetScheduleOfDateResponse
{
    @JsonProperty(value = "GetScheduleOfDateResult")
    private DCSchedule GetScheduleOfDateResult;

    public void setGetScheduleOfDateResult(DCSchedule GetScheduleOfDateResult)
    {
        this.GetScheduleOfDateResult = GetScheduleOfDateResult;
    }
    public DCSchedule getGetScheduleOfDateResult()
    {
        return this.GetScheduleOfDateResult;
    }
}
