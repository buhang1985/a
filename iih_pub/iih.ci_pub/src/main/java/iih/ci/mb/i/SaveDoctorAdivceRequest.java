package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class SaveDoctorAdivceRequest
{
    @JsonProperty(value = "KBID")
    private String KBID;
    @JsonProperty(value = "TitleID")
    private String TitleID;
    @JsonProperty(value = "DoctorID")
    private String DoctorID;
    @JsonProperty(value = "DeptID")
    private String DeptID;
    @JsonProperty(value = "DoctorAdviceList")
    private String DoctorAdviceList;

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
    public void setDoctorAdviceList(String DoctorAdviceList)
    {
        this.DoctorAdviceList = DoctorAdviceList;
    }
    public String getDoctorAdviceList()
    {
        return this.DoctorAdviceList;
    }
}
