package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetExecDoctorAdviceOfPatientHRRequest
{
    @JsonProperty(value = "patientHRID")
    private String patientHRID;
    @JsonProperty(value = "end")
    private Long end;
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
    public void setEnd(Long end)
    {
        this.end = end;
    }
    public Long getEnd()
    {
        return this.end;
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
