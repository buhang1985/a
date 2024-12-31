package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetBloodConditionOfPatientNoRequest
{
    @JsonProperty(value = "patientNo")
    private String patientNo;
    @JsonProperty(value = "visitID")
    private String visitID;

    public void setPatientNo(String patientNo)
    {
        this.patientNo = patientNo;
    }
    public String getPatientNo()
    {
        return this.patientNo;
    }
    public void setVisitID(String visitID)
    {
        this.visitID = visitID;
    }
    public String getVisitID()
    {
        return this.visitID;
    }
}
