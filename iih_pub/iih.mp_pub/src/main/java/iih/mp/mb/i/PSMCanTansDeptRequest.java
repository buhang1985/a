package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class PSMCanTansDeptRequest
{
    @JsonProperty(value = "patientId")
    private String patientId;
    @JsonProperty(value = "times")
    private Integer times;
    @JsonProperty(value = "encId")
    private String encId;
    @JsonProperty(value = "flag")
    private Integer flag;

    public void setPatientId(String patientId)
    {
        this.patientId = patientId;
    }
    public String getPatientId()
    {
        return this.patientId;
    }
    public void setTimes(Integer times)
    {
        this.times = times;
    }
    public Integer getTimes()
    {
        return this.times;
    }
    public void setEncId(String encId)
    {
        this.encId = encId;
    }
    public String getEncId()
    {
        return this.encId;
    }
    public void setFlag(Integer flag)
    {
        this.flag = flag;
    }
    public Integer getFlag()
    {
        return this.flag;
    }
}
