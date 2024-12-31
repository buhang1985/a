package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class PSMTransDeptApply
{
    @JsonProperty(value = "Name")
    private String Name;
    @JsonProperty(value = "Sex")
    private String Sex;
    @JsonProperty(value = "PatientId")
    private String PatientId;
    @JsonProperty(value = "AdmissTimes")
    private Integer AdmissTimes;
    @JsonProperty(value = "InPatientNo")
    private String InPatientNo;
    @JsonProperty(value = "TransTimes")
    private Integer TransTimes;
    @JsonProperty(value = "DisDate")
    private String DisDate;
    @JsonProperty(value = "TransDate")
    private String TransDate;
    @JsonProperty(value = "OrigDeptCode")
    private String OrigDeptCode;
    @JsonProperty(value = "OrigDeptName")
    private String OrigDeptName;
    @JsonProperty(value = "OrigWardCode")
    private String OrigWardCode;
    @JsonProperty(value = "OrigWardName")
    private String OrigWardName;
    @JsonProperty(value = "OrigRoom")
    private String OrigRoom;
    @JsonProperty(value = "OrigBedNo")
    private String OrigBedNo;
    @JsonProperty(value = "CurrDeptCode")
    private String CurrDeptCode;
    @JsonProperty(value = "CurrWardCode")
    private String CurrWardCode;
    @JsonProperty(value = "CurrRoom")
    private String CurrRoom;
    @JsonProperty(value = "CurrBedNo")
    private String CurrBedNo;
    @JsonProperty(value = "Mark")
    private Integer Mark;
    @JsonProperty(value = "OrigOperaCode")
    private String OrigOperaCode;
    @JsonProperty(value = "CurrOperaCode")
    private String CurrOperaCode;
    @JsonProperty(value = "ApplyDate")
    private String ApplyDate;
    @JsonProperty(value = "RespDoctorCode")
    private String RespDoctorCode;

    public void setName(String Name)
    {
        this.Name = Name;
    }
    public String getName()
    {
        return this.Name;
    }
    public void setSex(String Sex)
    {
        this.Sex = Sex;
    }
    public String getSex()
    {
        return this.Sex;
    }
    public void setPatientId(String PatientId)
    {
        this.PatientId = PatientId;
    }
    public String getPatientId()
    {
        return this.PatientId;
    }
    public void setAdmissTimes(Integer AdmissTimes)
    {
        this.AdmissTimes = AdmissTimes;
    }
    public Integer getAdmissTimes()
    {
        return this.AdmissTimes;
    }
    public void setInPatientNo(String InPatientNo)
    {
        this.InPatientNo = InPatientNo;
    }
    public String getInPatientNo()
    {
        return this.InPatientNo;
    }
    public void setTransTimes(Integer TransTimes)
    {
        this.TransTimes = TransTimes;
    }
    public Integer getTransTimes()
    {
        return this.TransTimes;
    }
    public void setDisDate(String DisDate)
    {
        this.DisDate = DisDate;
    }
    public String getDisDate()
    {
        return this.DisDate;
    }
    public void setTransDate(String TransDate)
    {
        this.TransDate = TransDate;
    }
    public String getTransDate()
    {
        return this.TransDate;
    }
    public void setOrigDeptCode(String OrigDeptCode)
    {
        this.OrigDeptCode = OrigDeptCode;
    }
    public String getOrigDeptCode()
    {
        return this.OrigDeptCode;
    }
    public void setOrigDeptName(String OrigDeptName)
    {
        this.OrigDeptName = OrigDeptName;
    }
    public String getOrigDeptName()
    {
        return this.OrigDeptName;
    }
    public void setOrigWardCode(String OrigWardCode)
    {
        this.OrigWardCode = OrigWardCode;
    }
    public String getOrigWardCode()
    {
        return this.OrigWardCode;
    }
    public void setOrigWardName(String OrigWardName)
    {
        this.OrigWardName = OrigWardName;
    }
    public String getOrigWardName()
    {
        return this.OrigWardName;
    }
    public void setOrigRoom(String OrigRoom)
    {
        this.OrigRoom = OrigRoom;
    }
    public String getOrigRoom()
    {
        return this.OrigRoom;
    }
    public void setOrigBedNo(String OrigBedNo)
    {
        this.OrigBedNo = OrigBedNo;
    }
    public String getOrigBedNo()
    {
        return this.OrigBedNo;
    }
    public void setCurrDeptCode(String CurrDeptCode)
    {
        this.CurrDeptCode = CurrDeptCode;
    }
    public String getCurrDeptCode()
    {
        return this.CurrDeptCode;
    }
    public void setCurrWardCode(String CurrWardCode)
    {
        this.CurrWardCode = CurrWardCode;
    }
    public String getCurrWardCode()
    {
        return this.CurrWardCode;
    }
    public void setCurrRoom(String CurrRoom)
    {
        this.CurrRoom = CurrRoom;
    }
    public String getCurrRoom()
    {
        return this.CurrRoom;
    }
    public void setCurrBedNo(String CurrBedNo)
    {
        this.CurrBedNo = CurrBedNo;
    }
    public String getCurrBedNo()
    {
        return this.CurrBedNo;
    }
    public void setMark(Integer Mark)
    {
        this.Mark = Mark;
    }
    public Integer getMark()
    {
        return this.Mark;
    }
    public void setOrigOperaCode(String OrigOperaCode)
    {
        this.OrigOperaCode = OrigOperaCode;
    }
    public String getOrigOperaCode()
    {
        return this.OrigOperaCode;
    }
    public void setCurrOperaCode(String CurrOperaCode)
    {
        this.CurrOperaCode = CurrOperaCode;
    }
    public String getCurrOperaCode()
    {
        return this.CurrOperaCode;
    }
    public void setApplyDate(String ApplyDate)
    {
        this.ApplyDate = ApplyDate;
    }
    public String getApplyDate()
    {
        return this.ApplyDate;
    }
    public void setRespDoctorCode(String RespDoctorCode)
    {
        this.RespDoctorCode = RespDoctorCode;
    }
    public String getRespDoctorCode()
    {
        return this.RespDoctorCode;
    }
}
