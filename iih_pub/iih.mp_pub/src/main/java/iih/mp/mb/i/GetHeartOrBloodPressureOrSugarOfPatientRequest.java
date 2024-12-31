package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetHeartOrBloodPressureOrSugarOfPatientRequest
{
    @JsonProperty(value = "Subid")
    private String Subid;
    @JsonProperty(value = "deptCode")
    private String deptCode;
    @JsonProperty(value = "PatientID")
    private String PatientID;
    @JsonProperty(value = "TypeInfo")
    private String TypeInfo;

    public void setSubid(String Subid)
    {
        this.Subid = Subid;
    }
    public String getSubid()
    {
        return this.Subid;
    }
    public void setDeptCode(String deptCode)
    {
        this.deptCode = deptCode;
    }
    public String getDeptCode()
    {
        return this.deptCode;
    }
    public void setPatientID(String PatientID)
    {
        this.PatientID = PatientID;
    }
    public String getPatientID()
    {
        return this.PatientID;
    }
    public void setTypeInfo(String TypeInfo)
    {
        this.TypeInfo = TypeInfo;
    }
    public String getTypeInfo()
    {
        return this.TypeInfo;
    }
}
