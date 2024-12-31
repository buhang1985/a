package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class AddCheckScheduleOfPatientHRRequest
{
    @JsonProperty(value = "checkScheduleList")
    private ArrayOfDCPatientCheckSchedule checkScheduleList;

    public void setCheckScheduleList(ArrayOfDCPatientCheckSchedule checkScheduleList)
    {
        this.checkScheduleList = checkScheduleList;
    }
    public ArrayOfDCPatientCheckSchedule getCheckScheduleList()
    {
        return this.checkScheduleList;
    }
}
