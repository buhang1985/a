package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetAdviceExcuteStaticsOfDepartmentRequest
{
    @JsonProperty(value = "deptCode")
    private String deptCode;
    @JsonProperty(value = "startDateTime")
    private Long startDateTime;
    @JsonProperty(value = "endDateTime")
    private Long endDateTime;

    public void setDeptCode(String deptCode)
    {
        this.deptCode = deptCode;
    }
    public String getDeptCode()
    {
        return this.deptCode;
    }
    public void setStartDateTime(Long startDateTime)
    {
        this.startDateTime = startDateTime;
    }
    public Long getStartDateTime()
    {
        return this.startDateTime;
    }
    public void setEndDateTime(Long endDateTime)
    {
        this.endDateTime = endDateTime;
    }
    public Long getEndDateTime()
    {
        return this.endDateTime;
    }
}
