package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetPrintSplitDoctorAdviceOfPatientHRbyIDRequest
{
    @JsonProperty(value = "patientHRID")
    private String patientHRID;
    @JsonProperty(value = "date")
    private String date;
    @JsonProperty(value = "comb_no")
    private String comb_no;
    @JsonProperty(value = "flag")
    private String flag;

    public void setPatientHRID(String patientHRID)
    {
        this.patientHRID = patientHRID;
    }
    public String getPatientHRID()
    {
        return this.patientHRID;
    }
    public void setDate(String date)
    {
        this.date = date;
    }
    public String getDate()
    {
        return this.date;
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
}
