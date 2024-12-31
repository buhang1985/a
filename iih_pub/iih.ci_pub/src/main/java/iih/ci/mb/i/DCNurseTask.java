package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCNurseTask
{
    @JsonProperty(value = "Content")
    private String Content;
    @JsonProperty(value = "ID")
    private String ID;
    @JsonProperty(value = "NurseTaskTypeID")
    private Integer NurseTaskTypeID;
    @JsonProperty(value = "NurseTaskType")
    private String NurseTaskType;
    @JsonProperty(value = "SchduleDateTime")
    private String SchduleDateTime;
    @JsonProperty(value = "ExecuteNurseID")
    private String ExecuteNurseID;
    @JsonProperty(value = "ExecuteNurseName")
    private String ExecuteNurseName;
    @JsonProperty(value = "ExecuteDateTime")
    private String ExecuteDateTime;

    public void setContent(String Content)
    {
        this.Content = Content;
    }
    public String getContent()
    {
        return this.Content;
    }
    public void setID(String ID)
    {
        this.ID = ID;
    }
    public String getID()
    {
        return this.ID;
    }
    public void setNurseTaskTypeID(Integer NurseTaskTypeID)
    {
        this.NurseTaskTypeID = NurseTaskTypeID;
    }
    public Integer getNurseTaskTypeID()
    {
        return this.NurseTaskTypeID;
    }
    public void setNurseTaskType(String NurseTaskType)
    {
        this.NurseTaskType = NurseTaskType;
    }
    public String getNurseTaskType()
    {
        return this.NurseTaskType;
    }
    public void setSchduleDateTime(String SchduleDateTime)
    {
        this.SchduleDateTime = SchduleDateTime;
    }
    public String getSchduleDateTime()
    {
        return this.SchduleDateTime;
    }
    public void setExecuteNurseID(String ExecuteNurseID)
    {
        this.ExecuteNurseID = ExecuteNurseID;
    }
    public String getExecuteNurseID()
    {
        return this.ExecuteNurseID;
    }
    public void setExecuteNurseName(String ExecuteNurseName)
    {
        this.ExecuteNurseName = ExecuteNurseName;
    }
    public String getExecuteNurseName()
    {
        return this.ExecuteNurseName;
    }
    public void setExecuteDateTime(String ExecuteDateTime)
    {
        this.ExecuteDateTime = ExecuteDateTime;
    }
    public String getExecuteDateTime()
    {
        return this.ExecuteDateTime;
    }
}
