package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class AddDoctorAdviceDateTopRequest
{
    @JsonProperty(value = "KBID")
    private String KBID;
    @JsonProperty(value = "TitleID")
    private String TitleID;
    @JsonProperty(value = "DoctorID")
    private String DoctorID;
    @JsonProperty(value = "DeptID")
    private String DeptID;
    @JsonProperty(value = "DoctorAdviceNo")
    private String DoctorAdviceNo;
    @JsonProperty(value = "GroupNO")
    private String GroupNO;

    public void setKBID(String KBID)
    {
        this.KBID = KBID;
    }
    public String getKBID()
    {
        return this.KBID;
    }
    public void setTitleID(String TitleID)
    {
        this.TitleID = TitleID;
    }
    public String getTitleID()
    {
        return this.TitleID;
    }
    public void setDoctorID(String DoctorID)
    {
        this.DoctorID = DoctorID;
    }
    public String getDoctorID()
    {
        return this.DoctorID;
    }
    public void setDeptID(String DeptID)
    {
        this.DeptID = DeptID;
    }
    public String getDeptID()
    {
        return this.DeptID;
    }
    public void setDoctorAdviceNo(String DoctorAdviceNo)
    {
        this.DoctorAdviceNo = DoctorAdviceNo;
    }
    public String getDoctorAdviceNo()
    {
        return this.DoctorAdviceNo;
    }
    public void setGroupNO(String GroupNO)
    {
        this.GroupNO = GroupNO;
    }
    public String getGroupNO()
    {
        return this.GroupNO;
    }
}
