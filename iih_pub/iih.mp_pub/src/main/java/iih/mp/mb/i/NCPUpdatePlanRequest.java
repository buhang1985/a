package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class NCPUpdatePlanRequest
{
    @JsonProperty(value = "patientId")
    private String patientId;
    @JsonProperty(value = "times")
    private String times;
    @JsonProperty(value = "plan")
    private NCPPlan plan;

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
    public void setPlan(NCPPlan plan)
    {
        this.plan = plan;
    }
    public NCPPlan getPlan()
    {
        return this.plan;
    }
}
