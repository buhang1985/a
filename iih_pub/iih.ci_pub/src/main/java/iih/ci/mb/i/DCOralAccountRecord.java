package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCOralAccountRecord
{
    @JsonProperty(value = "ID")
    private String ID;
    @JsonProperty(value = "PatientID")
    private String PatientID;
    @JsonProperty(value = "PatientVisitID")
    private String PatientVisitID;
    @JsonProperty(value = "TimePoint")
    private Long TimePoint;
    @JsonProperty(value = "Title")
    private String Title;
    @JsonProperty(value = "CreateDoctorName")
    private String CreateDoctorName;
    @JsonProperty(value = "FileUrl")
    private String FileUrl;
    @JsonProperty(value = "FileSize")
    private Long FileSize;

    public void setID(String ID)
    {
        this.ID = ID;
    }
    public String getID()
    {
        return this.ID;
    }
    public void setPatientID(String PatientID)
    {
        this.PatientID = PatientID;
    }
    public String getPatientID()
    {
        return this.PatientID;
    }
    public void setPatientVisitID(String PatientVisitID)
    {
        this.PatientVisitID = PatientVisitID;
    }
    public String getPatientVisitID()
    {
        return this.PatientVisitID;
    }
    public void setTimePoint(Long TimePoint)
    {
        this.TimePoint = TimePoint;
    }
    public Long getTimePoint()
    {
        return this.TimePoint;
    }
    public void setTitle(String Title)
    {
        this.Title = Title;
    }
    public String getTitle()
    {
        return this.Title;
    }
    public void setCreateDoctorName(String CreateDoctorName)
    {
        this.CreateDoctorName = CreateDoctorName;
    }
    public String getCreateDoctorName()
    {
        return this.CreateDoctorName;
    }
    public void setFileUrl(String FileUrl)
    {
        this.FileUrl = FileUrl;
    }
    public String getFileUrl()
    {
        return this.FileUrl;
    }
    public void setFileSize(Long FileSize)
    {
        this.FileSize = FileSize;
    }
    public Long getFileSize()
    {
        return this.FileSize;
    }
}
