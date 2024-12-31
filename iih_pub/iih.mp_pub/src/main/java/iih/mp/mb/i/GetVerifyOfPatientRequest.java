package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetVerifyOfPatientRequest
{
    @JsonProperty(value = "PatientNo")
    private String PatientNo;
    @JsonProperty(value = "VisitSn")
    private String VisitSn;

    public void setPatientNo(String PatientNo)
    {
        this.PatientNo = PatientNo;
    }
    public String getPatientNo()
    {
        return this.PatientNo;
    }
    public void setVisitSn(String VisitSn)
    {
        this.VisitSn = VisitSn;
    }
    public String getVisitSn()
    {
        return this.VisitSn;
    }
}
