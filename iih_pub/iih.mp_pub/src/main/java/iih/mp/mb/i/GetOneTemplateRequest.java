package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetOneTemplateRequest
{
    @JsonProperty(value = "patientID")
    private String patientID;
    @JsonProperty(value = "templateID")
    private String templateID;
    @JsonProperty(value = "nuserID")
    private String nuserID;
    @JsonProperty(value = "times")
    private String times;
    @JsonProperty(value = "datetime")
    private String datetime;
    @JsonProperty(value = "nid")
    private String nid;

    public void setPatientID(String patientID)
    {
        this.patientID = patientID;
    }
    public String getPatientID()
    {
        return this.patientID;
    }
    public void setTemplateID(String templateID)
    {
        this.templateID = templateID;
    }
    public String getTemplateID()
    {
        return this.templateID;
    }
    public void setNuserID(String nuserID)
    {
        this.nuserID = nuserID;
    }
    public String getNuserID()
    {
        return this.nuserID;
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
    public void setNid(String nid)
    {
        this.nid = nid;
    }
    public String getNid()
    {
        return this.nid;
    }
}
