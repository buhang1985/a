package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class SaveNursingPatrolRequest
{
    @JsonProperty(value = "patientID")
    private String patientID;
    @JsonProperty(value = "nurseID")
    private String nurseID;
    @JsonProperty(value = "dept_sn")
    private String dept_sn;
    @JsonProperty(value = "sickbedId")
    private String sickbedId;
    @JsonProperty(value = "time")
    private String time;
    @JsonProperty(value = "flag")
    private String flag;

    public void setPatientID(String patientID)
    {
        this.patientID = patientID;
    }
    public String getPatientID()
    {
        return this.patientID;
    }
    public void setNurseID(String nurseID)
    {
        this.nurseID = nurseID;
    }
    public String getNurseID()
    {
        return this.nurseID;
    }
    public void setDept_sn(String dept_sn)
    {
        this.dept_sn = dept_sn;
    }
    public String getDept_sn()
    {
        return this.dept_sn;
    }
    public void setSickbedId(String sickbedId)
    {
        this.sickbedId = sickbedId;
    }
    public String getSickbedId()
    {
        return this.sickbedId;
    }
    public void setTime(String time)
    {
        this.time = time;
    }
    public String getTime()
    {
        return this.time;
    }
    public void setFlag(String flag)
    {
        this.flag = flag;
    }
    public String getFlag()
    {
        return this.flag;
    }
}
