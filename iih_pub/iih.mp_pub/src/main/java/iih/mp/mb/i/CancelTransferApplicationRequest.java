package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class CancelTransferApplicationRequest
{
    @JsonProperty(value = "patientId")
    private String patientId;
    @JsonProperty(value = "times")
    private String times;
    @JsonProperty(value = "trans_times")
    private String trans_times;

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
    public void setTrans_times(String trans_times)
    {
        this.trans_times = trans_times;
    }
    public String getTrans_times()
    {
        return this.trans_times;
    }
}
