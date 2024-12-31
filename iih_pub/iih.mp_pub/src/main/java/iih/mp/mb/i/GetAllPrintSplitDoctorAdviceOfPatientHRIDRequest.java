package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetAllPrintSplitDoctorAdviceOfPatientHRIDRequest
{
    @JsonProperty(value = "patientHRID")
    private String patientHRID;
    @JsonProperty(value = "plan_occ_time")
    private String plan_occ_time;
    @JsonProperty(value = "comb_no")
    private String comb_no;
    @JsonProperty(value = "flag")
    private String flag;
    @JsonProperty(value = "record_id")
    private String record_id;

    public void setPatientHRID(String patientHRID)
    {
        this.patientHRID = patientHRID;
    }
    public String getPatientHRID()
    {
        return this.patientHRID;
    }
    public void setPlan_occ_time(String plan_occ_time)
    {
        this.plan_occ_time = plan_occ_time;
    }
    public String getPlan_occ_time()
    {
        return this.plan_occ_time;
    }
    public void setComb_no(String comb_no)
    {
        this.comb_no = comb_no;
    }
    public String getComb_no()
    {
        return this.comb_no;
    }
    public void setFlag(String flag)
    {
        this.flag = flag;
    }
    public String getFlag()
    {
        return this.flag;
    }
    public void setRecord_id(String record_id)
    {
        this.record_id = record_id;
    }
    public String getRecord_id()
    {
        return this.record_id;
    }
}
