package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class PaitentCallRequest
{
    @JsonProperty(value = "patientHRID")
    private String patientHRID;
    @JsonProperty(value = "subID")
    private String subID;
    @JsonProperty(value = "deptID")
    private String deptID;

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
    public void setDeptID(String deptID)
    {
        this.deptID = deptID;
    }
    public String getDeptID()
    {
        return this.deptID;
    }
}
