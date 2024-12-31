package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetStatisticForDoctorAdviceGroupByCureTypeRequest
{
    @JsonProperty(value = "deptCode")
    private String deptCode;
    @JsonProperty(value = "startTime")
    private String startTime;
    @JsonProperty(value = "endTime")
    private String endTime;

    public void setDeptCode(String deptCode)
    {
        this.deptCode = deptCode;
    }
    public String getDeptCode()
    {
        return this.deptCode;
    }
    public void setStartTime(String startTime)
    {
        this.startTime = startTime;
    }
    public String getStartTime()
    {
        return this.startTime;
    }
    public void setEndTime(String endTime)
    {
        this.endTime = endTime;
    }
    public String getEndTime()
    {
        return this.endTime;
    }
}
