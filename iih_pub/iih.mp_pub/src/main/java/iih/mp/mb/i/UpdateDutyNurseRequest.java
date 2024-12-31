package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class UpdateDutyNurseRequest
{
    @JsonProperty(value = "patientId")
    private String patientId;
    @JsonProperty(value = "times")
    private String times;
    @JsonProperty(value = "nurseSn")
    private String nurseSn;

    public void setPatientId(String patientId)
    {
        this.patientId = patientId;
    }
    public String getPatientId()
    {
        return this.patientId;
    }
    public void setTimes(String times)
    {
        this.times = times;
    }
    public String getTimes()
    {
        return this.times;
    }
    public void setNurseSn(String nurseSn)
    {
        this.nurseSn = nurseSn;
    }
    public String getNurseSn()
    {
        return this.nurseSn;
    }
}
