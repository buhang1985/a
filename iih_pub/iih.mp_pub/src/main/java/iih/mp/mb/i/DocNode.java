package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DocNode
{
    @JsonProperty(value = "templateID")
    private String templateID;
    @JsonProperty(value = "PatientID")
    private String PatientID;
    @JsonProperty(value = "Name")
    private String Name;
    @JsonProperty(value = "Values")
    private String Values;
    @JsonProperty(value = "NurserID")
    private String NurserID;
    @JsonProperty(value = "NurserName")
    private String NurserName;
    @JsonProperty(value = "times")
    private String times;
    @JsonProperty(value = "datetime")
    private String datetime;
    @JsonProperty(value = "responsible")
    private String responsible;
    @JsonProperty(value = "bk")
    private String bk;

    public void setTemplateID(String templateID)
    {
        this.templateID = templateID;
    }
    public String getTemplateID()
    {
        return this.templateID;
    }
    public void setPatientID(String PatientID)
    {
        this.PatientID = PatientID;
    }
    public String getPatientID()
    {
        return this.PatientID;
    }
    public void setName(String Name)
    {
        this.Name = Name;
    }
    public String getName()
    {
        return this.Name;
    }
    public void setValues(String Values)
    {
        this.Values = Values;
    }
    public String getValues()
    {
        return this.Values;
    }
    public void setNurserID(String NurserID)
    {
        this.NurserID = NurserID;
    }
    public String getNurserID()
    {
        return this.NurserID;
    }
    public void setNurserName(String NurserName)
    {
        this.NurserName = NurserName;
    }
    public String getNurserName()
    {
        return this.NurserName;
    }
    public void setTimes(String times)
    {
        this.times = times;
    }
    public String getTimes()
    {
        return this.times;
    }
    public void setDatetime(String datetime)
    {
        this.datetime = datetime;
    }
    public String getDatetime()
    {
        return this.datetime;
    }
    public void setResponsible(String responsible)
    {
        this.responsible = responsible;
    }
    public String getResponsible()
    {
        return this.responsible;
    }
    public void setBk(String bk)
    {
        this.bk = bk;
    }
    public String getBk()
    {
        return this.bk;
    }
}
