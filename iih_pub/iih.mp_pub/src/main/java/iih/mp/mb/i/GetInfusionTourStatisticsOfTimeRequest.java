package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetInfusionTourStatisticsOfTimeRequest
{
    @JsonProperty(value = "StartTime")
    private String StartTime;
    @JsonProperty(value = "EndTime")
    private String EndTime;
    @JsonProperty(value = "DeptCode")
    private String DeptCode;

    public void setStartTime(String StartTime)
    {
        this.StartTime = StartTime;
    }
    public String getStartTime()
    {
        return this.StartTime;
    }
    public void setEndTime(String EndTime)
    {
        this.EndTime = EndTime;
    }
    public String getEndTime()
    {
        return this.EndTime;
    }
    public void setDeptCode(String DeptCode)
    {
        this.DeptCode = DeptCode;
    }
    public String getDeptCode()
    {
        return this.DeptCode;
    }
}
