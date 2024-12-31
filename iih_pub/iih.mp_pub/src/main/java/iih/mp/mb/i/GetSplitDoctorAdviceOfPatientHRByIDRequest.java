package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetSplitDoctorAdviceOfPatientHRByIDRequest
{
    @JsonProperty(value = "patientHRID")
    private String patientHRID;
    @JsonProperty(value = "COMB_NO")
    private String COMB_NO;
    @JsonProperty(value = "dt")
    private String dt;

    public void setPatientHRID(String patientHRID)
    {
        this.patientHRID = patientHRID;
    }
    public String getPatientHRID()
    {
        return this.patientHRID;
    }
    public void setCOMB_NO(String COMB_NO)
    {
        this.COMB_NO = COMB_NO;
    }
    public String getCOMB_NO()
    {
        return this.COMB_NO;
    }
    public void setDt(String dt)
    {
        this.dt = dt;
    }
    public String getDt()
    {
        return this.dt;
    }
}
