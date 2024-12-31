package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCNursingDocument
{
    @JsonProperty(value = "ID")
    private String ID;
    @JsonProperty(value = "TemplateID")
    private String TemplateID;
    @JsonProperty(value = "PatientID")
    private String PatientID;
    @JsonProperty(value = "VisitID")
    private String VisitID;
    @JsonProperty(value = "GroupKey")
    private String GroupKey;
    @JsonProperty(value = "Title")
    private String Title;
    @JsonProperty(value = "CreateDoctorName")
    private String CreateDoctorName;
    @JsonProperty(value = "CreateDateTime")
    private String CreateDateTime;
    @JsonProperty(value = "SaveDoctorName")
    private String SaveDoctorName;
    @JsonProperty(value = "FinishDateTime")
    private String FinishDateTime;
    @JsonProperty(value = "CurrentVersion")
    private String CurrentVersion;
    @JsonProperty(value = "CurrentState")
    private String CurrentState;
    @JsonProperty(value = "Content")
    private String Content;
    @JsonProperty(value = "SubNursingDocument")
    private ArrayOfDCNursingDocument SubNursingDocument;

    public void setID(String ID)
    {
        this.ID = ID;
    }
    public String getID()
    {
        return this.ID;
    }
    public void setTemplateID(String TemplateID)
    {
        this.TemplateID = TemplateID;
    }
    public String getTemplateID()
    {
        return this.TemplateID;
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
    public void setGroupKey(String GroupKey)
    {
        this.GroupKey = GroupKey;
    }
    public String getGroupKey()
    {
        return this.GroupKey;
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
    public void setCreateDateTime(String CreateDateTime)
    {
        this.CreateDateTime = CreateDateTime;
    }
    public String getCreateDateTime()
    {
        return this.CreateDateTime;
    }
    public void setSaveDoctorName(String SaveDoctorName)
    {
        this.SaveDoctorName = SaveDoctorName;
    }
    public String getSaveDoctorName()
    {
        return this.SaveDoctorName;
    }
    public void setFinishDateTime(String FinishDateTime)
    {
        this.FinishDateTime = FinishDateTime;
    }
    public String getFinishDateTime()
    {
        return this.FinishDateTime;
    }
    public void setCurrentVersion(String CurrentVersion)
    {
        this.CurrentVersion = CurrentVersion;
    }
    public String getCurrentVersion()
    {
        return this.CurrentVersion;
    }
    public void setCurrentState(String CurrentState)
    {
        this.CurrentState = CurrentState;
    }
    public String getCurrentState()
    {
        return this.CurrentState;
    }
    public void setContent(String Content)
    {
        this.Content = Content;
    }
    public String getContent()
    {
        return this.Content;
    }
    public void setSubNursingDocument(ArrayOfDCNursingDocument SubNursingDocument)
    {
        this.SubNursingDocument = SubNursingDocument;
    }
    public ArrayOfDCNursingDocument getSubNursingDocument()
    {
        return this.SubNursingDocument;
    }
}
