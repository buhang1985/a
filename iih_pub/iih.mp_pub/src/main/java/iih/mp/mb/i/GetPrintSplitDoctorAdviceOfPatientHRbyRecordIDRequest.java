package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetPrintSplitDoctorAdviceOfPatientHRbyRecordIDRequest
{
    @JsonProperty(value = "patientHRID")
    private String patientHRID;
    @JsonProperty(value = "date")
    private String date;
    @JsonProperty(value = "record")
    private String record;
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
    public void setRecord(String record)
    {
        this.record = record;
    }
    public String getRecord()
    {
        return this.record;
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
