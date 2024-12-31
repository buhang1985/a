package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetAllPatientInfusionTourRequest
{
    @JsonProperty(value = "deptCode")
    private String deptCode;
    @JsonProperty(value = "startDateTime")
    private String startDateTime;
    @JsonProperty(value = "endDateTime")
    private String endDateTime;

    public void setDeptCode(String deptCode)
    {
        this.deptCode = deptCode;
    }
    public String getDeptCode()
    {
        return this.deptCode;
    }
    public void setStartDateTime(String startDateTime)
    {
        this.startDateTime = startDateTime;
    }
    public String getStartDateTime()
    {
        return this.startDateTime;
    }
    public void setEndDateTime(String endDateTime)
    {
        this.endDateTime = endDateTime;
    }
    public String getEndDateTime()
    {
        return this.endDateTime;
    }
}
