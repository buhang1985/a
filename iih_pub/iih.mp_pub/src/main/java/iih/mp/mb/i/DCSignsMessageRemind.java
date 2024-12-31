package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCSignsMessageRemind
{
    @JsonProperty(value = "Name")
    private String Name;
    @JsonProperty(value = "BedNO")
    private String BedNO;
    @JsonProperty(value = "PatientID")
    private String PatientID;
    @JsonProperty(value = "VisitID")
    private String VisitID;
    @JsonProperty(value = "EventDateTime")
    private String EventDateTime;
    @JsonProperty(value = "Type")
    private Integer Type;
    @JsonProperty(value = "Value")
    private String Value;

    public void setName(String Name)
    {
        this.Name = Name;
    }
    public String getName()
    {
        return this.Name;
    }
    public void setBedNO(String BedNO)
    {
        this.BedNO = BedNO;
    }
    public String getBedNO()
    {
        return this.BedNO;
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
    public void setEventDateTime(String EventDateTime)
    {
        this.EventDateTime = EventDateTime;
    }
    public String getEventDateTime()
    {
        return this.EventDateTime;
    }
    public void setType(Integer Type)
    {
        this.Type = Type;
    }
    public Integer getType()
    {
        return this.Type;
    }
    public void setValue(String Value)
    {
        this.Value = Value;
    }
    public String getValue()
    {
        return this.Value;
    }
}
