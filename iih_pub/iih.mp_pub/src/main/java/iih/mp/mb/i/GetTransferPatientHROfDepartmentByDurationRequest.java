package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetTransferPatientHROfDepartmentByDurationRequest
{
    @JsonProperty(value = "departmentID")
    private String departmentID;
    @JsonProperty(value = "dayFromToday")
    private Integer dayFromToday;

    public void setDepartmentID(String departmentID)
    {
        this.departmentID = departmentID;
    }
    public String getDepartmentID()
    {
        return this.departmentID;
    }
    public void setDayFromToday(Integer dayFromToday)
    {
        this.dayFromToday = dayFromToday;
    }
    public Integer getDayFromToday()
    {
        return this.dayFromToday;
    }
}
