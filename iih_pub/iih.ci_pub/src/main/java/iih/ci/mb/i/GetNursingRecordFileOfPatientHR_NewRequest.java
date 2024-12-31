package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetNursingRecordFileOfPatientHR_NewRequest
{
    @JsonProperty(value = "patientHRID")
    private String patientHRID;
    @JsonProperty(value = "subID")
    private String subID;
    @JsonProperty(value = "deptCode")
    private String deptCode;
    @JsonProperty(value = "deptName")
    private String deptName;
    @JsonProperty(value = "nurseName")
    private String nurseName;
    @JsonProperty(value = "nurseID")
    private String nurseID;
    @JsonProperty(value = "fileType")
    private String fileType;

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
    public void setDeptName(String deptName)
    {
        this.deptName = deptName;
    }
    public String getDeptName()
    {
        return this.deptName;
    }
    public void setNurseName(String nurseName)
    {
        this.nurseName = nurseName;
    }
    public String getNurseName()
    {
        return this.nurseName;
    }
    public void setNurseID(String nurseID)
    {
        this.nurseID = nurseID;
    }
    public String getNurseID()
    {
        return this.nurseID;
    }
    public void setFileType(String fileType)
    {
        this.fileType = fileType;
    }
    public String getFileType()
    {
        return this.fileType;
    }
}
