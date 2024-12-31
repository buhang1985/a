package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetVitalSignOfPatientHRAtTimePoint_NewRequest
{
    @JsonProperty(value = "patientHRID")
    private String patientHRID;
    @JsonProperty(value = "subID")
    private String subID;
    @JsonProperty(value = "deptCode")
    private String deptCode;
    @JsonProperty(value = "timePoint")
    private String timePoint;

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
    public void setDeptCode(String deptCode)
    {
        this.deptCode = deptCode;
    }
    public String getDeptCode()
    {
        return this.deptCode;
    }
    public void setTimePoint(String timePoint)
    {
        this.timePoint = timePoint;
    }
    public String getTimePoint()
    {
        return this.timePoint;
    }
}