package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCDoctorMemorandum
{
    @JsonProperty(value = "GUID")
    private String GUID;
    @JsonProperty(value = "PatientID")
    private String PatientID;
    @JsonProperty(value = "VisitID")
    private String VisitID;
    @JsonProperty(value = "Title")
    private String Title;
    @JsonProperty(value = "Content")
    private String Content;
    @JsonProperty(value = "CreateTime")
    private String CreateTime;
    @JsonProperty(value = "CreateDoctorName")
    private String CreateDoctorName;

    public void setGUID(String GUID)
    {
        this.GUID = GUID;
    }
    public String getGUID()
    {
        return this.GUID;
    }
    public void setPatientID(String PatientID)
    {
        this.PatientID = PatientID;
    }
    public String getPatientID()
    {
        return this.PatientID;
    }
    public void setVisitID(String VisitID)
    {
        this.VisitID = VisitID;
    }
    public String getVisitID()
    {
        return this.VisitID;
    }
    public void setTitle(String Title)
    {
        this.Title = Title;
    }
    public String getTitle()
    {
        return this.Title;
    }
    public void setContent(String Content)
    {
        this.Content = Content;
    }
    public String getContent()
    {
        return this.Content;
    }
    public void setCreateTime(String CreateTime)
    {
        this.CreateTime = CreateTime;
    }
    public String getCreateTime()
    {
        return this.CreateTime;
    }
    public void setCreateDoctorName(String CreateDoctorName)
    {
        this.CreateDoctorName = CreateDoctorName;
    }
    public String getCreateDoctorName()
    {
        return this.CreateDoctorName;
    }
}
