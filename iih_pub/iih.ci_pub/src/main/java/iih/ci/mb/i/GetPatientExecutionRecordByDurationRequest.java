package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetPatientExecutionRecordByDurationRequest
{
    @JsonProperty(value = "patientHRID")
    private String patientHRID;
    @JsonProperty(value = "subID")
    private String subID;
    @JsonProperty(value = "startDate")
    private Long startDate;
    @JsonProperty(value = "endDate")
    private Long endDate;

    public void setPatientHRID(String patientHRID)
    {
        this.patientHRID = patientHRID;
    }
    public String getPatientHRID()
    {
        return this.patientHRID;
    }
    public void setSubID(String subID)
    {
        this.subID = subID;
    }
    public String getSubID()
    {
        return this.subID;
    }
    public void setStartDate(Long startDate)
    {
        this.startDate = startDate;
    }
    public Long getStartDate()
    {
        return this.startDate;
    }
    public void setEndDate(Long endDate)
    {
        this.endDate = endDate;
    }
    public Long getEndDate()
    {
        return this.endDate;
    }
}
