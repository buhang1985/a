package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class NisGetOccDetailRequest
{
    @JsonProperty(value = "StartTime")
    private String StartTime;
    @JsonProperty(value = "EndTime")
    private String EndTime;
    @JsonProperty(value = "Dept_sn")
    private String Dept_sn;
    @JsonProperty(value = "Ward_sn")
    private String Ward_sn;
    @JsonProperty(value = "OccType")
    private String OccType;
    @JsonProperty(value = "PatientList")
    private String PatientList;
    @JsonProperty(value = "longOnceFlag")
    private String longOnceFlag;
    @JsonProperty(value = "nurse_id")
    private String nurse_id;
    @JsonProperty(value = "RetError")
    private String RetError;

    @JsonProperty(value = "bcNo")
    private String bcNo;
    public void setbcNo(String bcNo) {
        this.bcNo = bcNo;
    }
    public String getbcNo() {
        return this.bcNo;
    }
    
    @JsonProperty(value = "hsNo")
    private String hsNo;
    public void sethsNo(String hsNo) {
        this.hsNo = hsNo;
    }
    public String gethsNo() {
        return this.hsNo;
    }
    
    @JsonProperty(value = "bfNo")
    private String bfNo;
    public void setbfNo(String bfNo) {
        this.bfNo = bfNo;
    }
    public String getbfNo() {
        return this.bfNo;
    }
    
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
    public void setDept_sn(String Dept_sn)
    {
        this.Dept_sn = Dept_sn;
    }
    public String getDept_sn()
    {
        return this.Dept_sn;
    }
    public void setWard_sn(String Ward_sn)
    {
        this.Ward_sn = Ward_sn;
    }
    public String getWard_sn()
    {
        return this.Ward_sn;
    }
    public void setOccType(String OccType)
    {
        this.OccType = OccType;
    }
    public String getOccType()
    {
        return this.OccType;
    }
    public void setPatientList(String PatientList)
    {
        this.PatientList = PatientList;
    }
    public String getPatientList()
    {
        return this.PatientList;
    }
    public void setLongOnceFlag(String longOnceFlag)
    {
        this.longOnceFlag = longOnceFlag;
    }
    public String getLongOnceFlag()
    {
        return this.longOnceFlag;
    }
    public void setNurse_id(String nurse_id)
    {
        this.nurse_id = nurse_id;
    }
    public String getNurse_id()
    {
        return this.nurse_id;
    }
    public void setRetError(String RetError)
    {
        this.RetError = RetError;
    }
    public String getRetError()
    {
        return this.RetError;
    }
}
