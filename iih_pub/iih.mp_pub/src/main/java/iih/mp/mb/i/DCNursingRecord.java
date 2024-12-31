package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCNursingRecord
{
    @JsonProperty(value = "ID")
    private String ID;
    @JsonProperty(value = "PatientID")
    private String PatientID;
    @JsonProperty(value = "VisitID")
    private String VisitID;
    @JsonProperty(value = "IsBaby")
    private String IsBaby;
    @JsonProperty(value = "CreateDateTime")
    private String CreateDateTime;
    @JsonProperty(value = "SaveDateTime")
    private String SaveDateTime;
    @JsonProperty(value = "DepartmentName")
    private String DepartmentName;
    @JsonProperty(value = "CareLevel")
    private String CareLevel;
    @JsonProperty(value = "TypeName")
    private String TypeName;
    @JsonProperty(value = "RecorderID")
    private String RecorderID;
    @JsonProperty(value = "Recorder")
    private String Recorder;
    @JsonProperty(value = "ItemList")
    private ArrayOfDCNursingRecordItem ItemList;

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
    public void setVisitID(String VisitID)
    {
        this.VisitID = VisitID;
    }
    public String getVisitID()
    {
        return this.VisitID;
    }
    public void setIsBaby(String IsBaby)
    {
        this.IsBaby = IsBaby;
    }
    public String getIsBaby()
    {
        return this.IsBaby;
    }
    public void setCreateDateTime(String CreateDateTime)
    {
        this.CreateDateTime = CreateDateTime;
    }
    public String getCreateDateTime()
    {
        return this.CreateDateTime;
    }
    public void setSaveDateTime(String SaveDateTime)
    {
        this.SaveDateTime = SaveDateTime;
    }
    public String getSaveDateTime()
    {
        return this.SaveDateTime;
    }
    public void setDepartmentName(String DepartmentName)
    {
        this.DepartmentName = DepartmentName;
    }
    public String getDepartmentName()
    {
        return this.DepartmentName;
    }
    public void setCareLevel(String CareLevel)
    {
        this.CareLevel = CareLevel;
    }
    public String getCareLevel()
    {
        return this.CareLevel;
    }
    public void setTypeName(String TypeName)
    {
        this.TypeName = TypeName;
    }
    public String getTypeName()
    {
        return this.TypeName;
    }
    public void setRecorderID(String RecorderID)
    {
        this.RecorderID = RecorderID;
    }
    public String getRecorderID()
    {
        return this.RecorderID;
    }
    public void setRecorder(String Recorder)
    {
        this.Recorder = Recorder;
    }
    public String getRecorder()
    {
        return this.Recorder;
    }
    public void setItemList(ArrayOfDCNursingRecordItem ItemList)
    {
        this.ItemList = ItemList;
    }
    public ArrayOfDCNursingRecordItem getItemList()
    {
        return this.ItemList;
    }
}
