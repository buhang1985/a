package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class SavePatientTransportationRequest
{
    @JsonProperty(value = "nurseID")
    private String nurseID;
    @JsonProperty(value = "applyNO")
    private String applyNO;
    @JsonProperty(value = "execTime")
    private String execTime;
    @JsonProperty(value = "SubCode")
    private String SubCode;
    @JsonProperty(value = "nurseNmae")
    private String nurseNmae;

    public void setNurseID(String nurseID)
    {
        this.nurseID = nurseID;
    }
    public String getNurseID()
    {
        return this.nurseID;
    }
    public void setApplyNO(String applyNO)
    {
        this.applyNO = applyNO;
    }
    public String getApplyNO()
    {
        return this.applyNO;
    }
    public void setExecTime(String execTime)
    {
        this.execTime = execTime;
    }
    public String getExecTime()
    {
        return this.execTime;
    }
    public void setSubCode(String SubCode)
    {
        this.SubCode = SubCode;
    }
    public String getSubCode()
    {
        return this.SubCode;
    }
    public void setNurseNmae(String nurseNmae)
    {
        this.nurseNmae = nurseNmae;
    }
    public String getNurseNmae()
    {
        return this.nurseNmae;
    }
}
