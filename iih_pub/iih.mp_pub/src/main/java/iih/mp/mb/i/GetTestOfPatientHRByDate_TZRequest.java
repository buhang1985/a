package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetTestOfPatientHRByDate_TZRequest
{
    @JsonProperty(value = "patientHRID")
    private String patientHRID;
    @JsonProperty(value = "subID")
    private String subID;
    @JsonProperty(value = "startime")
    private String startime;
    @JsonProperty(value = "endtime")
    private String endtime;

    public void setPatientHRID(String patientHRID)
    {
        this.patientHRID = patientHRID;
    }
    public String getPatientHRID()
    {
        return this.patientHRID;
    }
    public void setSubID(String subID)
    {
        this.subID = subID;
    }
    public String getSubID()
    {
        return this.subID;
    }
    public void setStartime(String startime)
    {
        this.startime = startime;
    }
    public String getStartime()
    {
        return this.startime;
    }
    public void setEndtime(String endtime)
    {
        this.endtime = endtime;
    }
    public String getEndtime()
    {
        return this.endtime;
    }
}
