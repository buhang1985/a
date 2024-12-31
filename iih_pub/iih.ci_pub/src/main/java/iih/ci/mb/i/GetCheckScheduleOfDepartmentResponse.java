package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetCheckScheduleOfDepartmentResponse
{
    @JsonProperty(value = "GetCheckScheduleOfDepartmentResult")
    private ArrayOfDCPatientCheckSchedule GetCheckScheduleOfDepartmentResult;

    public void setGetCheckScheduleOfDepartmentResult(ArrayOfDCPatientCheckSchedule GetCheckScheduleOfDepartmentResult)
    {
        this.GetCheckScheduleOfDepartmentResult = GetCheckScheduleOfDepartmentResult;
    }
    public ArrayOfDCPatientCheckSchedule getGetCheckScheduleOfDepartmentResult()
    {
        return this.GetCheckScheduleOfDepartmentResult;
    }
}
